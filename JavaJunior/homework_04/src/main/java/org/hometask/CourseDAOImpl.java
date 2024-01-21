package org.hometask;

import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс имплементирующий интерфейс CourseDAO
 */

public class CourseDAOImpl implements CourseDAO {
    private final DataBaseConnector dbConnector = new DataBaseConnector();

    /**
     * Добавление курса
     * @param course
     * @throws SQLException
     */
    @Override
    public void addCourse(Course course) throws SQLException {
        try(Session session = dbConnector.getSession()) {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Обновление существующего курса
     * @param course
     * @throws SQLException
     */
    @Override
    public void updateCourse(Course course) throws SQLException {
        try(Session session = dbConnector.getSession()){
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Получение курса по id
     * @param id
     * @return
     * @throws SQLException
     */

    @Override
    public Course getCourseById(int id) throws SQLException {
        Course course = null;
        try(Session session = dbConnector.getSession()){
            course = session.get(Course.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return course;
    }

    /**
     * Получение списка курсов
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        try(Session session = dbConnector.getSession()){
            courses = session.createQuery("FROM Course ", Course.class).getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * Удаление курса из базы данных
     * @param course
     * @throws SQLException
     */
    @Override
    public void deleteCourse(Course course) throws SQLException {
        try(Session session = dbConnector.getSession()){
            session.beginTransaction();
            session.delete(course);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
