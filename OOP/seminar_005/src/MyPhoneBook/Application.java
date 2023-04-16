package MyPhoneBook;

import java.util.Scanner;

public class Application {
    public static void start() {
        System.out.print("\033[H\\033[J");
        View view = new ConsoleView();
        Controler controler = new Controler(view, "/Users/fish/Desktop/homework/OOP/seminar_005/src/MyPhoneBook/phonebook.db");
        controler.LoadFromFile();

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.println("1 - prev\n2 - next\n3 - add Contact\n4 - remove currentContact\n5 - Save");
                String key = input.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        controler.prev();
                        break;
                    case "2":
                        controler.next();
                        break;
                    case "3":
                        controler.add();
                        break;
                    case "4":
                        controler.remove();
                        break;
                    case "5":
                        controler.saveToFile();
                        break;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }
}
