package com.edutech.progressive.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static final Properties properties=new Properties();
    private static void loadProperties(){
        InputStream input=DatabaseConnectionManager.class.getClassLoader().getResourceAsStream("application.properties");
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(null, null, null);        
    }
}
