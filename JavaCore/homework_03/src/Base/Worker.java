package Base;

public class Worker extends Employee{
    private double salary;

    private Worker(String firstName, String lastNane, String birthdayDate, String phoneNumber, double salary, String position) {
        super(firstName, lastNane, birthdayDate, phoneNumber, position);
        this.salary = salary;
    }

    /**
     * Последовал примеру на семинар, и использовал данный метод, для того, чтобы можно было организтвать проверку полей до создания объекта.
     * Какую-то логику тут реализовывать не стал, потмоу как цель домашней работы была в другом.
     * @param firstName
     * @param lastNane
     * @param birthdayDate
     * @param phoneNumber
     * @param salary
     * @param position
     * @return
     */
    public static Worker createWorker(String firstName, String lastNane, String birthdayDate, String phoneNumber, double salary, String position){
        if(firstName == null)
            throw new RuntimeException("Имя введено не корректно");
        if(lastNane == null)
            throw new RuntimeException("Фамилия введена не корректно");
        if(birthdayDate == null)
            throw new RuntimeException("Некорректная дата рождения");
        if(phoneNumber == null)
            throw new RuntimeException("Номер телефона не указан или указан не верно");
        if(salary <= 0.0)
            throw new RuntimeException("Значение зарплаты не может быть меньше или равно нулю");
        if(position == null)
            throw new RuntimeException("Не указана позиция сотрудника");

        return new Worker(firstName, lastNane, birthdayDate, phoneNumber, salary, position);
    }

    /**
     * Реализация метода абстрактного класса-родителя
     * @return
     */
    @Override
    public double getAverageSalary(){
        return salary;
    }
}
