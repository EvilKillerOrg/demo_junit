package com.ek.demo.test3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

  private static String url = "jdbc:mysql://localhost:3306/test";
  private static String driverClassName = "com.mysql.jdbc.Driver";
  private static String user = "root";
  private static String password = "admin";

  public static Connection getConnection() {
    try {
      Class.forName(driverClassName);
      return DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void closeConn(ResultSet rst, PreparedStatement pst, Connection conn) {
    if (rst != null) {
      try {
        rst.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (pst != null) {
      try {
        pst.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
