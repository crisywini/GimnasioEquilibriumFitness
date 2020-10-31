package co.uniquindio.edu.model

class Trainer(code:String, name:String, lastName: String, email:String, telephone:String, password:String) : Employee(code, name,lastName, email, telephone, password) {

    var physicalAssessments:ArrayList<PhysicalAssessment> = ArrayList()

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