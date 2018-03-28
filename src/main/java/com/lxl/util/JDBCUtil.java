package com.lxl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtil {

    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = null;
        try {
            properties = PerportiesUtils.loadProperties("config.properties");
            if (null != properties) {
                String driverName = properties.getProperty("jdbc.driver");
                String url = properties.getProperty("jdbc.url");
                String userName = properties.getProperty("jdbc.username");
                String password = properties.getProperty("jdbc.password");

                Class.forName(driverName).newInstance();
                connection = DriverManager.getConnection(url, userName, password);
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}