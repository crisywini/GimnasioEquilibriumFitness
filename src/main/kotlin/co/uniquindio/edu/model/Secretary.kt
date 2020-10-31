package co.uniquindio.edu.model

class Secretary(code:String, name:String, lastName: String, email:String, telephone:String, password:String) : Employee(code, name,lastName, email, telephone, password) {

    var memberships:ArrayList<Membership> = ArrayList()


    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun toString(): String {
        return super.toString()
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}