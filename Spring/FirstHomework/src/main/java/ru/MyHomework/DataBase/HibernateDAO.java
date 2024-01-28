package ru.MyHomework.DataBase;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public abstract class HibernateDAO<T> implements  DAO{
    private DataBaseConnector dataBaseConnector = new DataBaseConnector();
    private Class<T> clazz;

    protected HibernateDAO(Class<T> clazz) {
        this.clazz = clazz;
    }


    public T getById(int id) {
        T entity = null;
        try(Session session = dataBaseConnector.getSession()){
            entity = session.get(clazz, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return (T) entity;
    }


    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        try(Session session = dataBaseConnector.getSession()){
            entities = session.createQuery( "FROM " + clazz.getName(), clazz).getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return entities;
    }



    public void update(Object entity) {
        try(Session session = dataBaseConnector.getSession()){
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void create(Object entity) {
        try(Session session = dataBaseConnector.getSession()) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Object entity) {
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
            T entity = session.get(clazz, entityId);
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
