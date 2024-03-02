package ru.yampolskiy.taskclient.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.yampolskiy.taskclient.models.task.Task;
import ru.yampolskiy.taskclient.models.task.TaskStatus;
import ru.yampolskiy.taskclient.models.user.Role;
import ru.yampolskiy.taskclient.models.user.User;
import ru.yampolskiy.taskclient.service.TaskService;
import ru.yampolskiy.taskclient.service.UserService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Controller
public class TaskManagerController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @PostConstruct
    private void createAdmin(){
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            User admin = new User("admin", "admin@example.org", "admin", true, Collections.singleton(Role.ADMIN));
            userService.registerNewUser(admin);
        }

//        Task newTask = taskService.createNewTask(new Task("Первая задача",
//                "Переименовать учетную запись в новую папку",
//                TaskStatus.OPEN,
//                userService.findUserByUserName("admin").getId(),
//                LocalDateTime.now(),
//                LocalDateTime.now(),
//                null));
    }
}
