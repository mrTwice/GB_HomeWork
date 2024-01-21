package org.hometask;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    private CourseDAO courseDAO = Factory.getInstance().getCourseDAO();
    private View view = new View();

    public void start() throws SQLException {
        System.out.println();
        String answer = view.getString("Желаете добавить данные для тестирования? (y|n)\n"+
                "Введите ответ: ");
        if (answer.equals("y")){
            // Добавление списка курсов в таблицу
            ArrayList<Course> courses = new ArrayList<>();
            HashMap<String,String> dataForCourses = TestData.getDataForCourses();
            dataForCourses.forEach((k,v) -> {
                try {
                    Factory.getInstance().getCourseDAO().addCourse(new Course(k,v));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        boolean flag = false;
        while (!flag) {
            view.printMenu();
            switch (view.choice()) {
                case "1": // Распечатать список курсов
                    System.out.println();
                    view.displayCourses(courseDAO.getAllCourses());
                    break;
                case "2": // Добавить курс
                    String titleForAdd = view.getString("Введите название нового курса: ");
                    String durationForAdd = view.getString("Укажите продолжительность: ");
                    Course course = new Course(titleForAdd, durationForAdd);
                    courseDAO.addCourse(course);
                    break;
                case "3": // Удалить курс
                    Course courseForDel = courseDAO.getCourseById(view.getInt("Введите id курса для удаления из БД: "));
                    courseDAO.deleteCourse(courseForDel);
                    break;
                case "4": // Обновить курс
                    Course courseForUpdate = courseDAO.getCourseById(view.getInt("Введите id курса для изменения из БД: "));
                    String titleForUpdate = view.getString("Введите новое название курса: ");
                    String durationForUpdate = view.getString("Укажите продолжительность курса: ");
                    courseForUpdate.setTitle(titleForUpdate);
                    courseForUpdate.setDuration(durationForUpdate);
                    courseDAO.updateCourse(courseForUpdate);
                    break;
                case "5": // Выход
                    flag = true;
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }
        }
    }
}
