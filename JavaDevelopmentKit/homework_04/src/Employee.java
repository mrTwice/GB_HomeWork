import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee implements Comparable<Employee>{
    private static final AtomicInteger count = new AtomicInteger(0);
    private String firstName;
    private String lastName;
    private int personnelNumber = 0;
    private long phoneNumber;
    private LocalDate employmentDate;

    public Employee(String firsName, String lastName, long phoneNumber, LocalDate date) {
        this.firstName = firsName;
        this.lastName = lastName;
        this.personnelNumber = count.incrementAndGet();
        this.phoneNumber = phoneNumber;
        this.employmentDate  = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPersonnelNumber() {
        return personnelNumber;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public int getExperience(){
        return LocalDate.now().getYear() - employmentDate.getYear();
    }

    @Override
    public int compareTo(Employee o) {
        int result = this.lastName.compareTo(o.lastName);
        if (result == 0)
            result = this.firstName.compareTo(o.firstName);
        return result;
    }

    @Override
    public String toString() {
        return personnelNumber + " " +  lastName + " " + firstName+ " " + phoneNumber + " " + employmentDate.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(personnelNumber, employee.personnelNumber) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, personnelNumber);
    }
}
