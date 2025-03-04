package com.example.demoJDBC;

import java.sql.*;

public class BookDAO {

    public static void addBook(String title,String author){
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO books (title, author) VALUES(?,?)");
            ps.setString(1,title);
            ps.setString(2,author);
            int noRows = ps.executeUpdate();
            System.out.println(noRows + " Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewBooks(){

        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            System.out.println("Book List: ");
            System.out.println("---------------------------------------------");
            System.out.println("Book Id | Title | Author | Status");
            while (rs.next()) {
                System.out.println(rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
