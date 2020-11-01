package co.uniquindio.edu

import co.uniquindio.edu.business.AdminEJB
import co.uniquindio.edu.controller.InitViewController
import co.uniquindio.edu.databaseConnection.DatabaseUtil
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class AppGEF():Application() {
    override fun start(primaryStage: Stage?) {

        /*
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
        primaryStage?.show()*/
        //val admin:AdminEJB = AdminEJB()
        //admin.addSecretary("100","patri","sango","hj@asd","456", "456")
        //admin.addTrainer("100","patri","sango","hj@asd","456", "456")
        //admin.addMember("1233","54","654", "456", "45600")
        //admin.updateSecretary("100", "latrice", "royale", "latriceRoyale@hotmail.com", "123456", "456")
        //admin.updateTrainer("100","manila","luzon","manilalluzon@mail.com","45679","456")
        //admin.removeTrainer("100")
        //println(admin.getAllTrainers())


        System.exit(0)
    }
    companion object{

        @JvmStatic
        fun main(args:Array<String>){
            launch(AppGEF::class.java)
        }
    }
}