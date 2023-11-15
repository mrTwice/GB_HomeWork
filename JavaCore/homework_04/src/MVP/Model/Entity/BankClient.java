package MVP.Model.Entity;

import MVP.Model.Abstract.Client;

public class BankClient extends Client {

    private BankClient(String firstName, String lastName, String birthdayDate, String phoneNumber, String password) {
        super(firstName, lastName, birthdayDate, phoneNumber, password);
    }

    /**
     * Статический метод класса. Отчечает за создание объекта клиента банка
     * @param firstName Имя
     * @param lastName Фамилия
     * @param birthdayDate дата рождения в формате ДД/ММ/ГГГГ
     * @param phoneNumber номер телефона
     * @param password пароль
     * @return вновь созданый обект класса
     * @throws RuntimeException в случае некорректных начальных данных
     */
    public static BankClient createNewClient(String firstName, String lastName, String birthdayDate, String phoneNumber, String password) {
        if (firstName == null) throw new RuntimeException("Введите корректное имя");
        if (lastName == null) throw new RuntimeException("Введите корректную фамилию");
        if (birthdayDate == null) throw new RuntimeException("Введите корректную дату рождения");
        if (phoneNumber == null) throw new RuntimeException("Введите корректный номер телефона");
        if (password == null) throw new RuntimeException("Ваш пароль не отвечает политике безопасности");
        return new BankClient(firstName, lastName, birthdayDate, phoneNumber, password);
    }

}
