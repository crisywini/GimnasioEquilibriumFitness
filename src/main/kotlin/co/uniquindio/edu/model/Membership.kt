package co.uniquindio.edu.model

class Membership(var code:Int, var member: Member, var physicalAssessment: PhysicalAssessment, var scholarship: Scholarship) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Membership

        if (code != other.code) return false

        return true
    }

    override fun hashCode(): Int {
        return code
    }

    override fun toString(): String {
        return "Membership(code=$code, member=$member, physicalAssessment=$physicalAssessment, scholarship=$scholarship)"
    }
}