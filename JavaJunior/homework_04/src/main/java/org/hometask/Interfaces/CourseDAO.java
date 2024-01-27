package org.hometask.Interfaces;

import org.hometask.models.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO {
    /**
     * Добавление нового курса
     * @param course
     * @throws SQLException
     */
    public void addCourse(Course course) throws SQLException;

    /**
     * Обновление данных курса
     * @param course
     * @throws SQLException
     */
    public void updateCourse(Course course) throws SQLException;

    /**
     * Получения курса по его id
     * @param id
     * @return
     * @throws SQLException
     */
    public Course getCourseById(int id) throws SQLException;

    /**
     * Получения списка всех курсов
     *
     * @return
     * @throws SQLException
     */
    public List<Course> getAllCourses() throws SQLException;

    /**
     * Удаление курса
     * @param course
     * @throws SQLException
     */
    public void deleteCourse(Course course) throws SQLException;
}