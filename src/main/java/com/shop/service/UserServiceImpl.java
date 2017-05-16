package com.shop.service;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.entity.security.Authority;
import com.shop.entity.security.AuthorityName;
import com.shop.security.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    AuthorityRepository authorityRepository;

    public User addUser(User user) {
        return this.userDao.addUser(user);
    }

    public User addCustomer(User user) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityRepository.findByName(AuthorityName.ROLE_CUSTOMER));
        user.setAuthorities(authorities);
        return this.userDao.addUser(user);
    }

    public User findByUsername(String username) {
        return this.userDao.findByUsername(username);
    }
}
