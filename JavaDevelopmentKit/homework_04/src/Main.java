import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EmployeeBook company= new EmployeeBook();
        company.printEmployees();
        company.addNewEmployee(new Employee("Анастасия", "Комарова", 7654321, LocalDate.of(2015, 4, 20)));
        company.addNewEmployee(new Employee("Иван", "Сорокин", 3215321, LocalDate.of(2017, 6, 2)));
        company.printEmployees();

        System.out.println(company.findEmployeeByExp(5));
        System.out.println(company.findEmployeePhoneNumberByName("Иван").);
        System.out.println(company.findEmployeeByPersonnelNumber(4));

    }
}
