package co.uniquindio.edu.business

import co.uniquindio.edu.model.*
import java.sql.Date

interface AdminEJBRemote {
    fun login(code:String, password: String):Employee
    fun addSecretary(code:String, name:String, lastName: String, email:String, telephone:String, password:String)
    fun updateSecretary(code:String, name:String, lastName: String, email:String, telephone:String, password:String)
    fun removeSecretary(code:String)
    fun getAllSecretaries():ArrayList<Secretary>
    fun addTrainer(code:String, name:String, lastName: String, email:String, telephone:String, password:String)
    fun updateTrainer(code:String, name:String, lastName: String, email:String, telephone:String, password:String)
    fun removeTrainer(code:String)
    fun getAllTrainers():ArrayList<Trainer>

    fun addMember(code:String, name:String, lastName:String, phoneNumber:String, email:String)
    fun removeMember(code: String)
    fun getAllMembers():ArrayList<Member>
    fun updateMember(code:String, name:String, lastName:String, phoneNumber:String, email:String)

    fun addMembership(memberCode: String,scholarshipCode: Int, secretaryCode: String)
    fun removeMembership(code:Int)
    fun getAllMemberships():ArrayList<Membership>

    fun addPayment(date: Date, total:Double, memberCode:String, membershipCode: Int, paymentTypeCode: Int)

    fun addPhysicalAssessment(
            date: Date,
            arms: Double,
            legs: Double,
            hips: Double,
            height: Double,
            weight: Double,
            personalGoals: String,
            trainerCode: String,
            membershipCode: Int
    )
    fun addPhysicalAssessment(
            date: Date,
            arms: Double,
            legs: Double,
            hips: Double,
            height: Double,
            weight: Double,
            personalGoals: String,
            trainerCode: String,
            memberCode: String
    )
    fun updateDatePhysicalAssessment(code:Int, date:Date)
    fun removePhysicalAssessment(code:Int)
    fun getAllPhysicalAssessment():ArrayList<PhysicalAssessment>
    fun updatePhysicalAssessment(code:Int, height: Double, weight: Double, arms: Double, legs: Double, hips: Double, personalGoals: String, codeTrainer:String)
    fun updatePhysicalAssessment(code:Int, height: Double, weight: Double, arms: Double, legs: Double, hips: Double, personalGoals: String, codeTrainer:String, date: Date)

    fun getMemberByCode(code:String):Member
    fun getSecretaryByCode(code:String):Secretary
    fun getPhysicalAssessment(code:Int):PhysicalAssessment
    fun getScholarshipByCode(code:Int):Scholarship
    fun getMembershipByCode(code:Int):Membership
    fun getPaymentTypeByCode(code:Int):PaymentType
    fun getTrainerByCode(code:String):Trainer

    fun getMembershipsByMemberCode(memberCode:String):ArrayList<Membership>
    fun getAllPayments():ArrayList<Payment>
    fun getPaymentsByMemberCode(memberCode: String):ArrayList<Payment>
}