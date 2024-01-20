package org.hometasks;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    public void displayJournal(ArrayList<Student> students) {
        System.out.println();
            System.out.printf("%4s %17s %7s %11s\n", "id", "Имя", "Возраст", "Средний бал");
            for (Student student : students) {
                System.out.printf("%4s %17s %7d %11.2f\n", student.getId(), student.getName(), student.getAge(), student.getGpa());
            }
        System.out.println();
    }

    public void printMenu(){
        System.out.println();
        System.out.print("1. Распечатать журнал.\n"+
                "2. Добавить студента.\n"+
                "3. Удалить студента.\n" +
                "4. Сохранить журнал в файл.\n"+
                "5. Загрузить журнал из файла.\n"+
                "6. Выход.\n"
        );

        System.out.print("Выберете пункт меню: ");
    }

    public String choice(){
        return scanner.next();
    }

    public String getString(String message){
        System.out.print(message);
        return scanner.next();
    }

    public int getInt(String message){
        System.out.print(message);
        return scanner.nextInt();
    }

    public double getDouble(String message){
        System.out.print(message);
        return scanner.nextDouble();
    }
}
