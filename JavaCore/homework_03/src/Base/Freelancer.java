package Base;

public class Freelancer extends Employee{

    private double hourlyRate;

    private Freelancer(String firstName, String lastNane, String birthdayDate, String phoneNumber, double hourlyRate, String position) {
        super(firstName, lastNane, birthdayDate, phoneNumber, position);
        this.hourlyRate = hourlyRate;
    }

    public static Freelancer createFreelancer(String firstName, String lastNane, String birthdayDate, String phoneNumber, double hourlyRate, String position){
        if(firstName == null)
            throw new RuntimeException("Имя введено не корректно");
        if(lastNane == null)
            throw new RuntimeException("Фамилия введена не корректно");
        if(birthdayDate == null)
            throw new RuntimeException("Некорректная дата рождения");
        if(phoneNumber == null)
            throw new RuntimeException("Номер телефона не указан или указан не верно");
        if(hourlyRate <= 0.0)
            throw new RuntimeException("Значение почасовой оплаты не может быть меньше или равно нулю");
        if(position == null)
            throw new RuntimeException("Не указана позиция сотрудника");

        return new Freelancer(firstName, lastNane, birthdayDate, phoneNumber, hourlyRate, position);
    }

    @Override
    public double getAverageSalary(){
        return 20.8 * 8 * hourlyRate;
    }
}
