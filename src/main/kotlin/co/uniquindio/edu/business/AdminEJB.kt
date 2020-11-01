package co.uniquindio.edu.business

import co.uniquindio.edu.databaseConnection.Connection
import co.uniquindio.edu.model.*
import java.sql.Date
import java.sql.PreparedStatement
import java.sql.ResultSet
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
        connection?.getConnectionToDatabase()
        val sql = "UPDATE Secretary SET password = \'$password\', name = \'$name\', last_name = \'$lastName\', phone_number = \'$telephone\', email = \'$email\' WHERE code = \'$code\'; "
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val result = statement?.executeUpdate()
            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }
    }

    override fun removeSecretary(code: String) {
        connection?.getConnectionToDatabase()
        val sql = "DELETE FROM Secretary WHERE code = \'$code\';"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val result = statement?.executeUpdate()
            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }
    }

    override fun getAllSecretaries(): ArrayList<Secretary> {
        connection?.getConnectionToDatabase()
        var results:ArrayList<Secretary> = ArrayList()
        val sql = "SELECT * FROM Secretary;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                results.add(Secretary(resultSet?.getString(1),
                        resultSet?.getString(2),
                        resultSet?.getString(3),
                        resultSet?.getString(4),
                        resultSet?.getString(5),
                        resultSet?.getString(6)))
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return results
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
        connection?.getConnectionToDatabase()
        val sql = "UPDATE Trainer SET password = \'$password\', name = \'$name\', last_name = \'$lastName\', phone_number = \'$telephone\', email = \'$email\' WHERE code = \'$code\'; "
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val result = statement?.executeUpdate()
            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }
    }

    override fun removeTrainer(code: String) {
        connection?.getConnectionToDatabase()
        val sql = "DELETE FROM Trainer WHERE code = \'$code\';"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val result = statement?.executeUpdate()
            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }
    }

    override fun getAllTrainers(): ArrayList<Trainer> {
        connection?.getConnectionToDatabase()
        var results:ArrayList<Trainer> = ArrayList()
        val sql = "SELECT * FROM Trainer;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                results.add(Trainer(resultSet?.getString(1),
                        resultSet?.getString(2),
                        resultSet?.getString(3),
                        resultSet?.getString(4),
                        resultSet?.getString(5),
                        resultSet?.getString(6)))
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return results
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
        connection?.getConnectionToDatabase()
        val sql = "DELETE FROM Member WHERE code = \'$code\';"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val result = statement?.executeUpdate()
            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }
    }

    override fun getAllMembers(): ArrayList<Member> {
        connection?.getConnectionToDatabase()
        var results:ArrayList<Member> = ArrayList()
        val sql = "SELECT * FROM Trainer;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                results.add(Member(resultSet?.getString(1),
                        resultSet?.getString(2),
                        resultSet?.getString(3),
                        resultSet?.getString(4),
                        resultSet?.getString(5)))
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return results
    }

    override fun updateMember(code: String, name: String, lastName: String, phoneNumber: String, email: String) {
        connection?.getConnectionToDatabase()
        val sql = "UPDATE Trainer SET name = \'$name\', last_name = \'$lastName\', phone_number = \'$phoneNumber\', email = \'$email\' WHERE code = \'$code\'; "
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val result = statement?.executeUpdate()
            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }    }

    override fun addMembership(memberCode: String, physicalAssessmentCode:Int, scholarshipCode: Int, secretaryCode: String) {
        connection?.getConnectionToDatabase()
        val sql = "INSERT INTO Membership(code_member, code_secretary, code_physical_assessment, code_scholarship ) " +
                "VALUES(?,?,?,?);"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            statement?.setString(1, memberCode)
            statement?.setString(2, secretaryCode)
            statement?.setInt(3, physicalAssessmentCode)
            statement?.setInt(1, scholarshipCode)

            val result = statement?.executeUpdate()

            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }
    }

    override fun removeMembership(code: Int) {
        connection?.getConnectionToDatabase()
        val sql = "DELETE FROM Membership WHERE code = \'$code\';"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val result = statement?.executeUpdate()
            println("rows modified: ${result}")
        }catch (e:SQLException){
            e.printStackTrace()
        }
    }

    override fun getAllMemberships(): ArrayList<Membership> {
        connection?.getConnectionToDatabase()
        var results:ArrayList<Membership> = ArrayList()
        val sql = "SELECT * FROM Membership;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                //results.add(Mem)
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return results
    }

    override fun addPayment(code:Int, date: Date, total:Double, memberCode:String, membershipCode: Int, paymentTypeCode: Int){
    }

    override fun addPhysicalAssesment(code: Int, date: Date, arms: Double, legs: Double, hips: Double, height: Double, weight: Double, personalGoals: String, trainerCode: String) {
        TODO("Not yet implemented")
    }

    override fun updateDatePhysicalAssessment(code: Int, date: Date) {
        TODO("Not yet implemented")
    }

    override fun removePhysicalAssessment(code: Int) {
        TODO("Not yet implemented")
    }

    override fun getAllPhysicalAssessment(code: Int) {
        TODO("Not yet implemented")
    }

    override fun getMemberByCode(code: String): Member {
        connection?.getConnectionToDatabase()
        var member:Member = Member()
        val sql = "SELECT * FROM Member WHERE code = $code;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                member = Member(resultSet?.getString(1),resultSet?.getString(2), resultSet?.getString(3),
                        resultSet?.getString(4), resultSet?.getString(5))
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return member
    }

    override fun getSecretaryByCode(code: String): Secretary {
        connection?.getConnectionToDatabase()
        var secretary:Secretary = Secretary()
        val sql = "SELECT * FROM Secretary WHERE code = $code;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                secretary = Secretary(resultSet?.getString(1),
                        resultSet?.getString(3),
                        resultSet?.getString(4),
                        resultSet?.getString(6),
                        resultSet?.getString(5),
                        resultSet?.getString(2))
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return secretary
    }

    override fun getPhysicallAssesement(code: Int): PhysicalAssessment {
        connection?.getConnectionToDatabase()
        var physicalAssessment:PhysicalAssessment = PhysicalAssessment()

        val sql = "SELECT * FROM PhysicalAssessment WHERE code = $code;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                physicalAssessment = PhysicalAssessment(
                        resultSet?.getInt(1),
                        resultSet?.getDate(2),
                        resultSet?.getDouble(3),
                        resultSet?.getDouble(4),
                        resultSet?.getDouble(5),
                        resultSet?.getDouble(6),
                        resultSet?.getDouble(7),
                        resultSet?.getString(8),
                        getTrainerByCode(resultSet?.getString(9))
                )
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return physicalAssessment
    }

    override fun getScholarshipByCode(code: Int): Scholarship {
        connection?.getConnectionToDatabase()
        var scholarship:Scholarship = Scholarship.NONE

        val sql = "SELECT * FROM Scholarship WHERE code = $code;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                when (resultSet?.getInt(1)) {
                    1 -> {
                        scholarship=Scholarship.SCHOOL
                    }
                    2 -> {
                        scholarship=Scholarship.COLLAGE
                    }
                    3 -> {
                        scholarship=Scholarship.POST_GRADE
                    }
                }
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return scholarship
    }

    override fun getMembershipByCode(code: Int): Membership {
        connection?.getConnectionToDatabase()
        var membership:Membership = Membership()

        val sql = "SELECT * FROM Membership WHERE code = $code;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                membership = Membership(resultSet?.getInt(1),
                                        getMemberByCode(resultSet?.getString(2)),
                                        getPhysicallAssesement(resultSet?.getInt(4)),
                                        getScholarshipByCode(resultSet?.getInt(5)),
                                        getSecretaryByCode(resultSet?.getString(3))
                                        )

            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return membership
    }

    override fun getPaymenTypeByCode(code: Int): PaymentType {
        connection?.getConnectionToDatabase()
        var paymentType:PaymentType = PaymentType.NONE

        val sql = "SELECT * FROM PaymentType WHERE code = $code;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                when (resultSet?.getInt(1)) {
                    1 -> {
                        paymentType=PaymentType.CREDIT
                    }
                    3 -> {
                        paymentType=PaymentType.DEBIT
                    }
                }
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return paymentType
    }

    override fun getTrainerByCode(code: String): Trainer {
        connection?.getConnectionToDatabase()
        var trainer:Trainer = Trainer()
        val sql = "SELECT * FROM Trainer WHERE code = $code;"
        try{
            var statement: PreparedStatement? = connection?.connection?.prepareStatement(sql)
            val resultSet:ResultSet? = statement?.executeQuery()
            while(resultSet?.next()==true){
                trainer = Trainer(resultSet?.getString(1),
                        resultSet?.getString(2),
                        resultSet?.getString(4),
                        resultSet?.getString(6),
                        resultSet?.getString(5),
                        resultSet?.getString(3))
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return trainer
    }
}