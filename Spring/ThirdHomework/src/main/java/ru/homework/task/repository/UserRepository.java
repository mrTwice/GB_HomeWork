package ru.homework.task.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.homework.task.domain.User;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private DataBaseConnector dataBaseConnector;

    public User getById(int id) {
        User entity = null;
        try(Session session = dataBaseConnector.getSession()){
            entity = session.get(User.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }


    public List<User> getAll() {
        List<User> entities = new ArrayList<>();
        try(Session session = dataBaseConnector.getSession()){
            entities = session.createQuery( "FROM User", User.class).list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return entities;
    }



    public void update(User entity) {
        try(Session session = dataBaseConnector.getSession()){
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void create(User entity) {
        try(Session session = dataBaseConnector.getSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(User entity) {
        try(Session session = dataBaseConnector.getSession()){
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteById(int entityId) {
        try(Session session = dataBaseConnector.getSession()){
            User entity = session.get(User.class, entityId);
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
