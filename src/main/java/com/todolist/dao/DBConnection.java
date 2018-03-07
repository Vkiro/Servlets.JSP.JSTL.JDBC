package com.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DBConnection {
    INSTANCE;

    public static final String URL = "jdbc:mysql://eu-cdbr-west-02.cleardb" +
            ".net/heroku_0d0f6c49bcf8a7b?autoReconnect=true&useSSL=false";
    private static final String LOGIN = "b08fdc29bed85f";
    private static final String PASSWORD = "f0150e48";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
}
