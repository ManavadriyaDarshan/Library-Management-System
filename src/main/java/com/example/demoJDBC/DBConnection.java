package com.example.demoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/library_db";
    private static final String userName = "root";
    private static final String password = "1234";
    

    public static Connection getConnection(){
        try {

            return DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
