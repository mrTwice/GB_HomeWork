package ru.yampolskiy.taskmicroservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status;
    private Long ownerId;
    private LocalDateTime created;
    private LocalDateTime lastUpdate;
    private LocalDateTime finished;

}
