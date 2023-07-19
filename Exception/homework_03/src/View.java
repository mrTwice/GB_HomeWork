import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class View {

     public static Contact getUserInput(){
         DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
         System.out.println("Введите имя, фамилию, дату рождения (дд.мм.гггг), номер телефон и пол через пробел.");
         System.out.println("Ввод:");
         Scanner console = new Scanner(System.in);
         String userInput = console.nextLine();
         String[] splitInput = Checking.checkUserInput(userInput).split(" ");
         String firstName = Checking.checkFirstName(splitInput[0]);
         String lastName = Checking.checkLastName(splitInput[1]);
         LocalDate birthday  = LocalDate.parse(Checking.checkBirthday(splitInput[2]), format);
         long phoneNumber = Long.parseLong(Checking.checkPhoneNumber(splitInput[3]));
         String gender = Checking.checkGender(splitInput[4]);
         return new Contact(firstName, lastName, birthday, phoneNumber, gender);
     }
}
