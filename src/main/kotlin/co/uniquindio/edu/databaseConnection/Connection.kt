package co.uniquindio.edu.databaseConnection

import java.sql.*
import java.sql.Connection

class Connection {

    var connection:Connection? = null
    var user:String = "root"
    var password:String = "root"
    //val URL = "jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false"
    val URL = "jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT"
    val URL_DATABASE = "jdbc:mysql://localhost:3306/GEF_TEST?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=CTT"
    val controller:String = "com.mysql.cj.jdbc.Driver"


    companion object{
        @JvmStatic
        fun main(args:Array<String>){
           val databaseUtil:DatabaseUtil = DatabaseUtil()
            databaseUtil.initDatabaseAndTables()
        }
    }

    /**
     * This method allows to connect to the mysql
     */
    fun getConnection() {

        try {
            Class.forName(controller).newInstance()
            connection = DriverManager.getConnection(URL,user, password)
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    /**
     * This method allows to connect to the database
     */
    fun getConnectionToDatabase() {
        try {
            Class.forName(controller).newInstance()
            connection = DriverManager.getConnection(URL_DATABASE,user, password)
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    /**
    fun executeMySQLQuery() {
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = connection!!.createStatement()
            resultset = stmt!!.executeQuery("SHOW DATABASES;")
            if (stmt.execute("SHOW DATABASES;")) {
                resultset = stmt.resultSet
            }
            while (resultset!!.next()) {
                println(resultset.getString("Database"))
            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
                try {
                    resultset.close()
                } catch (sqlEx: SQLException) {
                }
                resultset = null
            }
            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {
                }
                stmt = null
            }
            if (connection != null) {
                try {
                    connection!!.close()
                } catch (sqlEx: SQLException) {
                }
                connection = null
            }
        }
    }*/
}