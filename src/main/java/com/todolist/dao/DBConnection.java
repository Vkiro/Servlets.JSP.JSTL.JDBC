package com.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DBConnection {
    INSTANCE;

    public static final String URL = "jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() throws ExceptionDAO {
        try {
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            throw new ExceptionDAO("Cannot connect", e);
        }
    }
}
