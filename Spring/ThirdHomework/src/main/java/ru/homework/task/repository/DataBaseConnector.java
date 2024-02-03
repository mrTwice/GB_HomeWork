package ru.homework.task.repository;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseConnector {

    private SessionFactory sessionFactory;

    @Autowired
    public DataBaseConnector(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    /**
     * Возвращает открытую сессию
     * @return
     */

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
