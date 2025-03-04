package com.example.demoJDBC;

import java.sql.*;

public class TransactionDAO {
    public static void borrowBook(int userId, int bookId) {
        try  {
            Connection conn = DBConnection.getConnection();
            // Check if book is available
            PreparedStatement checkStmt = conn.prepareStatement("SELECT status FROM books WHERE book_id = ?");
            checkStmt.setInt(1, bookId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getString("status").equals("Available")) {
                // Issue book
                PreparedStatement issueStmt = conn.prepareStatement("INSERT INTO transactions (user_id, book_id) VALUES (?, ?)");
                issueStmt.setInt(1, userId);
                issueStmt.setInt(2, bookId);
                issueStmt.executeUpdate();

                // Update book status
                PreparedStatement updateStmt = conn.prepareStatement("UPDATE books SET status = 'Issued' WHERE book_id = ?");
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();

                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book is not available.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void returnBook(int bookId) {
        try  {
            Connection conn = DBConnection.getConnection();
            // Check if book is issued
            PreparedStatement checkStmt = conn.prepareStatement("SELECT * FROM transactions WHERE book_id = ? AND return_date IS NULL");
            checkStmt.setInt(1, bookId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                // Update transaction
                PreparedStatement updateTrans = conn.prepareStatement("UPDATE transactions SET return_date = CURRENT_TIMESTAMP WHERE book_id = ?");
                updateTrans.setInt(1, bookId);
                updateTrans.executeUpdate();

                // Update book status
                PreparedStatement updateBook = conn.prepareStatement("UPDATE books SET status = 'Available' WHERE book_id = ?");
                updateBook.setInt(1, bookId);
                updateBook.executeUpdate();

                System.out.println("Book returned successfully!");
            } else {
                System.out.println("Book is not currently issued.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
