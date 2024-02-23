package com.gb.homework.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name ="Homework.users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String username;
    private String password;
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "homework_users_roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "roles_id") })

    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "homework_users_projects",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "roles_id") })
    private Set<Project> projects = new HashSet<>();

}
