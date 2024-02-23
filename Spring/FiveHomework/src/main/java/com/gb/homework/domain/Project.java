package com.gb.homework.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Homework.projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private  String name;
    private String description;
    private LocalDateTime createdDate;

    @Transient
    @ManyToMany(mappedBy = "projects")
    private Set<User> users = new HashSet<>();
}
