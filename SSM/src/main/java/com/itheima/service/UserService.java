package com.itheima.service;

import com.itheima.dao.User;

import java.util.List;

public interface UserService {
    int saveUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

    List<User> getAllUsers();

    User getUserById(Integer id);
}
