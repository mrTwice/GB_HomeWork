package ru.yampolskiy.taskmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yampolskiy.taskmicroservice.model.Task;
import ru.yampolskiy.taskmicroservice.repository.TaskRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getAllUserTask(Long id) {
        return taskRepository.findAllByOwnerId(id).orElse(Collections.emptyList());
    }

    public Task getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.orElse(null);
    }

    public Task createTask(Task task) {
        if (task.getId() != null) {
            throw new IllegalArgumentException("ID должен быть пустым при создании задачи");
        }
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Задачи с ID " + id + " не существует");
        }
        task.setId(id);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Задачи с ID " + id + " не существует");
        }
        taskRepository.deleteById(id);
    }
}
