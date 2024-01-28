package ru.MyHomework.DataBase;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public interface DAO<T> {
     T getById(int id);
     List<T> getAll();
     void update(T entity);
     void create(T entity);
     void delete(T entity);
     void deleteById(int entityId);
}
