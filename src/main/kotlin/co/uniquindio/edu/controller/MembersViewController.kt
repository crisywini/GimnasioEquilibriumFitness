package co.uniquindio.edu.controller

import co.uniquindio.edu.business.AdminEJB
import co.uniquindio.edu.exceptions.EntityNullException
import co.uniquindio.edu.exceptions.EntityRepeatedException
import co.uniquindio.edu.model.Member
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.cell.PropertyValueFactory
import java.lang.Exception

class MembersViewController {

    @FXML lateinit var codeMemberField:TextField
    @FXML lateinit var nameMemberField:TextField
    @FXML lateinit var lastNameMemberField:TextField
    @FXML lateinit var telephoneField:TextField
    @FXML lateinit var emailMemberField:TextField
    @FXML lateinit var memberTableView:TableView<Member>
    @FXML lateinit var codeMemberColumn:TableColumn<Member, String>
    @FXML lateinit var nameMemberColumn:TableColumn<Member, String>
    @FXML lateinit var lastNameMemberColumn:TableColumn<Member, String>
    @FXML lateinit var telephoneMemberColumn:TableColumn<Member, String>
    @FXML lateinit var emailMemberColumn:TableColumn<Member, String>
    val adminEJB:AdminEJB = AdminEJB()

    @FXML
    fun handleAddButton(e:ActionEvent){
        if(isInputValid()){
            try {
                adminEJB.addMember(codeMemberField.text, nameMemberField.text, lastNameMemberField.text, telephoneField.text, emailMemberField.text)
                fillTableView()
                InitViewController.showAlert("Miembro agregado con éxito","INFORMACIÓN","",Alert.AlertType.INFORMATION)
                codeMemberField.text = ""
                nameMemberField.text = ""
                lastNameMemberField.text = ""
                telephoneField.text = ""
                emailMemberField.text = ""
            }catch (e:EntityRepeatedException){
                InitViewController.showAlert(e.message.toString(),"ERROR","",Alert.AlertType.ERROR)
            }
        }

    }
    @FXML
    fun handleSearchButton(e:ActionEvent){
        if(!codeMemberField.text.isNullOrEmpty()){
            memberTableView.items.clear()
            try {
                memberTableView.items.setAll(adminEJB.getMemberByCode(codeMemberField.text))
                memberTableView.refresh()
                codeMemberField.text = ""
                nameMemberField.text = ""
                lastNameMemberField.text = ""
                telephoneField.text = ""
                emailMemberField.text = ""
            }catch (e:EntityNullException){
                InitViewController.showAlert(e.message.toString(),"ERROR","",Alert.AlertType.ERROR)
            }
        }else{
            InitViewController.showAlert("Debes ingresar la cédula del miembro","ADVERTENCIA","",Alert.AlertType.WARNING)
        }
    }
    @FXML
    fun handleUpdateButton(e:ActionEvent){
        if(isInputValid()){
            try{
                adminEJB.updateMember(codeMemberField.text,nameMemberField.text,lastNameMemberField.text,telephoneField.text,emailMemberField.text)
                InitViewController.showAlert("Miembro: ${codeMemberField.text} actualizado","ADVERTENCIA","",Alert.AlertType.WARNING)
                fillTableView()
                codeMemberField.text = ""
                nameMemberField.text = ""
                lastNameMemberField.text = ""
                telephoneField.text = ""
                emailMemberField.text = ""
           }catch(e:EntityNullException){
                InitViewController.showAlert(e.message.toString(),"ERROR","",Alert.AlertType.ERROR)
            }
        }
    }
    @FXML
    fun handleCleanButton(e:ActionEvent){
        fillTableView()
    }

    fun isInputValid():Boolean{
        var errorMessage = ""
        var result = false
        if(codeMemberField.text.isNullOrEmpty()){
            errorMessage+="Debes ingresar la cédula\n"
        }else{
            try{
                codeMemberField.text.toInt()
            }catch (e:Exception){
                errorMessage+="La cédula solo debe contener números"
            }
        }
        if(nameMemberField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar el nombre\n"
        }
        if(lastNameMemberField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar el apellido\n"
        }
        if(telephoneField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar el número de teléfono\n"
        }
        if(emailMemberField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar el correo\n"
        }

        if(errorMessage.isNullOrEmpty()){
            result = true

        }else{
            InitViewController.showAlert(errorMessage, "ADVERTENCIA","",Alert.AlertType.WARNING)
        }
        return result
    }
    fun initTableView(){
        codeMemberColumn.cellValueFactory = PropertyValueFactory<Member,String>("code")
        nameMemberColumn.cellValueFactory = PropertyValueFactory<Member,String>("name")
        lastNameMemberColumn.cellValueFactory = PropertyValueFactory<Member,String>("lastName")
        telephoneMemberColumn.cellValueFactory = PropertyValueFactory<Member,String>("phoneNumber")
        emailMemberColumn.cellValueFactory = PropertyValueFactory<Member,String>("email")
        fillTableView()
    }
    fun fillTableView(){
        memberTableView.items.clear()
        memberTableView.items.setAll(adminEJB.getAllMembers())
        memberTableView.refresh()
    }
}