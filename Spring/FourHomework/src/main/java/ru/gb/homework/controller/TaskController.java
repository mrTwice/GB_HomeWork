package ru.gb.homework.controller;

import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework.domain.Task;
import ru.gb.homework.service.TaskService;

@CommonsLog(topic = "TaskController")
@Controller
@AllArgsConstructor
@SessionAttributes("task")
public class TaskController {
    private TaskService taskService;

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", taskService.getAllTasks());
        log.info("Получен список задач.");
        return "tasks";
    }

    @PostMapping("/tasks")
    public String addTask(Task tasks, Model model){
        taskService.createTask(tasks);
        model.addAttribute("tasks", taskService.getAllTasks());
        log.info("Добавлена новая задача");
        return "tasks";
    }

    @PostMapping("/getId")
    public String deleteTaskFromForm(long id){
        taskService.deleteTaskById(id);
        log.info("Задача удалена через форму удаления по id");
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTaskByID(@PathVariable("id")long id){
        taskService.deleteTaskById(id);
        log.info("Задача удалена кнопкой рядом с записью");
        return "redirect:/tasks";
    }


    @GetMapping("/update-task/{id}")
    public String updateTaskButton(@PathVariable long id, Model model){
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        log.info("Переход в форму изменения задачи");
        return "/update-task";
    }
    @PostMapping("/update-task")
    public String updateTaskFromForm(Task task){
        taskService.updateTask(task);
        log.info("Задача успешно изменена");
        return "redirect:/tasks";
    }

}
