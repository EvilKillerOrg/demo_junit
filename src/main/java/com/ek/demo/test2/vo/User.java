package com.ek.demo.test2.vo;

public class User {

  public User() {
    super();
  }

  public User(String username, String password, String nickname) {
    super();
    this.username = username;
    this.password = password;
    this.nickname = nickname;
  }

  private String username;
  private String password;
  private String nickname;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
}
