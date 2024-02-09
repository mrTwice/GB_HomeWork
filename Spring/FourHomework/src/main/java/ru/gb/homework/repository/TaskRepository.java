package ru.gb.homework.repository;

import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gb.homework.domain.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@CommonsLog(topic = "TaskRepository")
@Repository
@AllArgsConstructor
public class TaskRepository {

    @Autowired
    private DataBaseConnector dataBaseConnector;

    public List<Task> getAll() {
        List<Task> entities = new ArrayList<>();
        try(Session  session = dataBaseConnector.getSession()){
            entities = session.createQuery( "FROM Task", Task.class).list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return entities;
    }

    public Task getById(long id) {
        Task entity = null;
        try(Session  session = dataBaseConnector.getSession()){
            entity = session.get(Task.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }

    public boolean update(Task entity) {
        try(Session  session = dataBaseConnector.getSession()){
            session.beginTransaction();
            entity.setCreatedTime(LocalDateTime.now());
            session.update(entity);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean create(Task entity) {
        try(Session  session = dataBaseConnector.getSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Task entity) {
        try(Session  session = dataBaseConnector.getSession()){
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteById(long entityId) {
        try(Session  session = dataBaseConnector.getSession()) {
            Task entity = session.get(Task.class, entityId);
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
