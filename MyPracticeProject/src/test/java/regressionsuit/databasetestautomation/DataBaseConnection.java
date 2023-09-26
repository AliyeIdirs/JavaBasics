package regressionsuit.databasetestautomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    //create a method to connect to database
    Connection connection=null;
    public Connection connectToDataBaseServer(String dbUrl, String dbPort, String dbUserName, String dbPassword,
                                              String defaultDB,ConnectionType connectionType){
        String JTDS_Driver="net.sourceforge.jtds.jdbc.Driver"; //MSSQL
        String MYSQL_Driver="com.mysql.cj.jdbc.Driver";        //MYSQL

        switch (connectionType){
            case MSSQL :
                try {
                    Class.forName(JTDS_Driver); //load the mssql driver
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String msSqlConnectionURL="jdbc:jtds:sqlserver://"+dbUrl+":"+dbPort+";DataBaseName="+defaultDB;
                try {
                    connection= DriverManager.getConnection(msSqlConnectionURL,dbUserName,dbPassword);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if(!connection.isClosed()){
                        System.out.println("Connection is established!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case MYSQL:
                try {
                    Class.forName(MYSQL_Driver); //load the mysql driver
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String mySqlConnectionURL="jdbc:mysql://"+dbUrl+":"+dbPort+"/"+defaultDB+"?useSSL=false";
                try {
                    connection=DriverManager.getConnection(mySqlConnectionURL,dbUserName,dbPassword);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if(!connection.isClosed()){
                        System.out.println("Connection is established!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("You need to specify a database conneciton type MSSQL or MYSQL!!!");
        }
        return connection;
    }
    public void closeConnection(Connection connection){
        try {
            if(connection.isClosed())
                System.out.println("Connection is already closed.");
            else
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}