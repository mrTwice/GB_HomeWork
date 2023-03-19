import java.util.*;

public class HomeWork_005 {
    /**
     * Есть тест. Нужно извлечь из него все слова и отсортировать по длине.
     * Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись
     *
     * и
     * ты
     * Еще
     * день друг Пора
     * 1. Разбить текст по пробелам.
     * 2. Передать его в массив
     * 3. Пробегаясь по элементам массива получать значение размера строки
     * 4. Помещать в Map в зависимости от размера
     *
     */
    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        Scanner consoleInput = new Scanner(System.in);
        String[] words = consoleInput.nextLine().split(" ");
        Map<Integer, ArrayList<String>> stats = new HashMap<>();

        fillHashMap(words, stats);
        printResult(stats);
    }

    static void printResult(Map<Integer, ArrayList<String>> myMap){
        for (Map.Entry<Integer, ArrayList<String>> entry: myMap.entrySet()) {
            Integer key = entry.getKey();
            ArrayList value = entry.getValue();
            System.out.print(key + ": ");
            for (Object word: value) {
                System.out.print(word +" ");
            }
            System.out.println();
        }
    }

    static void fillHashMap(String[] array, Map<Integer, ArrayList<String>> myHashMap ){
        for (String item: array){
            myHashMap.computeIfAbsent(item.length(), k -> new ArrayList<>()).add(item);
        }
    }
}
