package com.shop.entity.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.shop.config.json.View;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "true")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @JsonView(View.Auth.class)
    @NonNull
    AuthorityName name;

}