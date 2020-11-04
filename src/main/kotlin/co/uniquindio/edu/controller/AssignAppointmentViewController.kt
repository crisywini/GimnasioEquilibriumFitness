package co.uniquindio.edu.controller

import co.uniquindio.edu.business.AdminEJB
import co.uniquindio.edu.exceptions.BusinessException
import co.uniquindio.edu.exceptions.EntityNullException
import co.uniquindio.edu.view.PhysicalAppointmentObservable
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import java.sql.Date

class AssignAppointmentViewController {

    @FXML lateinit var memberCodeField:TextField
    @FXML lateinit var codeTrainerField:TextField
    @FXML lateinit var datePicker:DatePicker
    @FXML lateinit var appointmentsTableView:TableView<PhysicalAppointmentObservable>
    @FXML lateinit var codeColumn:TableColumn<PhysicalAppointmentObservable,String>
    @FXML lateinit var memberCodeColumn:TableColumn<PhysicalAppointmentObservable,String>
    @FXML lateinit var trainerCodeColumn:TableColumn<PhysicalAppointmentObservable,String>
    @FXML lateinit var dateColumn:TableColumn<PhysicalAppointmentObservable,String>

    private val adminEJB = AdminEJB()

    @FXML
    fun handleAddButton(e:ActionEvent){
        if(isInputValid()){
            try{
                adminEJB.addPhysicalAssessment(Date.valueOf(datePicker.value),0.0,0.0,0.0,0.0,0.0,"",codeTrainerField.text,memberCodeField.text)
                memberCodeField.text = ""
                trainerCodeColumn.text = ""
                datePicker.value = null
                fillTableView()
                InitViewController.showAlert("Cita de valoración ingresada con éxito","INFORMACIÓN","",Alert.AlertType.INFORMATION)
            }catch (e:EntityNullException){
                InitViewController.showAlert(e.message.toString(),"ERROR","",Alert.AlertType.ERROR)
            }catch (e:BusinessException){
                InitViewController.showAlert(e.message.toString(),"ERROR","",Alert.AlertType.ERROR)
            }
        }
    }
    @FXML
    fun handleSearchButton(e:ActionEvent){
        if(!memberCodeField.text.isNullOrEmpty()){
            fillTableViewByMemberCode()
            memberCodeField.text = ""
            trainerCodeColumn.text = ""
            datePicker.value = null

        }else{
            InitViewController.showAlert("Debes ingresar la cédula del miembro","ADVERTENCIA","",Alert.AlertType.WARNING)
        }

    }
    @FXML
    fun handleCleanButton(e:ActionEvent){
        fillTableView()
        memberCodeField.text = ""
        trainerCodeColumn.text = ""
        datePicker.value = null
    }
    fun initTableView(){
        codeColumn.cellValueFactory = PropertyValueFactory<PhysicalAppointmentObservable, String>("code")
        memberCodeColumn.cellValueFactory = PropertyValueFactory<PhysicalAppointmentObservable, String>("member")
        trainerCodeColumn.cellValueFactory = PropertyValueFactory<PhysicalAppointmentObservable, String>("trainer")
        dateColumn.cellValueFactory = PropertyValueFactory<PhysicalAppointmentObservable, String>("date")
        fillTableView()
    }

    fun fillTableView(){
        var physicalAssessments = adminEJB.getAllPhysicalAssessment()
        appointmentsTableView.items.clear()
        try{
            for(element in physicalAssessments){
                var membership = adminEJB.getMembershipByCode(element.membership.code)
                var member = adminEJB.getMemberByCode(membership.member.code)
                appointmentsTableView.items.add(PhysicalAppointmentObservable(element.code.toString(),
                                                 member.code, element.trainer.code, element.date.toString()))
            }
        }catch (e:EntityNullException){
            e.printStackTrace()
        }
        appointmentsTableView.refresh()
    }
    fun fillTableViewByMemberCode(){
        var physicalAssessments = adminEJB.getAllPhysicalAssessment()
        appointmentsTableView.items.clear()
        try{
            for(element in physicalAssessments){
                var membership = adminEJB.getMembershipByCode(element.membership.code)
                var member = adminEJB.getMemberByCode(membership.member.code)
                if(member.code == memberCodeField.text) {
                    appointmentsTableView.items.add(PhysicalAppointmentObservable(element.code.toString(),
                            member.code, element.trainer.code, element.date.toString()))
                }
            }
        }catch (e:EntityNullException){
            e.printStackTrace()
        }
        appointmentsTableView.refresh()
    }
    private fun isInputValid():Boolean{
        var errorMessage = ""
        var result = false
        if(memberCodeField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar la cédula del miembro\n"
        }
        if(codeTrainerField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar la cédula del entrenador\n"
        }
        if(datePicker?.value==null){
            errorMessage += "Debes seleccionar una fecha\n"
        }
        if(errorMessage.isNullOrEmpty()){
            result = true
        }else{
            InitViewController.showAlert(errorMessage, "ADVERTENCIA","",Alert.AlertType.WARNING)
        }
        return result
    }

}