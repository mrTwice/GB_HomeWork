package ru.MyHomework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.MyHomework.DataBase.FactoryDAO;
import ru.MyHomework.DataBase.PersonDAO;
import ru.MyHomework.Models.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Random;

public class Main {
    private static Random random = new Random();
    private static PersonDAO personDAO = FactoryDAO.getInstance().getPersonDAO();

    public static void main(String[] args) {
        //getTestData();

//        personDAO.deleteById(68);
//        personDAO.delete(personDAO.getById(1));
//
//        Person person = personDAO.getById(2);
//        person.setFirstName("Васисуалий");
//        personDAO.update(person);

//        savePersonObjectToFile(personDAO.getById(2));
//        Person person = loadPersonObjectFromFile("ВасисуалийИванов.json");
//        System.out.println(person);





    }

    private static void getTestData(){
        String[] firstNames = {"Александр", "Дмитрий","Максим","Сергей","Андрей","Алексей","Артём","Илья","Кирилл","Михаил","Никита","Матвей","Роман","Егор","Арсений","Иван","Денис","Евгений","Тимофей","Владислав","Игорь","Владимир","Павел","Руслан","Марк","Константин","Тимур","Олег","Ярослав","Антон","Николай","Данил"};
        String[] lastNames = {"Смирнов","Иванов","Кузнецов","Соколов","Попов","Лебедев","Козлов","Новиков","Морозов","Петров","Волков","Соловьёв","Васильев","Зайцев","Павлов","Семёнов","Голубев","Виноградов","Богданов","Воробьёв","Фёдоров","Михайлов","Беляев","Тарасов","Белов","Комаров","Орлов","Киселёв","Макаров","Андреев","Ковалёв","Ильин"};
        for (int i = 0; i < 64; i++) {
            personDAO.create(
                    new Person(firstNames[random.nextInt(0, firstNames.length)]
                            , lastNames[random.nextInt(0, lastNames.length)]
                            , LocalDate.of(random.nextInt(1950, 2005)
                                    , random.nextInt(1, 12)
                                    ,random.nextInt(1, 29)))
            );
        }
    }

    private static void savePersonObjectToFile(Person person){
        try(FileWriter fileWriter = new FileWriter(person.getFirstName()+person.getLastName()+".json")) {
            Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
            String jsonObject = gsonBuilder.toJson(person);
            fileWriter.write(jsonObject);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Person loadPersonObjectFromFile(String fileName){
        StringBuilder jsonFromFile = new StringBuilder();
        Person person = null;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null) {
                jsonFromFile.append(line);
            }
            GsonBuilder personBuilder = new GsonBuilder();
            Gson gson = personBuilder.create();
            person = gson.fromJson(jsonFromFile.toString(), Person.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return person;
    }


}