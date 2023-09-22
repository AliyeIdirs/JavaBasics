package regressionsuit.databasetestautomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    //create a method to connect to database
    public static Connection connectToDataBaseServer(String dbUrl,String dbPort,String defaultDB, String userName,
                                        String password, ConnectionType connectionType){
        //define a connection object
        Connection connection=null;
        String JTDS_Driver="net.sourceforge.jtds.jdbc.Driver";
        String MYSQL_Driver="com.mysql.cj.jdbc.Driver";
        switch (connectionType){
            case MSSQL:
                try {
                    Class.forName(JTDS_Driver); //initialize(load) the SQL server driver
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String msSqlConnectionURL="jdbc:jtds:sqlserver://"+dbUrl+":"+dbPort+";DatabaseName="
                        +defaultDB;
                try {
                    connection= DriverManager.getConnection(msSqlConnectionURL,userName,password);
                } catch (SQLException e) {
                    throw new RuntimeException("Please check mysql driver information");
                }
                break;
            case MYSQL:
                try {
                    try {
                        Class.forName(MYSQL_Driver).newInstance();
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String mySqlConnectionURL="jdbc:mysql://"+dbUrl+":"+dbPort+"/"+defaultDB;
                //+"?useSSL=false"
                try {
                    connection=DriverManager.getConnection(mySqlConnectionURL,userName,password);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("You need to specify a database connection type MSSQL or MYSQL!!!");
                //verify the connection
                try {
                    if (!connection.isClosed()){
                        System.out.println("Database connection is established!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
        return connection;
    }
    //define a method to close the connection
    public static void closeDataBaseConnection(Connection connection){
        try {
            if(connection.isClosed()){
                System.out.println("Connection has already been closed!");
            }else{
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
