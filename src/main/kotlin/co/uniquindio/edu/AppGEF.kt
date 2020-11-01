package co.uniquindio.edu

import co.uniquindio.edu.business.AdminEJB
import co.uniquindio.edu.controller.InitViewController
import co.uniquindio.edu.databaseConnection.DatabaseUtil
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import java.sql.Date

class AppGEF():Application() {
    override fun start(primaryStage: Stage?) {
        val databaseUtil:DatabaseUtil = DatabaseUtil()
        databaseUtil.initDatabaseAndTables()
        val loader = FXMLLoader(AppGEF::class.java.getResource("/InitView.fxml"))
        val parent:Parent = loader.load()
        val controller:InitViewController= loader.getController()
        //controller.showInitView()
        val scene = Scene(parent)
        //Operador para variables que pueden ser nulas
        primaryStage?.scene = scene
        primaryStage?.title = "Gimnasio Equilibrium Fitness"
        primaryStage?.show()

    }
    companion object{

        @JvmStatic
        fun main(args:Array<String>){
            launch(AppGEF::class.java)
        }
    }
}