package ru.gb.homework.service;

import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;
import ru.gb.homework.domain.Task;
import ru.gb.homework.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@CommonsLog(topic = "TaskService")
@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        List<Task> tasks = new ArrayList<>();
        try{
            log.info("Запрос списка задач");
            tasks = taskRepository.getAll();
            log.info("Задачи получены");
        }catch (Exception e){
            log.info("Что-то сломалось, пока мы получали ваши задачи");
        }
        return  tasks;
    }

    public Task getTaskById(long id){
        log.info("Получена задача по id");
        return taskRepository.getById(id);
    }

    public boolean deleteTaskById(long id){
        log.info("Будет удалена по id");
        return taskRepository.deleteById(id);
    }

    public boolean deleteTask(Task task){
        return taskRepository.delete(task);
    }

    public boolean createTask(Task task){
        try{
            log.info("Задача получена");
            if(taskRepository.create(task))
                log.info("Добавлена задача " + task.getId());
            return true;
        }catch (Exception e){
            log.info("Что-то пошло не по плану. Мы не смогли добавить задачу");
            return false;
        }
    }

    public boolean updateTask(Task task){
        return taskRepository.update(task);
    }
}
