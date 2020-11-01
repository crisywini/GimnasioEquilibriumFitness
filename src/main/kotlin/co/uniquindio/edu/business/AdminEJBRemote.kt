package co.uniquindio.edu.business

import co.uniquindio.edu.model.*
import java.sql.Date

interface AdminEJBRemote {
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

    fun addMembership(memberCode: String, physicalAssessmentCode:Int, scholarshipCode: Int, secretaryCode: String)
    fun removeMembership(code:Int)
    fun getAllMemberships():ArrayList<Membership>

    fun addPayment(code:Int, date: Date, total:Double, memberCode:String, membershipCode: Int, paymentTypeCode: Int)

    fun addPhysicalAssesment(
            code: Int,
            date: Date,
            arms: Double,
            legs: Double,
            hips: Double,
            height: Double,
            weight: Double,
            personalGoals: String,
            trainerCode: String
    )
    fun updateDatePhysicalAssessment(code:Int, date:Date)
    fun removePhysicalAssessment(code:Int)
    fun getAllPhysicalAssessment(code:Int)

    fun getMemberByCode(code:String):Member
    fun getSecretaryByCode(code:String):Secretary
    fun getPhysicallAssesement(code:Int):PhysicalAssessment
    fun getScholarshipByCode(code:Int):Scholarship
    fun getMembershipByCode(code:Int):Membership
    fun getPaymenTypeByCode(code:Int):PaymentType
    fun getTrainerByCode(code:String):Trainer
}