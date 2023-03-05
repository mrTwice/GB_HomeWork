import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        // Проверить, что сумма a и b лежит между 10 и 20
        System.out.println(isSumBetween10And20(5, 15)); // true
        System.out.println(isSumBetween10And20(7, 15)); // false
        System.out.println();

        // Проверить, что х положительное
        System.out.println(isPositive(5)); // true
        System.out.println(isPositive(-3)); // false
        System.out.println();

        // Напечатать строку source repeat раз
        printString("abcd", 5); // abcdabcdabcdabcdabcd
        System.out.println();

        // Проверить, является ли год високосным. если да - return true
        System.out.println(isLeapYear(1988)); // true
        System.out.println(isLeapYear(1700)); // false
        System.out.println();

        // Должен вернуть массив длины len, каждое значение которого равно initialValue
        System.out.println(
                Arrays.toString(
                        createArray(9, 7)
                )
        );
        System.out.println();

        // Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arrayForReplace = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arrayForReplace.length; i++) {
            if (arrayForReplace[i] == 1) {
                arrayForReplace[i] = 0;
            }
            else arrayForReplace[i] = 1;
        }
        System.out.println(Arrays.toString(arrayForReplace));
        System.out.println();

        // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arrayLessThen6 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i < arrayLessThen6.length; i ++) {
            if (arrayLessThen6[i] < 6) {
                arrayLessThen6[i] = arrayLessThen6[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arrayLessThen6));
        System.out.println();

        // 3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
        // Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
        // то есть [0][0], [1][1], [2][2], …, [n][n]; Также заполнить элементы побочной диагонали
        int[][] array = new int[5][5]; // [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, x], [0, 0, 0, 1]]
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || j == array.length - 1 - i) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();

        }


    }

    private static boolean isSumBetween10And20(int a, int b) {
        if (a + b >= 10 && a + b <= 20){
            return true;
        }
        return false;
    }

    private static boolean isPositive(int x) {
        if (x > 0) {
            return true;
        }
        return false;
    }

    private static void printString(String source, int repeat) {
        String newSource = "";
        for (int i = 0; i < repeat; i++) {
            newSource += source;
        }
        System.out.println(newSource);
    }

    private static boolean isLeapYear(int year) {
        if (year % 100 != 0 && year % 4 == 0) {
            return true;
        }

        if (year % 100 == 0 && year % 400 == 0) {
            return true;
        }
        return false;
    }

    private static int[] createArray(int len, int initalValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initalValue;
        }
        return array;
    }

}