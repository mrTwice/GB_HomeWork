package Application.Logic.Primitives.Users;

public class Supplier extends User{
    private static int idSupplier = 0;
    private int idProduct;

    public Supplier(String firstName, String lastname, String phoneNumber, String emailAddress, int idProduct) {
        super(firstName, lastname, phoneNumber, emailAddress);
        this.idSupplier++;
        this.idProduct = idProduct;
    }

}
