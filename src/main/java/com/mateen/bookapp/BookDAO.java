package com.mateen.bookapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {

    public void getAllBooks() {
        String sql = "SELECT * FROM books";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                System.out.println("No Book found");
            } else {
                do {
                    System.out.println("ID: " + rs.getInt(1) + ", Title: " + rs.getString(2)
                            + ", Author: " + rs.getString(3) + ", Price: " + rs.getDouble(4));
                } while (rs.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBookById(int id) {
        String sqldelete = "DELETE FROM books WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqldelete);) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Book deleted successfully");
            } else {
                System.out.println("No book found with id " + id);
            }
        } catch (Exception e) {
            System.out.println("Failed to delete book");
            e.printStackTrace();
        }
    }

    public void insertBook(String title, String author, double price, int publishedYear) {
        String sql = "INSERT INTO books (title,author,price, published_year) VALUES(?,?,?,?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.setInt(4, publishedYear);
            ps.executeUpdate();
            System.out.println("Book inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
