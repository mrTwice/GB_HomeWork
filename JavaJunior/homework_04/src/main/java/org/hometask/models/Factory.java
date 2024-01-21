package org.hometask.models;

import org.hometask.Interfaces.CourseDAO;

/**
 * Фабрика реалиций DAO
 */
public class Factory {
    private static Factory instance = null;
    private static CourseDAO courseDAO = null;

    public static synchronized Factory getInstance(){
        if(instance==null)
            instance = new Factory();
        return instance;
    }

    /**
     * Получение инстанса CourseDAOImpl
     * @return
     */
    public CourseDAO getCourseDAO(){
        if(courseDAO == null)
            courseDAO = new CourseDAOImpl();
        return courseDAO;
    }
}
