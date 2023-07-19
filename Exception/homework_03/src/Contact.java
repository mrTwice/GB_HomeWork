import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Contact implements Comparable<Contact>{
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private long phoneNumber;
    private  String gender;

    public Contact(String firstName, String lastName, LocalDate Birthday, long phoneNumber, String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = Birthday;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public int compareTo(Contact contact) {
        if (contact.lastName.charAt(0)< this.lastName.charAt(0))
            return 1;
        if (contact.lastName.charAt(0) > this.lastName.charAt(0))
            return -1;
        return 0;
    }

    private boolean equals(Contact contact) {
        Contact t = contact;
        return this.firstName == t.firstName
                && this.lastName == t.lastName;
    }
}
