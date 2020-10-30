package co.uniquindio.edu.model

open class Employee (var code: String, var name:String, var lastName: String, var email:String, var telephone:String) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        if (code != other.code) return false

        return true
    }

    override fun hashCode(): Int {
        return code.hashCode()
    }

    override fun toString(): String {
        return "Employee(code='$code', name='$name', lastName='$lastName', email='$email', telephone='$telephone')"
    }

}