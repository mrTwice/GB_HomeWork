import java.util.Scanner;

public class Task_01 {
    /*
        1. Дано четное число N (>0) и символы c1 и c2. Написать метод, который вернет строку длины N,
        которая состоит из чередующихся символов c1 и c2, начиная с c1. (6, 'a', 'b') -> "ababab"
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Введите число повторений: ");
        int number = console.nextInt();

        System.out.print("Введите первый символ: ");
        String one = console.next();

        System.out.print("Введите второй символ: ");
        String two = console.next();

        System.out.print("Результат: ");
        System.out.println(alternation(number, one, two));
    }

    public static StringBuilder alternation(int number, String charOne, String charTwo) {
        StringBuilder altString = new StringBuilder();
        for (int i = 0; i < number; i++) {
            if (i%2 == 0){altString.append(charOne);}
            else altString.append(charTwo);
        }
        return altString;
    }


}
