package ru.MyHomework.DataBase;

import ru.MyHomework.Models.Person;

public class PersonDAO extends HibernateDAO<Person> {
    public PersonDAO() {
        super(Person.class);
    }
}
