package ru.yampolskiy.taskclient.models.task;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class Task {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Long ownerId;
    private LocalDateTime created;
    private LocalDateTime lastUpdate;
    private LocalDateTime finished;

}
