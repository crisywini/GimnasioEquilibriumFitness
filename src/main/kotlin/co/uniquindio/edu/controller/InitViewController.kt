package co.uniquindio.edu.controller

import javafx.fxml.FXML
import javafx.scene.control.Alert

class InitViewController {
    @FXML lateinit var logginViewController: LogginViewController

    companion object{
        @JvmStatic
        fun showAlert(message:String, title:String, header:String, alertType: Alert.AlertType){
            val alert:Alert = Alert(alertType)
            alert.title = title
            alert.contentText = message
            alert.headerText = header
            alert.isResizable = true
            alert.showAndWait()
        }
    }
}