package ru.yampolskiy.taskclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.yampolskiy.taskclient.models.task.Task;
import ru.yampolskiy.taskclient.service.TaskService;
import ru.yampolskiy.taskclient.service.UserService;

import java.util.List;

@Controller
public class TaskManagerController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        Long currentUserId = userService.findUserByUserName(currentUsername).getId();
        List<Task> tasks = taskService.findAllUserTasks(currentUserId);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTaskById(@PathVariable Long id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping("/tasks/new")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "createTask";
    }

    @PostMapping("/tasks")
    public String createTask(@ModelAttribute Task task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        Long currentUserId = userService.findUserByUserName(currentUsername).getId();
        task.setOwnerId(currentUserId);
        taskService.createNewTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/edit")
    public String editTaskForm(@PathVariable Long id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "editTask";
    }

    @PostMapping("/tasks/{id}/edit")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        Long currentUserId = userService.findUserByUserName(currentUsername).getId();
        Task existingTask = taskService.findTaskById(id);
        if (existingTask != null && existingTask.getOwnerId().equals(currentUserId)) {
            task.setId(currentUserId);
            taskService.updateTask(id, task);
        }
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        Long currentUserId = userService.findUserByUserName(currentUsername).getId();
        Task task = taskService.findTaskById(id);
        if (task != null && task.getOwnerId().equals(currentUserId)) {
            taskService.deleteTask(id);
        }
        return "redirect:/tasks";
    }
}


//    @PostConstruct
//    private void createAdmin(){
//        List<User> users = userService.findAllUsers();
//        if(users.isEmpty()){
//            User admin = new User("admin", "admin@example.org", "admin", true, Collections.singleton(Role.ADMIN));
//            userService.registerNewUser(admin);
//        }

//        Task newTask = taskService.createNewTask(new Task("Первая задача",
//                "Переименовать учетную запись в новую папку",
//                TaskStatus.OPEN,
//                userService.findUserByUserName("admin").getId(),
//                LocalDateTime.now(),
//                LocalDateTime.now(),
//                null));
//    }

