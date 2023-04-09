package genealogy.control;

import genealogy.humans.Female;
import genealogy.humans.Male;
import genealogy.humans.Person;

import java.util.Scanner;


public class InputData {
    
    public static Person createMalePerson(){
        Scanner infoPerson = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        String surname = infoPerson.nextLine();
        System.out.print("Введите имя: ");
        String name = infoPerson.nextLine();
        System.out.print("Введите отчество: ");
        String patronym = infoPerson.nextLine();
        System.out.print("Введите дату рождения: ");
        String birthday = infoPerson.nextLine();
        return new Male(surname, name, patronym, birthday);

    }

    public static Person createFemalePerson(){
        Scanner infoPerson = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        String surname = infoPerson.nextLine();
        System.out.print("Введите имя: ");
        String name = infoPerson.nextLine();
        System.out.print("Введите отчество: ");
        String patronym = infoPerson.nextLine();
        System.out.print("Введите дату рождения: ");
        String birthday = infoPerson.nextLine();
        return new Female(surname, name, patronym, birthday);

    }
    
}
