package com.shop.config;

import com.shop.entity.User;
import com.shop.entity.security.Authority;
import com.shop.entity.security.AuthorityName;
import com.shop.security.repository.AuthorityRepository;

import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataLoader implements ApplicationRunner {

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Authority auth1 = Authority.builder().name(AuthorityName.ROLE_CUSTOMER).build();
        Authority auth2 = Authority.builder().name(AuthorityName.ROLE_SHOPKEEPER).build();
        Authority auth3 = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();

        authorityRepository.save(auth1);
        authorityRepository.save(auth2);
        authorityRepository.save(auth3);


        List<Authority> authorities = new ArrayList<>();
        authorities.add(auth1);
        authorities.add(auth2);
        authorities.add(auth3);

        User user = User.builder().username("test").password("test").build();
        user.setAuthorities(authorities);

        userService.addUser(user);

    }
}
