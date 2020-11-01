package co.uniquindio.edu.controller

import co.uniquindio.edu.business.AdminEJB
import co.uniquindio.edu.exceptions.EntityNullException
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField

class LogginViewController {
    @FXML lateinit var userField:TextField
    @FXML lateinit var passwordField: PasswordField
    val adminEJB:AdminEJB = AdminEJB()

    @FXML
    fun handleLoginButton(e:ActionEvent){
        if(isInputValid()){
            try {
                var employee = adminEJB.login(userField.text, userField.text)
                InitViewController.showAlert("Bienvenido usuario ${employee.name}", "INFORMACIÓN", "", Alert.AlertType.INFORMATION)
            }catch (e:EntityNullException){
                InitViewController.showAlert(e.message.toString(), "ERROR", "", Alert.AlertType.ERROR)

            }
        }
    }

    @FXML
    fun handleAddUserButton(e:ActionEvent){

    }
    fun isInputValid():Boolean{
        var errorMessage:String = ""
        var result:Boolean = false
        if(userField.text.isNullOrEmpty()){
            errorMessage+="Debes ingresar el usuario\n"
        }
        if(passwordField.text.isNullOrEmpty()){
            errorMessage+="Debes ingresar la contraseña"
        }
        if(errorMessage.isNullOrEmpty()){
            result = true
        }else{
            InitViewController.showAlert(errorMessage,"INFORMACIÓN","",Alert.AlertType.WARNING)
        }
        return result
    }
}