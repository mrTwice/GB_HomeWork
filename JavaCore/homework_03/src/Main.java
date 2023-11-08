import Base.*;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        /**
         * Создаем объекты Worker и Freelancer
         */
        Employee freelancer1 = Freelancer.createFreelancer("Иван", "Петров", "22/11/1995","+79811234567", 200.99, "Freelancer");
        Employee freelancer2 = Freelancer.createFreelancer("Виктор", "Самогонов", "22/11/1995","+79811234567", 100.99, "Freelancer" );
        Employee freelancer3 = Freelancer.createFreelancer("Александр", "Булкин", "22/11/1995","+79811234567", 9.99, "Freelancer" );
        Employee worker1 = Worker.createWorker("Петр", "Синицин", "22/11/1995","+79811234567", 5000.1, "Worker" );
        Employee worker2 = Worker.createWorker("Виктор", "Воробьев", "22/11/1995","+79811234567", 10000.1, "Worker" );

        /**
         * Наполняем нашими объектами свежесозданную кастомную коллекцию
         */
        EmployeesList<Employee> list = new EmployeesList();
        list.addEmployee(freelancer1);
        list.addEmployee(freelancer2);
        list.addEmployee(freelancer3);
        list.addEmployee(worker1);
        list.addEmployee(worker2);

        /**
         * Выводим ее использую forEach
         */
        list.forEach(Employee -> System.out.println(Employee.toString()));
        System.out.println();

        /**
         * Сортуруем коллекцию, используя метод compareTo
         */
        list.sortEmployee(Employee::compareTo);
        list.forEach(Employee -> System.out.println(Employee.toString()));
        System.out.println();

        /**
         * Создаем объект нашего кастомного компаратора.
         * Сортуруем коллекцию, используя этот компаратор
         * Выводим результаты отсортированный по возрастанию зарплаты.
         */
        EmployeesSalaryComparator salaryComparator = new EmployeesSalaryComparator();
        list.sortEmployee(salaryComparator);
        list.forEach(Employee -> System.out.println(Employee.toString()));
    }
}

