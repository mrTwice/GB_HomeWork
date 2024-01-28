package ru.MyHomework.UseCase;

import ru.MyHomework.DataBase.DAO;
import ru.MyHomework.Models.Person;

import java.time.LocalDate;
import java.util.Random;

public class TestData {
    private static final Random random = new Random();
    public TestData() {
    }

    public static void getTestData(DAO dao){
        String[] firstNames = {"Александр", "Дмитрий","Максим","Сергей","Андрей","Алексей","Артём","Илья","Кирилл","Михаил","Никита","Матвей","Роман","Егор","Арсений","Иван","Денис","Евгений","Тимофей","Владислав","Игорь","Владимир","Павел","Руслан","Марк","Константин","Тимур","Олег","Ярослав","Антон","Николай","Данил"};
        String[] lastNames = {"Смирнов","Иванов","Кузнецов","Соколов","Попов","Лебедев","Козлов","Новиков","Морозов","Петров","Волков","Соловьёв","Васильев","Зайцев","Павлов","Семёнов","Голубев","Виноградов","Богданов","Воробьёв","Фёдоров","Михайлов","Беляев","Тарасов","Белов","Комаров","Орлов","Киселёв","Макаров","Андреев","Ковалёв","Ильин"};
        for (int i = 0; i < 64; i++) {
            dao.create(
                    new Person(firstNames[random.nextInt(0, firstNames.length)]
                            , lastNames[random.nextInt(0, lastNames.length)]
                            , LocalDate.of(random.nextInt(1950, 2005)
                            , random.nextInt(1, 12)
                            ,random.nextInt(1, 29)))
            );
        }
    }
}
