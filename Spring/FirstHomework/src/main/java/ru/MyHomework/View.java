package ru.MyHomework;

import ru.MyHomework.Models.Person;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public void printMenu(){
        System.out.println("1. Добавление данных для тестирования приложения.\n"+
                "2. Удаление записи по ID.\n"+
                "3. Удаление объекта.\n"+
                "4. Изменение имени в записи.\n"+
                "5. Получить все объекты Person из БД и сериализовать в JSON\n"+
                "6. Найти все сеарилизованные объекты и  десериализовать их.\n"+
                "7. Завершить работу.\n");
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

    public void printobjectInfo(List<Person> persons){
        System.out.printf("%5s %15s %15s %15s %7s", "ID", "Имя", "Фамилия", "Дата рождения", "Возраст\n");
        for(Person pers: persons){
            System.out.printf("%5s %15s %15s %15s %7s\n", pers.getId(), pers.getFirstName(), pers.getLastName(), pers.getBirthdayDate(), pers.getAge());;
        }
    }
}
