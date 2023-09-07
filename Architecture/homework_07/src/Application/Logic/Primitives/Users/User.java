package Application.Logic.Primitives.Users;

public class User {
    private String firstName;
    private String lastname;
    private String phoneNumber;
    private String emailAddress;

    public User(String firstName, String lastname, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
