package Application.Logic.Primitives.Users;

public class Staff extends User {
    private static int idStaff = 0;
    public Staff(String firstName, String lastname, String phoneNumber, String emailAddress) {
        super(firstName, lastname, phoneNumber, emailAddress);
        this.idStaff++;
    }

    public static int getIdStaff() {
        return idStaff;
    }
}
