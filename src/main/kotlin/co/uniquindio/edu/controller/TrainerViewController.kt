package co.uniquindio.edu.controller

import co.uniquindio.edu.business.AdminEJB
import co.uniquindio.edu.model.Trainer
import co.uniquindio.edu.view.PhysicalAssessmentObservable
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.*
import java.lang.Exception

class TrainerViewController {
    @FXML lateinit var physicalAssessmentTodayViewController: PhysicalAssessmentTodayViewController
    @FXML lateinit var physicalAssessmentViewController: PhysicalAssessmentViewController
    lateinit var trainer: Trainer
}