package MyPhoneBook;

import java.util.Scanner;

public class ConsoleView implements View{
    Scanner consoleInput;

    public ConsoleView() {
        consoleInput = new Scanner(System.in);
    }

    @Override
    public String getFirstName() {
        System.out.printf("FirstName: ");
        return consoleInput.nextLine();
    }

    @Override
    public void setFirstName(String value) {
        System.out.printf("FirstName: %s\n", value);
    }

    @Override
    public String getLastName() {
        System.out.printf("LastName: ");
        return consoleInput.nextLine();
    }

    @Override
    public void setLastName(String value) {
        System.out.printf("LastName: %s\n", value);
    }

    @Override
    public String getPhoneNumber() {
        System.out.printf("PhoneNumber: ");
        return consoleInput.nextLine();
    }

    @Override
    public void setPhoneNumber(String value) {
        System.out.printf("PhoneNumber: %s\n", value);
    }
}
