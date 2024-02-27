package ru.yampolskiy.taskclient.models.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private boolean active;
    private Set<Role> roles;
}
