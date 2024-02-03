package ru.homework.task.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "UserDB.Persons")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private  int id;
    @Column(name="Name")
    private String name;
    @Column(name="Age")
    private int age;
    @Column(name="Email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
