package org.hometask;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Класс фабрики сессий
 */
public class DataBaseConnector {
    private final SessionFactory sessionFactory;

    public DataBaseConnector() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Возвращает открытую сессию
     * @return
     */

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
