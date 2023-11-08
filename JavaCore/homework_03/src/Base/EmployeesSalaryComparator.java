package Base;

import java.util.Comparator;

/**
 * Класс реализующий интерфейс компаратора, который сортирует наши побъекты в соответствии с зарплатой.
 */
public class EmployeesSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getAverageSalary(), o2.getAverageSalary());
    }
}
