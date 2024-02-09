package ru.gb.homework.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
@NonNull
@Data
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Homework.Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    @Column(name="Title")
    private String title;

    @Column(name="Description")
    private String description;

    @Column(name="Created")
    @CreationTimestamp
    private LocalDateTime createdTime;

//    public Task() {
//    }
//
//    public Task(String title, String description) {
//        this.title = title;
//        this.description = description;
//        this.createdTime = LocalDateTime.now();
//    }
}
