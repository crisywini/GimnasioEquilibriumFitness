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

    fun addMembership(code:Int, member: Member, physicalAssessment: PhysicalAssessment, scholarship: Scholarship)
    fun removeMembership(code:Int)
    fun getAllMemberships():ArrayList<Member>

    fun addPayment(code:Int, date: Date, total:Double, member:Member, membership: Membership, paymentType: PaymentType)

    fun addPhysicalAssesment(
            code: Int,
            date: Date,
            arms: Double,
            legs: Double,
            hips: Double,
            height: Double,
            weight: Double,
            personalGoals: String,
            trainer: Trainer
    )
    fun updateDatePyhisicalAssesment(code:Int, date:Date)
    fun removePhysicalAssesment(code:Int)
    fun getAllPhysicalAssesment(code:Int)

}