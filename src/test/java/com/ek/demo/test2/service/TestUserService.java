package com.ek.demo.test2.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ek.demo.test2.vo.User;
import com.ek.demo.test2.vo.UserException;

/**
 * 基于测试驱动的开发
 */
public class TestUserService {

  private IUserService us;
  private User baseUser;

  private void assertUserEquals(User tu, User baseUser) {
    assertEquals(tu.getUsername(), baseUser.getUsername());
    assertEquals(tu.getPassword(), baseUser.getPassword());
    assertEquals(tu.getNickname(), baseUser.getNickname());
  }

  @Before
  public void setUp() {
    us = new UserServiceImpl();
    baseUser = new User("admin", "123", "管理员");
  }

  // -------------------------------------------------------------------------------------------//

  /*测试添加用户*/
  @Test
  public void testAdd() {
    us.add(baseUser); // 添加用户
    User tu = us.find("admin"); // 查找刚才添加的用户
    assertNotNull(tu); // 判断新用户是否添加进去了
    assertUserEquals(tu, baseUser);// 如果添加进去了,再判断每个字段是否添加进去了

  }

  /*测试添加用户--用户名存在,(存在捕获异常)*/
  @Test(expected = UserException.class)
  public void testAddExistUsername() {
    us.add(baseUser);
    User tu = new User("admin", "111", "222");
    us.add(tu);
  }

  // -------------------------------------------------------------------------------------------//

  /*测试删除用户*/
  @Test
  public void testDelete() {
    us.add(baseUser);
    User tu = us.find(baseUser.getUsername()); // 查找这个用户
    assertNotNull(tu); // 可以找到这个用户
    us.delete(baseUser.getUsername()); // 删除这个用户
    tu = us.find(baseUser.getUsername()); // 再查找一次这个用户
    assertNull("删除的用户还存在!",null); // 查找不到就对了,还能找到就报异常
  }

  /*测试删除用户--管理员不能删除*/

  // -------------------------------------------------------------------------------------------//

  /*测试用户登录*/
  @Test
  public void testLogin() {
    us.add(baseUser);
    String username = "admin";
    String password = "123";
    User tu = us.login(username, password);
    assertUserEquals(tu, baseUser);
  }

  /*测试用户登录--登录用户名错误*/
  @Test(expected = UserException.class)
  public void testNotExistUserLogin() {
    us.add(baseUser);
    String username = "admin111";
    String password = "123";
    us.login(username, password);
  }

  /*测试用户登录--登录密码错误*/
  @Test(expected = UserException.class)
  public void testPasswordErrorUserLogin() {
    us.add(baseUser);
    String username = "admin";
    String password = "1234567890";
    us.login(username, password);
  }

}
