package com.dao;

import com.bean.User;

public interface UserDao {
  String save(User user);
  User findById(int id);
  void delete(User user);
  void update(User user);
  boolean login(User user);
  User findByName(String username);
 
}
