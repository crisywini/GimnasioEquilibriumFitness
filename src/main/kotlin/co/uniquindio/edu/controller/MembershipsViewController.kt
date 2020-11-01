package co.uniquindio.edu.controller

import co.uniquindio.edu.business.AdminEJB
import co.uniquindio.edu.model.Scholarship
import co.uniquindio.edu.model.Secretary
import co.uniquindio.edu.view.MembershipObservable
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.ComboBox
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.control.cell.PropertyValueFactory



class MembershipsViewController {

    @FXML lateinit var memberCodeField:TextField
    @FXML lateinit var scholarshipComboBox:ComboBox<Scholarship>
    @FXML lateinit var membershipTableView:TableView<MembershipObservable>
    @FXML lateinit var codeMembershipColumn:TableColumn<MembershipObservable, String>
    @FXML lateinit var nameSecretaryColumn:TableColumn<MembershipObservable, String>
    @FXML lateinit var codeMemberColumn:TableColumn<MembershipObservable, String>
    @FXML lateinit var scholarshipColumn:TableColumn<MembershipObservable, String>

    lateinit var secretary: Secretary
    val adminEJB = AdminEJB()

    @FXML
    fun handleAddButton(e:ActionEvent){

    }
    @FXML
    fun handleSearchButton(e:ActionEvent){

    }
    @FXML
    fun handleUpdateButton(e:ActionEvent){

    }
    @FXML
    fun handleCleanButton(e:ActionEvent){

    }
    fun initScholarshipComboBox(){
        scholarshipComboBox.items.clear()
        scholarshipComboBox.items.add(Scholarship.SCHOOL)
        scholarshipComboBox.items.add(Scholarship.COLLAGE)
        scholarshipComboBox.items.add(Scholarship.POST_GRADE)
        scholarshipComboBox.items.add(Scholarship.NONE)
    }

    fun initTableView(){
        codeMembershipColumn.cellValueFactory = PropertyValueFactory<MembershipObservable,String>("code")
        codeMemberColumn.cellValueFactory = PropertyValueFactory<MembershipObservable,String>("member")
        nameSecretaryColumn.cellValueFactory = PropertyValueFactory<MembershipObservable,String>("secretary")
        scholarshipColumn.cellValueFactory = PropertyValueFactory<MembershipObservable,String>("scholarship")
        fillTableView()
    }

    fun fillTableView(){
        membershipTableView.items.clear()
        var memberships = adminEJB.getAllMemberships()
        for(element in memberships){
            membershipTableView.items.add(MembershipObservable(element.code,element.secretary.name,element.member.code,element.scholarship.name))
        }
        membershipTableView.refresh()
    }
}