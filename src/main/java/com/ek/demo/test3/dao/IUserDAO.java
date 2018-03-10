package com.ek.demo.test3.dao;

import com.ek.demo.test3.vo.User;

public interface IUserDAO {

  public void add(User user);

  public void delete(String username);

  public User find(String username);

}
