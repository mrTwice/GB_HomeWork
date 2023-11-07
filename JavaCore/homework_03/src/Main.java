import Base.Employee;
import Base.EmployeesList;
import Base.Freelancer;
import Base.Worker;

public class Main {
    public static void main(String[] args) {
        Employee freelancer1 = Freelancer.createFreelancer("Иван", "Петров", "22/11/1995","+79811234567", 99.99, "Freelancer");
        Employee freelancer2 = Freelancer.createFreelancer("Виктор", "Булкин", "22/11/1995","+79811234567", 99.99, "Freelancer" );
        Employee freelancer3 = Freelancer.createFreelancer("Александр", "Булкин", "22/11/1995","+79811234567", 99.99, "Freelancer" );
        Employee worker1 = Worker.createWorker("Петр", "Синицин", "22/11/1995","+79811234567", 2000.1, "Worker" );
        Employee worker2 = Worker.createWorker("Виктор", "Воробьев", "22/11/1995","+79811234567", 2000.1, "Worker" );

        EmployeesList<Employee> list = new EmployeesList();
        list.addEmployee(freelancer1);
        list.addEmployee(freelancer2);
        list.addEmployee(freelancer3);
        list.addEmployee(worker1);
        list.addEmployee(worker2);

        list.forEach(Employee -> System.out.println(Employee.getFirstName()));
        System.out.println();

        list.sortEmployee(Employee::compareTo);
        list.forEach(Employee -> System.out.println(Employee.getFirstName()));
    }
}

