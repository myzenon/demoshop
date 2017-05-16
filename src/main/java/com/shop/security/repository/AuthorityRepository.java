package com.shop.security.repository;

import com.shop.entity.security.Authority;
import com.shop.entity.security.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository <Authority,Long> {
    Authority findByName(AuthorityName input);
}
