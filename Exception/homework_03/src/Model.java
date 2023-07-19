import java.io.FileWriter;
import java.io.IOException;

public class Model {

    public static void saveContact(Contact currentContact){
        try (FileWriter writer = new FileWriter(currentContact.getLastName()+".txt", true)){
            writer.write(
                    currentContact.getFirstName() + " " +
                    currentContact.getLastName() + " " +
                    currentContact.getBirthday() + " " +
                    currentContact.getPhoneNumber() + " " +
                    currentContact.getGender());
            writer.write(System.getProperty( "line.separator" ));
            writer.close();
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
