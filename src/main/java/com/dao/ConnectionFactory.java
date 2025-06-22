package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            String url = "jdbc:mysql://localhost:3306/solucreddb";
            String user = "root";
            String password = "admin";
            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
