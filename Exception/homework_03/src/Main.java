import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args)  {
        Contact contact = View.getUserInput();
        Model.saveContact(contact);
    }
}