import java.util.Scanner;

/*
В решении задачи применена процедурная и структурная парадигмы. Выражается это в том,
что прогамма разбита на несколько методов, каждый из которых выпоняет часть своей работы.
При методы содержат структурные конструкции, такие как циклы и операторы ветвления.

Такой подход позволяет легко отслеживать ошибки, которые могут возникать в процессе выполнения программы.
Переиспользовать написанный код.
Улучшает читаемость кода, позволяя быстрее в нем разобраться.
Позволяет легко менять вывод результата

inputInt() - в данноме методе существаляется ввод данных пользователем, и вызов методов, отвечающих за проверку введенных данных
checkInput(String userString) - в данном методе осуществляется  проверка введенных данных, на соответствие требуемому типу
checkRange(int userNumber) - проверяет, что введенное число лежит в обозначенном диапазоне
printMultiplicationTable(int number) - выводит таблицу умножения, на основе веденного числа.


*/
public class Main {

    private static int inputInt() { // отвечает за взаимодействие с пользователем, получая от него ввод из консоли
        System.out.println((char)27 + "[37m" + "Введите число от 1 до 9: ");
        Scanner consoleInput = new Scanner(System.in);
        int number = 0;
        String inputNumber = consoleInput.nextLine();
        while (checkInput(inputNumber) || checkRange(Integer.parseInt(inputNumber))){
            System.out.println((char)27 + "[37m" + "Введите число от 1 до 9: ");
            inputNumber = consoleInput.nextLine();
        }
        number = Integer.parseInt(inputNumber);
        return number;
    }

    private static boolean checkInput(String userString) { // отвечает за проверку введенных данных, на предмет соответствия решаемой задаче
        try {
            Integer.parseInt(userString);
            return false;
        } catch (NumberFormatException e) {
            System.out.println((char)27 + "[31m" + "Вы ввели не число!");
            return true;
        }
    }

    private static boolean checkRange(int userNumber) { // отвечает за проверку диапазона, к которому должно относится ввиденное число
        if (userNumber < 1 || userNumber > 9) {
            System.out.println((char)27 + "[31m" + "Введенное число не из диапазона [1, 9]");
            return true;
        }
        return false;
    }

    private static void printMultiplicationTable(int number) {
        for (int i = 1; i <= number; i++){
            for (int j = 1; j <= number; j++){
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMultiplicationTable(inputInt());
    }

}