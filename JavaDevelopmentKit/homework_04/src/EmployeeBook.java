import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class EmployeeBook {

   private HashMap<Integer, Employee> employeeBook = new HashMap<>();

   public EmployeeBook() {
      Employee employee = new Employee("Иван", "Петров", 1111111, LocalDate.of(2019,01,9));
      Employee employee1 = new Employee("Светлана", "Иванова", 2222222, LocalDate.of(2020,01,9));
      Employee employee2 = new Employee("Юлия", "Свирь", 3333333, LocalDate.of(2021,01,9));
      Employee employee3 = new Employee("Петр", "Козлов", 4444444, LocalDate.of(2022,01,9));
      Employee employee4 = new Employee("Василий", "Криворотов", 5555555, LocalDate.of(2022,12,31));
      Employee employee5 = new Employee("Алиса", "Кудрявцева", 7777777, LocalDate.of(2022,12,11));
      employeeBook.put(employee.getPersonnelNumber(), employee);
      employeeBook.put(employee1.getPersonnelNumber(), employee1);
      employeeBook.put(employee2.getPersonnelNumber(), employee2);
      employeeBook.put(employee3.getPersonnelNumber(), employee3);
      employeeBook.put(employee4.getPersonnelNumber(), employee4);
      employeeBook.put(employee5.getPersonnelNumber(), employee5);
   }

   public void addNewEmployee(Employee employee){
      if (employee == null)
         throw new RuntimeException("Попытка добавить Null вместо сотрудника");
      employeeBook.put(employee.getPersonnelNumber(), employee);
   }

   public List<Employee> findEmployeeByExp(int exp){
      List<Employee> employees = employeeBook.values().stream().filter(employee -> employee.getExperience() >= exp).toList();
      if(employees.isEmpty())
         throw new RuntimeException("Сотрудников с таким стажем нет");
      return employees;
   }

   public List<Employee> findEmployeePhoneNumberByName(String firstName){
      List<Employee> employees = employeeBook.values().stream().filter(employee -> employee.getFirstName().equals(firstName)).toList();
      if(employees.isEmpty())
         throw new RuntimeException("Сотрудников с таким номером телефона нет");
      return employees;
   }

   public Employee findEmployeeByPersonnelNumber(int personnelNumber){
      return employeeBook.values().stream().filter(employee -> employee.getPersonnelNumber() == personnelNumber).findAny().orElseThrow(() -> new RuntimeException("Cотрудника с таким номером нет"));
   }

   public void printEmployees(){
      employeeBook.values().forEach(System.out::println);
      System.out.println();
   }

   public HashMap<Integer, Employee> getEmployeeBook() {
      return employeeBook;
   }
}
