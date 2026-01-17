package com.edutech.progressive.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static final Properties properties = new Properties();

    private static void loadProperties() {
        InputStream input = DatabaseConnectionManager.class.getClassLoader()
                .getResourceAsStream("application.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        loadProperties();
        String url = properties.getProperty("spring.dataresource.url");
        String user = properties.getProperty("spring.dataresource.user");
        String password = properties.getProperty("spring.dataresource.password");
        return DriverManager.getConnection(url, user, password);
    }
}
