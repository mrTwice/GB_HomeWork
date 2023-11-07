package Base;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public abstract class Employee implements Comparable<Employee> {

    private static int id = 0;
    private String firstName;
    private String lastName;
    private String birthdayDate;
    private String phoneNumber;
    private String position;

    protected Employee(String firstName, String lastNane, String birthdayDate, String phoneNumber, String position) {
        id++;
        this.firstName = firstName;
        this.lastName = lastNane;
        this.birthdayDate = birthdayDate;
        this.phoneNumber = phoneNumber;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static int getId() {
        return id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public abstract  double getAverageSalary();

    @Override
    public String toString() {
        return id + " " + lastName + " " + firstName+ " " + phoneNumber+ " " + birthdayDate + " " +  position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(birthdayDate, employee.birthdayDate) && Objects.equals(phoneNumber, employee.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthdayDate, phoneNumber);
    }

    @Override
    public int compareTo(Employee o) {
        int result = this.lastName.compareTo(o.lastName);
        if (result == 0)
            result = this.firstName.compareTo(o.firstName);
        return result;
    }
}
