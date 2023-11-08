package Base;

import java.util.*;
import java.util.function.Consumer;

/**
 * Была цель реализовать интерфейс Iterable, с тем чтобы поработать с ним, и немного разобраться с внутренней кухней.
 * Поэтому пошел по относительно простому пути.
 * @param <Employee>
 */

public class EmployeesList<Employee> implements Iterable<Employee>{

    private List<Employee> employeeList;

    public EmployeesList(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public void sortEmployee(Comparator<? super Employee> comparator){
        employeeList.sort(comparator);
    }

    @Override
    public void forEach(Consumer<? super Employee> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Iterator<Employee> iterator() {
        return employeeList.iterator();
    }

    @Override
    public Spliterator<Employee> spliterator() {
        return Iterable.super.spliterator();
    }
}
