package com.ek.demo.test2.service;

import java.util.HashMap;
import java.util.Map;

import com.ek.demo.test2.vo.User;
import com.ek.demo.test2.vo.UserException;

public class UserServiceImpl implements IUserService {
  private Map<String, User> map = new HashMap<String, User>();

  @Override
  public void add(User user) {
    if(this.find(user.getUsername())!=null){
      throw new UserException("用户名已存在!");
    }
    map.put(user.getUsername(), user);
  }

  @Override
  public void delete(String username) {
    map.remove(username);
  }

  @Override
  public User find(String username) {
    return map.get(username);  
  }

  @Override
  public User login(String username, String password) {
    User u = this.find(username);
    if(null==u){
      throw new UserException("用户名不存在!");
    }
    if(!u.getPassword().equals(password)){
      throw new UserException("用户密码不正确!");
    }
    return u;
  }

}
