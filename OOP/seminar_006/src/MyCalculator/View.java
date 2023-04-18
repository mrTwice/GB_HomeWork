package MyCalculator;

import java.util.Scanner;

public class View {
    Scanner input = new Scanner(System.in);

    public double inputRealPart(String item) {
        System.out.printf("%s", item);
        return input.nextDouble();
    }

    public double inputImaginaryPart(String item) {
        System.out.printf("%s", item);
        return input.nextDouble();
    }

    public  void  print (String data, String item) {
        System.out.printf("%s %s\n", item, data);
    }

    public void printMenu() {
        System.out.println("1. Сложить два действительных числа");
        System.out.println("2. Сложить два комплексных числа");
        System.out.println("3. Выход");
        System.out.print("Введите пункт меню: ");
    }
}
