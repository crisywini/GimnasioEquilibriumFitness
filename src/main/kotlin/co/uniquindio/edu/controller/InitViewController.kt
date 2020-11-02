package co.uniquindio.edu.controller

import co.uniquindio.edu.AppGEF
import co.uniquindio.edu.databaseConnection.DatabaseUtil
import co.uniquindio.edu.model.Secretary
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.layout.BorderPane

class InitViewController {
    @FXML lateinit var logginViewController: LogginViewController
    @FXML lateinit var rootPane:BorderPane

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


    fun loadSecretaryView(secretary: Secretary){
        try {
            val loader = FXMLLoader(AppGEF::class.java.getResource("/SecretaryView.fxml"))
            val parent: Parent = loader.load()
            val controller: SecretaryViewController = loader.getController()
            controller.secretary = secretary
            controller.membersViewController.initTableView()
            controller.membershipsViewController.secretary = secretary
            controller.membershipsViewController.initTableView()
            controller.membershipsViewController.initScholarshipComboBox()
            controller.paymentViewController.initComboBox()
            controller.paymentViewController.initTableView()
            controller.assignAppointmentViewController.initTableView()

            rootPane.center=parent
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

}