package ru.MyHomework.DataBase;

public class FactoryDAO {
    private static FactoryDAO instance = null;
    private static PersonDAO personDAO = null;

    public static synchronized FactoryDAO getInstance(){
        if(instance==null)
            instance = new FactoryDAO();
        return instance;
    }

    public PersonDAO getPersonDAO(){
        if(personDAO == null)
            personDAO = new PersonDAO();
        return personDAO;
    }
}
