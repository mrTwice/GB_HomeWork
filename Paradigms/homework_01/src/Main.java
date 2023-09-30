import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Императивный вариант");
        ArrayList<Integer> numbers1 = new ArrayList<>(List.of(0, 7, 3, 6, 11, 8, 23, 99, 11));
        sortListImperative(numbers1);

        System.out.println("Декларативный вариант");

        ArrayList<Integer> numbers2 = new ArrayList<>(List.of(0, 7, 3, 6, 11, 8, 23, 99, 11));
        sortListDeclarative(numbers2);
    }

    private static void sortListImperative(ArrayList<Integer> numbers){
        System.out.print("Исходный список: ");
        System.out.println(numbers);
        HeapSort.sort(numbers); // сортировка кучей реальзованная в классе HeapSort
        System.out.print("Результат: ");
        System.out.println(numbers);
        System.out.println();
    }

    private static void sortListDeclarative(ArrayList<Integer> numbers){
        System.out.print("Исходный список: ");
        System.out.println(numbers);
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.print("Результат: ");
        System.out.println(numbers);
        System.out.println();
    }
}