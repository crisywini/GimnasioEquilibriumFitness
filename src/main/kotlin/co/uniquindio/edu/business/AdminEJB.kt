package co.uniquindio.edu.business

import co.uniquindio.edu.model.*
import java.sql.Date

class AdminEJB : AdminEJBRemote{

    override fun addSecretary(code: String, name: String, lastName: String, email: String, telephone: String, password: String) {
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
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
        TODO("Not yet implemented")
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