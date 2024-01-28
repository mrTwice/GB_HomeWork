package ru.MyHomework;

import ru.MyHomework.DataBase.FactoryDAO;
import ru.MyHomework.DataBase.PersonDAO;
import ru.MyHomework.Models.Person;
import ru.MyHomework.UseCase.FileManager;
import ru.MyHomework.UseCase.TestData;

import java.io.File;
import java.util.List;

public class Application {
    private final PersonDAO personDAO = FactoryDAO.getInstance().getPersonDAO();
    private final View view = new View();

    public void start() {
        boolean flag = true;
        while (flag){
            view.printMenu();
            String choice = view.getString("Выберете пункт меню: ");
            switch (choice){
                case "1" -> {
                    System.out.println();
                    String answer = view.getString("Желаете добавить данные для тестирования? (y|n)\n"+
                            "Введите ответ: ");
                    if (answer.equals("y")){
                        TestData.getTestData(personDAO);
                    }
                }
                case "2" -> {
                    view.printobjectInfo(personDAO.getAll());
                    personDAO.deleteById(view.getInt("Введите ID для удаления: "));
                }
                case "3" -> {
                    view.printobjectInfo(personDAO.getAll());
                    personDAO.delete(personDAO.getById(view.getInt("Введите ID для выбора записи: ")));
                }
                case "4" -> {
                    view.printobjectInfo(personDAO.getAll());
                    Person person = personDAO.getById(view.getInt("Введите ID записи, имя в которой хотите изменить: "));
                    person.setFirstName(view.getString("Введите новое имя: "));
                    personDAO.update(person);
                }
                case "5" -> {
                    List<Person> persons = personDAO.getAll();
                    for(Person pers: persons){
                        FileManager.saveToJsonFile(pers);
                    }
                }
                case "6" -> {
                    System.out.printf("%5s %15s %15s %15s %7s", "ID", "Имя", "Фамилия", "Дата рождения", "Возраст\n");
                    for(File file: FileManager.getJsonFiles(".")){
                        Person pers = FileManager.loadFromJsonFile(file.getName());
                        System.out.printf("%5s %15s %15s %15s %7s\n", pers.getId(), pers.getFirstName(), pers.getLastName(), pers.getBirthdayDate(), pers.getAge());
                    }
                }
                case "7" -> flag = false;
            }
        }

    }




}