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
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/solucreddb");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
