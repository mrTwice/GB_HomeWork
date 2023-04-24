package MyCalculator.MVP;

import MyCalculator.MVP.View;

public class PrintToConsole implements View {

    @Override
    public  void  print (String data, String item) {
        System.out.printf("%s %s\n", item, data);
    }

    @Override
    public void printMenu() {
        System.out.println("1. Сложить два действительных числа");
        System.out.println("2. Сложить два комплексных числа");
        System.out.println("3. Выход");
        System.out.print("Введите пункт меню: ");
    }
}
