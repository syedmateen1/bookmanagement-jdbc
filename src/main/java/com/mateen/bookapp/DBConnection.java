package com.mateen.bookapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

  public static Connection getConnection() {
    final String URL = "jdbc:postgresql://localhost:5432/bookdb";
    final String USER = "postgres";
    final String PASSWORD = "1234";

    try {
      return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}