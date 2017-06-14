package com.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DBConnection {
    INSTANCE;

    public static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
       return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
}
