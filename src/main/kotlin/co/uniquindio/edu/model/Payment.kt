package co.uniquindio.edu.model

import java.sql.Date

class Payment(var code:Int, var date:Date, var total:Double, var member:Member, var membership: Membership, var paymentType: PaymentType) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Payment

        if (code != other.code) return false

        return true
    }

    override fun hashCode(): Int {
        return code
    }

    override fun toString(): String {
        return "Payment(code=$code, date=$date, total=$total, member=$member, membership=$membership, paymentType=$paymentType)"
    }
}