package com.ek.demo.test2.service;

import com.ek.demo.test2.vo.User;

public interface IUserService {

  public void add(User user);

  public void delete(String username);

  public User find(String username);

  public User login(String username, String password);

}
