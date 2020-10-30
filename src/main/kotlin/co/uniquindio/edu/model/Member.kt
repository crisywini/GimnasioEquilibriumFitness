package co.uniquindio.edu.model

class Member(var code:String, var name:String, var lastName:String, var phoneNumber:String, var email:String) {

    var memberships:ArrayList<Membership> = ArrayList()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Member

        if (code != other.code) return false

        return true
    }

    override fun hashCode(): Int {
        return code.hashCode()
    }

    override fun toString(): String {
        return "Member(code='$code', name='$name', lastName='$lastName', phoneNumber='$phoneNumber', email='$email', memberships=$memberships)"
    }
}