package co.uniquindio.edu.controller

import co.uniquindio.edu.model.Secretary
import javafx.fxml.FXML

class SecretaryViewController {

    lateinit var secretary: Secretary
    @FXML lateinit var membersViewController: MembersViewController
    @FXML lateinit var membershipsViewController: MembershipsViewController
    @FXML lateinit var paymentViewController: PaymentViewController
    @FXML lateinit var assignAppointmentViewController: AssignAppointmentViewController
}