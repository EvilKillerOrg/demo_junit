package com.ek.demo.test3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ek.demo.test3.vo.User;

public class UserDAOImpl implements IUserDAO {

  @Override
  public void add(User user) {
    Connection conn = null;
    PreparedStatement pst = null;
    String sql = "insert into t_user(username,password,nickname) values (?,?,?)";
    try {
      conn = DBUtil.getConnection();
      pst = conn.prepareStatement(sql);
      pst.setString(1, user.getUsername());
      pst.setString(2, user.getPassword());
      pst.setString(3, user.getNickname());
      pst.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }finally{
      DBUtil.closeConn(null, pst, conn);
    }

  }

  @Override
  public void delete(String username) {
    Connection conn = null;
    PreparedStatement pst = null;
    String sql = "delete from t_user where username=?";
    
    try {
      conn = DBUtil.getConnection();
      pst = conn.prepareStatement(sql);
      pst.setString(1, username);
      pst.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }finally{
      DBUtil.closeConn(null, pst, conn);
    }
    

  }

  @Override
  public User find(String username) {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    String sql = "select * from t_user where username=?";
    User user = null;
    try {
      conn = DBUtil.getConnection();
      pst = conn.prepareStatement(sql);
      pst.setString(1, username);
      rst = pst.executeQuery();
      while(rst.next()){
        user = new User();
        user.setUsername(rst.getString("username"));
        user.setPassword(rst.getString("password"));
        user.setNickname(rst.getString("nickname"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }finally{
      DBUtil.closeConn(rst, pst, conn);
    }
      
      
    
    return user;
  }

}
