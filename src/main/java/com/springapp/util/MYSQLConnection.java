package com.springapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created on 04.04.16.
 */
public class MYSQLConnection {

    private static final String USER = "root";
    private static final String PASSWORD = "1";
    private static final String URL = "jdbc:mysql://localhost:3306/company?useEncoding=true&characterEncoding=UTF-8" ;
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL = new ThreadLocal<Connection>();

    public static Connection getConnection(){

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERROR: can't load mysql driver");
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void putCurrentConnection(Connection connection) {
        CONNECTION_THREAD_LOCAL.set(connection);
    }

    public static Connection getCurrentConnection() {
        return CONNECTION_THREAD_LOCAL.get();
    }
}
