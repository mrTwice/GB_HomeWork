package org.hometask;

import org.hometask.models.Course;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public void displayCourses(List<Course> courses) {
        System.out.println();
        System.out.printf("%5s  %60s %25s\n", "id", "Title", "Duration");
        for(Course course: courses){
            System.out.printf("%5s  %60s %25s\n", course.getId(), course.getTitle(), course.getDuration());

        }
        System.out.println();
    }

    public void printMenu(){
        System.out.println();
        System.out.print("1. Распечатать список курсов.\n"+
                "2. Добавить курс.\n"+
                "3. Удалить курс.\n" +
                "4. Обновить курс.\n"+
                "5. Выход.\n"
        );

        System.out.print("Выберете пункт меню: ");
    }

    public String choice(){
        return scanner.nextLine();
    }

    public String getString(String message){
        System.out.print(message);
        String string = scanner.nextLine();
        return string;
    }

    public int getInt(String message){
        System.out.print(message);
        String string = scanner.nextLine();
        try{
            return Integer.parseInt(string);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

}
