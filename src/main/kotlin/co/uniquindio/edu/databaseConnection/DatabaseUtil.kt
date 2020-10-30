package co.uniquindio.edu.databaseConnection

import java.sql.SQLException
import java.sql.Statement

class DatabaseUtil {

    private var connection:Connection? = Connection()

    /**
     * This method allows to create the database based
     */
    fun createDataBase(databaseDetails:String){
        connection?.getConnection()
        println("Success connection to mysql")
        var statement:Statement? = null
        try {
            statement = connection?.connection!!.createStatement()
            statement.execute(databaseDetails)
            println("Database created using ${databaseDetails}")

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
    fun initDatabaseAndTables(){

        createDataBase("CREATE DATABASE IF NOT EXISTS GEF_TEST;")
        createTable("CREATE TABLE IF NOT EXISTS Scholarship(code int NOT NULL AUTO_INCREMENT, description VARCHAR(255), PRIMARY KEY(code));")
        createTable("CREATE TABLE IF NOT EXISTS Member(code VARCHAR(11) NOT NULL, name VARCHAR(255), last_name VARCHAR(255), phone_number VARCHAR(255), email VARCHAR(255), PRIMARY KEY(code));")
        //createTable("CREATE TABLE IF NOT EXISTS Member(code VARCHAR(11) NOT NULL, name VARCHAR(255), last_name VARCHAR(255), phone_number VARCHAR(255), email VARCHAR(255), PRIMARY KEY(code));")
    }
}