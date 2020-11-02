package co.uniquindio.edu.controller

import co.uniquindio.edu.business.AdminEJB
import co.uniquindio.edu.exceptions.EntityNullException
import co.uniquindio.edu.model.PaymentType
import co.uniquindio.edu.view.PaymentObservable
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import java.sql.Date
import java.time.LocalDate

class PaymentViewController {

    @FXML lateinit var   priceLabel:Label
    @FXML lateinit var codeMemberField:TextField
    @FXML lateinit var codeMembershipField:TextField
    @FXML lateinit var paymentTypeComboBox:ComboBox<PaymentType>
    @FXML lateinit var paymentTableView:TableView<PaymentObservable>
    @FXML lateinit var codePaymentColumn:TableColumn<PaymentObservable, String>
    @FXML lateinit var codeMemberColumn:TableColumn<PaymentObservable, String>
    @FXML lateinit var codeMembershipColumn:TableColumn<PaymentObservable, String>
    @FXML lateinit var codePaymentTypeColumn:TableColumn<PaymentObservable, String>
    @FXML lateinit var pricePaymentTypeColumn:TableColumn<PaymentObservable, String>
    @FXML lateinit var datePaymentColumn:TableColumn<PaymentObservable, String>
    private val adminEJB = AdminEJB()
    var totalPrice = 0.0
    @FXML
    fun handleCleanButton(e:ActionEvent){
        fillTableView()
    }

    @FXML
    fun handleSearchByMember(e:ActionEvent){
        if(!codeMemberField.text.isNullOrEmpty()){
            fillTableViewByMemberCode()
            priceLabel.text = "\$0.0"
            codeMemberField.text = ""
            codeMembershipField.text = ""
            paymentTypeComboBox.selectionModel.clearSelection()
        }else{
            InitViewController.showAlert("Debes ingresar el código del miembro","ADVERTENCIA","",Alert.AlertType.WARNING)
        }
    }

    @FXML
    fun handleAddButton(e:ActionEvent){
        if(isInputValid()){
            try {
                var actualDate = LocalDate.now()
                adminEJB.addPayment(Date.valueOf(actualDate), totalPrice, codeMemberField.text, codeMembershipField.text.toInt(), paymentTypeComboBox.selectionModel.selectedIndex + 1)
                priceLabel.text = "\$0.0"
                codeMemberField.text = ""
                codeMembershipField.text = ""
                paymentTypeComboBox.selectionModel.clearSelection()
                InitViewController.showAlert("Pago realizado con éxito", "INFORMACIÓN", "", Alert.AlertType.INFORMATION)
                fillTableView()
            }catch (e:EntityNullException){
                InitViewController.showAlert(e.message.toString(),"ERROR","",Alert.AlertType.ERROR)
            }
        }
    }

    @FXML
    fun handleGeneratePriceButton(e:ActionEvent){
        totalPrice = adminEJB.generateTotalPrice(codeMembershipField.text.toInt())
        priceLabel.text = "\$${this.totalPrice}"
    }

    private fun isInputValid():Boolean{
        var errorMessage = ""
        var result = false
        if(codeMemberField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar la cédula del miembro\n"
        }
        if(codeMembershipField.text.isNullOrEmpty()){
            errorMessage += "Debes ingresar el código de membresía\n"
        }
        if(paymentTypeComboBox.selectionModel.isEmpty){
            errorMessage += "Debes seleccionar el tipo de pago\n"
        }
        if(totalPrice == 0.0){
            errorMessage += "Debes generar el precio primero\n"
        }
        if(errorMessage.isNullOrEmpty()){
            result = true

        }else{
            InitViewController.showAlert(errorMessage,"ADVERTENCIA","",Alert.AlertType.WARNING)
        }
        return result
    }

    fun initComboBox(){
        paymentTypeComboBox.items.clear()
        paymentTypeComboBox.items.add(PaymentType.CREDIT)
        paymentTypeComboBox.items.add(PaymentType.DEBIT)

    }

    fun initTableView(){
        codePaymentTypeColumn.cellValueFactory = PropertyValueFactory<PaymentObservable, String>("paymentType")
        codePaymentColumn.cellValueFactory = PropertyValueFactory<PaymentObservable, String>("code")
        codeMemberColumn.cellValueFactory = PropertyValueFactory<PaymentObservable, String>("member")
        codeMembershipColumn.cellValueFactory = PropertyValueFactory<PaymentObservable, String>("membership")
        pricePaymentTypeColumn.cellValueFactory = PropertyValueFactory<PaymentObservable, String>("total")
        datePaymentColumn.cellValueFactory = PropertyValueFactory<PaymentObservable, String>("date")
        fillTableView()
    }
    fun fillTableView(){
        paymentTableView.items.clear()
        var payments = adminEJB.getAllPayments()
        for(element in payments){
            //var code:String, var date: String, var total:String, var member: String, var membership: String, var paymentType: String
            paymentTableView.items.add(PaymentObservable(element.code.toString(), element.date.toString(),element.total.toString(),
                    element.member.code, element.membership.code.toString(), element.paymentType.toString()))
        }
        paymentTableView.refresh()
    }
    fun fillTableViewByMemberCode(){
        paymentTableView.items.clear()
        try {
            var payments = adminEJB.getPaymentsByMemberCode(codeMemberField.text)
            for (element in payments) {
                paymentTableView.items.add(PaymentObservable(element.code.toString(), element.date.toString(),
                        element.member.code, element.membership.code.toString(), element.paymentType.toString(),
                        element.total.toString()))
            }
            paymentTableView.refresh()
        }catch (e:EntityNullException){
            InitViewController.showAlert(e.message.toString(),"ERROR","",Alert.AlertType.ERROR)
        }
    }
}