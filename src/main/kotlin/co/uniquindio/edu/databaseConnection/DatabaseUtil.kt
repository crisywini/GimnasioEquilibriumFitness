package co.uniquindio.edu.databaseConnection

import java.sql.SQLException
import java.sql.Statement

class DatabaseUtil {

    private var connection:Connection? = Connection()

    /**
     * This method allows to create the database based
     * @param sqlSentence sql sentence to create the database
     */
    fun createDataBase(sqlSentence:String){
        connection?.getConnection()
        println("Success connection to mysql")
        var statement:Statement? = null
        try {
            statement = connection?.connection!!.createStatement()
            statement.execute(sqlSentence)
            println("Database created using ${sqlSentence}")

        } catch (ex: SQLException) {
            ex.printStackTrace()
        } finally {

            if (statement != null) {
                try {
                    statement.close()
                } catch (sqlEx: SQLException) {
                }
                statement = null
            }
            if (connection != null) {
                try {
                    connection?.connection!!.close()
                } catch (sqlEx: SQLException) {
                }
                connection?.connection = null
            }
        }
    }

    /**
     * This method allows to create a table based on the sql sentence
     * @param sqlSentence to create the table
     */
    fun createTable(sqlSentence:String){
        connection = null
        connection = Connection()
        connection?.getConnectionToDatabase()
        println("Connected to GEF_TEST")
        var statement:Statement? = null
        try {
            statement = connection?.connection!!.createStatement()
            statement.executeUpdate(sqlSentence)
            println("Table created using ${sqlSentence}")

        } catch (ex: SQLException) {
            ex.printStackTrace()
        } finally {

            if (statement != null) {
                try {
                    statement.close()
                } catch (sqlEx: SQLException) {
                }
                statement = null
            }
            if (connection != null) {
                try {
                    connection?.connection!!.close()
                } catch (sqlEx: SQLException) {
                }
                connection?.connection = null
            }
        }
    }

    /**
     * This method allows to init the database and all the tables
     */
    fun initDatabaseAndTables(){
        createDataBase("CREATE DATABASE IF NOT EXISTS GEF_TEST;")
        createTable("CREATE TABLE IF NOT EXISTS Scholarship(code int NOT NULL AUTO_INCREMENT, description VARCHAR(255) NOT NULL, PRIMARY KEY(code));")
        createTable("CREATE TABLE IF NOT EXISTS Member(code VARCHAR(11) NOT NULL, name VARCHAR(255) NOT NULL, last_name VARCHAR(255) NOT NULL, phone_number VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, PRIMARY KEY(code));")
        createTable("CREATE TABLE IF NOT EXISTS Secretary(code VARCHAR(11) NOT NULL, password VARCHAR(11) NOT NULL, name VARCHAR(255) NOT NULL, last_name VARCHAR(255) NOT NULL, phone_number VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, PRIMARY KEY(code));")
        createTable("CREATE TABLE IF NOT EXISTS Trainer(code VARCHAR(11) NOT NULL, name VARCHAR(255) NOT NULL, password VARCHAR(11) NOT NULL, last_name VARCHAR(255) NOT NULL, phone_number VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, PRIMARY KEY(code));")
        createTable("CREATE TABLE IF NOT EXISTS PhysicalAssessment(code int NOT NULL AUTO_INCREMENT, date DATE NOT NULL, arms DECIMAL NOT NULL, legs DECIMAL NOT NULL, hips DECIMAL NOT NULL, height DECIMAL NOT NULL, weight DECIMAL NOT NULL, personal_goals LONGTEXT NOT NULL, code_trainer VARCHAR(11) NOT NULL, PRIMARY KEY(code), CONSTRAINT fk_code_trainer FOREIGN KEY(code_trainer) REFERENCES Trainer(code) ON UPDATE CASCADE);")

        createTable("CREATE TABLE IF NOT EXISTS Membership(code int NOT NULL AUTO_INCREMENT, code_member VARCHAR(11) NOT NULL," +
                "code_trainer VARCHAR(11) NOT NULL, code_secretary VARCHAR(11) NOT NULL, code_physical_assessment int NOT NULL, " +
                "code_scholarship int NOT NULL, PRIMARY KEY(code), " +
                "CONSTRAINT fk_code_trainer_member FOREIGN KEY(code_trainer) REFERENCES Trainer(code) ON UPDATE CASCADE," +
                "CONSTRAINT fk_code_secretary FOREIGN KEY(code_secretary) REFERENCES Secretary(code) ON UPDATE CASCADE,"+
                "CONSTRAINT fk_code_member FOREIGN KEY(code_member) REFERENCES Member(code) ON UPDATE CASCADE, "+
                "CONSTRAINT fk_code_physical_assessment FOREIGN KEY(code_physical_assessment) REFERENCES PhysicalAssessment(code) ON UPDATE CASCADE, "+
                "CONSTRAINT fk_code_scholarship FOREIGN KEY(code_scholarship) REFERENCES Scholarship(code) ON UPDATE CASCADE"+
                ");")
        createTable("CREATE TABLE IF NOT EXISTS PaymentType(code INT NOT NULL AUTO_INCREMENT, description VARCHAR(255) NOT NULL, PRIMARY KEY(code));")
        createTable("CREATE TABLE IF NOT EXISTS Payment(code int NOT NULL AUTO_INCREMENT, date DATE NOT NULL, total DECIMAL NOT NULL, code_member VARCHAR(11), code_membership INT NOT NULL,  code_payment_type INT NOT NULL," +
                "PRIMARY KEY(code), " +
                "CONSTRAINT fk_code_member_pay FOREIGN KEY(code_member) REFERENCES Member(code) ON UPDATE CASCADE," +
                "CONSTRAINT fk_code_membership FOREIGN KEY(code_membership) REFERENCES Membership(code) ON UPDATE CASCADE,"+
                "CONSTRAINT fk_code_payment_type FOREIGN KEY(code_payment_type) REFERENCES PaymentType(code) ON UPDATE CASCADE"+
                ");")

    }
}