package com.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.shop.config.json.View;
import com.shop.entity.security.Authority;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "true")
public class User {

    @JsonView(View.Auth.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonView(View.Auth.class)
    @NonNull
    String username;

    @NonNull
    String password;

    @JsonView(View.Auth.class)
    @ManyToMany
    List<Authority> authorities;

}
