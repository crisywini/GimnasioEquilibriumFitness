package co.uniquindio.edu.model

import java.sql.Date

class PhysicalAssessment(var code:Int, var date:Date,var arms:Double, var legs:Double, var hips:Double, var height:Double, var weight:Double, var personalGoals:String, var trainer: Trainer) {

    constructor(){

    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PhysicalAssessment

        if (code != other.code) return false

        return true
    }

    override fun hashCode(): Int {
        return code
    }

    override fun toString(): String {
        return "PhysicalAssessment(code=$code, date=$date, arms=$arms, legs=$legs, hips=$hips, height=$height, weight=$weight, personalGoals='$personalGoals', trainer=$trainer)"
    }
}