package co.uniquindio.edu.business

import co.uniquindio.edu.databaseConnection.Connection
import co.uniquindio.edu.model.*
import java.sql.Date
import java.sql.PreparedStatement
import java.sql.SQLException

class AdminEJB : AdminEJBRemote{

    var connection:Connection? = Connection()

    override fun addSecretary(code: String, name: String, lastName: String, email: String, telephone: String, password: String) {
        connection?.getConnectionToDatabase()
        val sql = "INSERT INTO Secretary(code, password, name, last_name, phone_number, email) VALUES(?,?,?,?,?, ?);"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            statement?.setString(1,code)
            statement?.setString(2,password)
            statement?.setString(3,name)
            statement?.setString(4,lastName)
            statement?.setString(5,telephone)
            statement?.setString(6,email)
            val result = statement?.executeUpdate()
            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }

    }

    override fun updateSecretary(code: String, name: String, lastName: String, email: String, telephone: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun removeSecretary(code: String) {
        TODO("Not yet implemented")
    }

    override fun getAllSecretaries(): ArrayList<Secretary> {
        TODO("Not yet implemented")
    }

    override fun addTrainer(code: String, name: String, lastName: String, email: String, telephone: String, password: String) {
        connection?.getConnectionToDatabase()
        val sql = "INSERT INTO Trainer(code, name, password, last_name, phone_number, email) VALUES(?,?,?,?,?, ?);"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            statement?.setString(1,code)
            statement?.setString(2,name)
            statement?.setString(3,password)
            statement?.setString(4,lastName)
            statement?.setString(5,telephone)
            statement?.setString(6,email)
            val result = statement?.executeUpdate()
            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }
    }

    override fun updateTrainer(code: String, name: String, lastName: String, email: String, telephone: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun removeTrainer(code: String) {
        TODO("Not yet implemented")
    }

    override fun getAllTrainers(): ArrayList<Trainer> {
        TODO("Not yet implemented")
    }

    override fun addMember(code: String, name: String, lastName: String, phoneNumber: String, email: String) {
        connection?.getConnectionToDatabase()
        val sql = "INSERT INTO Member(code, name, last_name, phone_number, email) VALUES(?,?,?,?,?);"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            statement?.setString(1,code)
            statement?.setString(2,name)
            statement?.setString(3,lastName)
            statement?.setString(4,phoneNumber)
            statement?.setString(5,email)
            val result = statement?.executeUpdate()
            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }
    }

    override fun removeMember(code: String) {
        TODO("Not yet implemented")
    }

    override fun getAllMembers(): ArrayList<Member> {
        TODO("Not yet implemented")
    }

    override fun updateMember(code: String, name: String, lastName: String, phoneNumber: String, email: String) {
        TODO("Not yet implemented")
    }

    override fun addMembership(code: Int, member: Member, physicalAssessment: PhysicalAssessment, scholarship: Scholarship) {

    }

    override fun removeMembership(code: Int) {
        TODO("Not yet implemented")
    }

    override fun getAllMemberships(): ArrayList<Member> {
        TODO("Not yet implemented")
    }

    override fun addPayment(code: Int, date: Date, total: Double, member: Member, membership: Membership, paymentType: PaymentType) {
        TODO("Not yet implemented")
    }

    override fun addPhysicalAssesment(code: Int, date: Date, arms: Double, legs: Double, hips: Double, height: Double, weight: Double, personalGoals: String, trainer: Trainer) {
        TODO("Not yet implemented")
    }

    override fun updateDatePyhisicalAssesment(code: Int, date: Date) {
        TODO("Not yet implemented")
    }

    override fun removePhysicalAssesment(code: Int) {
        TODO("Not yet implemented")
    }

    override fun getAllPhysicalAssesment(code: Int) {
        TODO("Not yet implemented")
    }
}