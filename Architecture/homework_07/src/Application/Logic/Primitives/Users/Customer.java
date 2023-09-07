package Application.Logic.Primitives.Users;

public class Customer extends User{
    private static int idCustomer = 0;
    public Customer(String firstName, String lastname, String phoneNumber, String emailAddress) {
        super(firstName, lastname, phoneNumber, emailAddress);
        this.idCustomer++;
    }

    public static int getIdCustomer() {
        return idCustomer;
    }
}
