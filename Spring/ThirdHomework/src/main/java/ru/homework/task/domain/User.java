package ru.homework.task.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UserDB.Persons")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private  int id;
    @Setter
    @Column(name="Name")
    private String name;
    @Setter
    @Column(name="Age")
    private int age;
    @Setter
    @Column(name="Email")
    private String email;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

}
