package com.devsuperior.hroauth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles;

}
