package com.shop.dao;

import com.shop.entity.User;

public interface UserDao {
    User addUser(User user);
    User findByUsername(String username);
}
