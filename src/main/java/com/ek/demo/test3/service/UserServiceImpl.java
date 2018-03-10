package com.ek.demo.test3.service;

 
import com.ek.demo.test3.dao.IUserDAO;
import com.ek.demo.test3.dao.UserDAOImpl;
import com.ek.demo.test3.vo.User;
import com.ek.demo.test3.vo.UserException;

public class UserServiceImpl implements IUserService {
  
  private IUserDAO userDAO;
  
  

  public UserServiceImpl(IUserDAO userDAO) {
    this.userDAO = userDAO;
  }
  
  public UserServiceImpl() {
    userDAO = new UserDAOImpl();
  }

  @Override
  public void add(User user) {
    if(this.find(user.getUsername())!=null){
      throw new UserException("用户名已存在!");
    }
    userDAO.add(user);
  }

  @Override
  public void delete(String username) {
    userDAO.delete(username);
  }

  @Override
  public User find(String username) {
    return userDAO.find(username);
  }

  @Override
  public User login(String username, String password) {
    return null;
  }

}
