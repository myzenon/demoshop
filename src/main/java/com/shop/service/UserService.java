package com.shop.service;

import com.shop.entity.User;

public interface UserService {
    User addUser(User user);
    User addCustomer(User user);
    User findByUsername(String username);
}
