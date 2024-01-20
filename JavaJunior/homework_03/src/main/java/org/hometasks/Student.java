package org.hometasks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Student implements Serializable {
    private static  final AtomicInteger count = new AtomicInteger(0);
    /**
     * id студента
     */
    private Integer id = 0;

    /**
     * Имя студента
     */
    private String name;

    /**
     * Возраст студента
     */
    private Integer age;

    /**
     * Средний бал студента
     */
    @JsonIgnore
    private transient Double gpa;

    public Student() {
    }

    public Student(String name, Integer age, Double gpa) {
        this.id = count.getAndIncrement();
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    /**
     * Получить id студента
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Получить имя студента
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Получить возраст студента
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Получить средний бал студента
     * @return
     */
    public Double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return  "["+ id + "]" +" "+ name +" "+ age +" "+ gpa;
    }
}
