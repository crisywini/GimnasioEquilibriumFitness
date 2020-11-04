package co.uniquindio.edu.controller

import co.uniquindio.edu.business.AdminEJB
import co.uniquindio.edu.model.Trainer
import co.uniquindio.edu.view.PhysicalAssessmentObservable
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import java.lang.Exception
import java.sql.Date
import java.time.LocalDate

class PhysicalAssessmentViewController {
    @FXML
    lateinit var codeMemberLabel: Label
    @FXML
    lateinit var heightField: TextField
    @FXML
    lateinit var weightField: TextField
    @FXML
    lateinit var armsField: TextField
    @FXML
    lateinit var legsField: TextField
    @FXML
    lateinit var hipsField: TextField
    @FXML
    lateinit var personalGoalsArea: TextArea
    @FXML
    lateinit var physicalAssessmentTableView: TableView<PhysicalAssessmentObservable>
    @FXML
    lateinit var codeColumn: TableColumn<PhysicalAssessmentObservable, String>
    @FXML
    lateinit var memberCodeColumn: TableColumn<PhysicalAssessmentObservable, String>
    @FXML
    lateinit var heightColumn: TableColumn<PhysicalAssessmentObservable, String>
    @FXML
    lateinit var weightColumn: TableColumn<PhysicalAssessmentObservable, String>
    @FXML
    lateinit var armsColumn: TableColumn<PhysicalAssessmentObservable, String>
    @FXML
    lateinit var legsColumn: TableColumn<PhysicalAssessmentObservable, String>
    @FXML
    lateinit var hipsColumn: TableColumn<PhysicalAssessmentObservable, String>
    @FXML
    lateinit var personalGoalsColumn: TableColumn<PhysicalAssessmentObservable, String>
    @FXML lateinit var dateColumn: TableColumn<PhysicalAssessmentObservable, String>

    @FXML lateinit var datePicker: DatePicker

    private val adminEJB: AdminEJB = AdminEJB()
    lateinit var trainer: Trainer

    @FXML
    fun handleUpdateButton(e: ActionEvent){
        if(physicalAssessmentTableView.selectionModel.selectedItem != null) {
            if (isInputValid()) {
                val itemSelected = physicalAssessmentTableView.selectionModel.selectedItem
                adminEJB.updatePhysicalAssessment(itemSelected.code.toInt(), heightField.text.toDouble(), weightField.text.toDouble(), armsField.text.toDouble(), legsField.text.toDouble(), hipsField.text.toDouble(), personalGoalsArea.text, trainer.code, Date.valueOf(datePicker.value))
                codeMemberLabel.text = "miembro"
                heightField.text = ""
                weightField.text = ""
                armsField.text = ""
                legsField.text = ""
                hipsField.text = ""
                personalGoalsArea.text = ""
                datePicker.value = null
                InitViewController.showAlert("Valoración Física realizada con éxito!", "INFORMACIÓN", "", Alert.AlertType.INFORMATION)
                fillTableView()
            }
        }else{
            InitViewController.showAlert("Debes seleccionar una valoración pendiente", "ADVERTENCIA","", Alert.AlertType.WARNING)
        }
    }
    @FXML
    fun handleSelectButton(e: ActionEvent){
        if(physicalAssessmentTableView.selectionModel.selectedItem != null){
            val itemSelected = physicalAssessmentTableView.selectionModel.selectedItem
            codeMemberLabel.text = adminEJB.getMembershipByCode(itemSelected.membership.toInt()).member.code
            heightField.text = itemSelected.height
            weightField.text = itemSelected.weight
            armsField.text = itemSelected.arms
            legsField.text = itemSelected.legs
            hipsField.text = itemSelected.hips
            datePicker.value = LocalDate.parse(itemSelected.date)
            personalGoalsArea.text = itemSelected.personalGoals
        }else{
            InitViewController.showAlert("Debes seleccionar una valoración pendiente", "ADVERTENCIA","", Alert.AlertType.WARNING)
        }
    }
    fun initTableView(){
        codeColumn.cellValueFactory = PropertyValueFactory<PhysicalAssessmentObservable, String>("code")
        memberCodeColumn.cellValueFactory = PropertyValueFactory<PhysicalAssessmentObservable, String>("member")
        heightColumn.cellValueFactory = PropertyValueFactory<PhysicalAssessmentObservable, String>("height")
        weightColumn.cellValueFactory = PropertyValueFactory<PhysicalAssessmentObservable, String>("weight")
        armsColumn.cellValueFactory = PropertyValueFactory<PhysicalAssessmentObservable, String>("arms")
        legsColumn.cellValueFactory = PropertyValueFactory<PhysicalAssessmentObservable, String>("legs")
        hipsColumn.cellValueFactory = PropertyValueFactory<PhysicalAssessmentObservable, String>("hips")
        personalGoalsColumn.cellValueFactory = PropertyValueFactory<PhysicalAssessmentObservable, String>("personalGoals")
        dateColumn.cellValueFactory = PropertyValueFactory<PhysicalAssessmentObservable, String>("date")
        fillTableView()
    }

    fun fillTableView(){
        physicalAssessmentTableView.items.clear()
        var physicalAssessments = adminEJB.getAllPhysicalAssessment()
        for(element in physicalAssessments){
            physicalAssessmentTableView.items.add(PhysicalAssessmentObservable(element.code.toString(),
                    element.date.toString(),
                    element.arms.toString(),
                    element.legs.toString(),
                    element.hips.toString(),
                    element.height.toString(),
                    element.weight.toString(),
                    element.personalGoals,
                    trainer.code,
                    element.membership.code.toString(),
                    adminEJB.getMembershipByCode(element.membership.code).member.code))
        }
        physicalAssessmentTableView.refresh()
    }

    private fun isInputValid():Boolean{
        var errorMessage = ""
        var result = false

        if(datePicker.value == null){
            errorMessage += "Debes ingresar la fecha\n"
        }

        if(heightField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar la altura\n"
        }else{
            try{
                heightField.text.toDouble()
            }catch (e: Exception){
                errorMessage += "La altura deben ser solo dígitos\n"
            }
        }
        if(weightField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar la masa\n"
        }else{
            try{
                heightField.text.toDouble()
            }catch (e: Exception){
                errorMessage += "La masa deben ser solo dígitos\n"
            }
        }
        if(armsField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar el tamaño de los brazos\n"
        }else{
            try{
                heightField.text.toDouble()
            }catch (e: Exception){
                errorMessage += "El tamaño de los brazos deben ser solo dígitos\n"
            }
        }
        if(legsField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar el tamaño de las piernas\n"
        }else{
            try{
                heightField.text.toDouble()
            }catch (e: Exception){
                errorMessage += "El tamaño de las piernas deben ser solo dígitos\n"
            }
        }
        if(hipsField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar el tamaño de la cintura\n"
        }else{
            try{
                heightField.text.toDouble()
            }catch (e: Exception){
                errorMessage += "El tamaño de la cintura deben ser solo dígitos\n"
            }
        }

        if(errorMessage.isNullOrEmpty()){
            result = true
        }else{
            InitViewController.showAlert(errorMessage, "ADVERTENCIA","", Alert.AlertType.WARNING)
        }
        return result
    }
}