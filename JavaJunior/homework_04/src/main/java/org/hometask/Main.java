package org.hometask;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Main {
    private static final Random random = new Random();
    public static void main(String[] args) throws SQLException {

        // Добавление списка курсов в таблицу
        ArrayList<Course> courses = new ArrayList<>();
        HashMap<String,String> dataForCourses = getDataForCourses();
        dataForCourses.forEach((k,v) -> {
            try {
                Factory.getInstance().getCourseDAO().addCourse(new Course(k,v));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        // Получение всего списка курсов из таблицы
        ArrayList<Course> coursesFormDB = (ArrayList<Course>) Factory.getInstance().getCourseDAO().getAllCourses();
        System.out.printf("%5s  %60s %25s\n", "id", "Title", "Duration");
        for(Course course: coursesFormDB){
            System.out.printf("%5s  %60s %25s\n", course.getId(), course.getTitle(), course.getDuration());

        }

        // Получение курса по id
        Course course = Factory.getInstance().getCourseDAO().getCourseById(1);
        System.out.printf("%5s  %60s %25s\n", "id", "Title", "Duration");
        System.out.printf("%5s  %60s %25s\n", course.getId(), course.getTitle(), course.getDuration());

        // Внесение изменений в объект полученного курса
        course.setDuration("Изменения для контроля");
        Factory.getInstance().getCourseDAO().updateCourse(course);

        // Удаление курса
        course = Factory.getInstance().getCourseDAO().getCourseById(1);
        System.out.printf("%5s  %60s %25s\n", "id", "Title", "Duration");
        System.out.printf("%5s  %60s %25s\n", course.getId(), course.getTitle(), course.getDuration());

        Course courseForDel = Factory.getInstance().getCourseDAO().getCourseById(1);
        Factory.getInstance().getCourseDAO().deleteCourse(courseForDel);

   }

    private static HashMap<String , String > getDataForCourses(){
        HashMap<String,String> cources = new HashMap<>();
        cources.put("Введение в алгоритмы и структуры данных","1 семестр");
        cources.put("Основы линейной алгебры","1 семестр");
        cources.put("Статистика для начинающих","1 семестр");
        cources.put("Программирование на Python","2 семестра");
        cources.put("Веб-разработка с использованием HTML, CSS и JavaScript","2 семестра");
        cources.put("Математический анализ","3 семестра");
        cources.put("Дифференциальные уравнения","1 семестр");
        cources.put("Теория вероятностей и математическая статистика","3 семестра");
        cources.put("Базы данных и SQL","1 семестр");
        cources.put("Объектно-ориентированное программирование","2 семестра");
        cources.put("Компьютерная графика","1 семестр");
        cources.put("Искусственный интеллект и машинное обучение","2 семестра");
        cources.put("Операционные системы","1 семестр");
        cources.put("Электротехника","2 семестра");
        cources.put("Электроника","2 семестра");
        cources.put("Квантовая механика","2 семестра");
        cources.put("Классическая механика","2 семестра");
        cources.put("Астрономия","1 семестр");
        cources.put("Экономика","2 семестра");
        cources.put("Финансы","1 семестр");
        cources.put("Маркетинг","1 семестр");
        cources.put("Менеджмент","1 семестр");
        cources.put("Психология","1 семестр");
        cources.put("Социология","1 семестр");
        cources.put("Философия","1 семестр");
        cources.put("История","1 семестр");
        cources.put("Литература","1 семестр");
        cources.put("Искусствоведение","1 семестр");
        cources.put("Экология","1 семестр");
        cources.put("Биология","1 семестр");
        cources.put("Химия","1 семестр");
        return cources;
    }


}
