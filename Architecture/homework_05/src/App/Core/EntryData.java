package App.Core;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntryData implements Validation{

    protected int checkIntChoiceEntryMenu(int firstMenuItem, int lastMenuItem){
        int choice = 0;
        Scanner in = new Scanner(System.in);
        try {
            choice = in.nextInt();
        } catch (InputMismatchException ex) {
            throw new RuntimeException("This is not number.");
        } catch (Exception ex) {
            throw new RuntimeException("Something wrong.");
        }
        if (choice < firstMenuItem || choice > lastMenuItem) {
            throw new RuntimeException("You entered an invalid value.");
        }
        return choice;
    }
}
