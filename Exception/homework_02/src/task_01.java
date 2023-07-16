//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
//Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class task_01 {
    public static void main(String[] args) {
        boolean Exit = false;
        do {
            Scanner console = new Scanner(System.in);
            System.out.println("Введите число, разделяя дробную и десятичну части запятой.");
            System.out.print("Ввод: ");
            if(console.hasNextFloat()){
               float number = (console.nextFloat());
               System.out.println(number);
            } else {
                if (console.hasNext("Exit")){
                    Exit= true;
                } else {
                    System.out.println("Вы ввели не число!");
                }
            }
            console.close();
        } while (!Exit);
    }
}