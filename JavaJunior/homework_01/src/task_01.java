import java.util.Arrays;
import java.util.List;

public class task_01 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,5,7,9,1);

        numbers.stream()
                .filter(number -> number%2 == 0)
                .mapToInt(n -> n)
                .average()
                .ifPresentOrElse(
                    (average) -> { System.out.println("Среднее арифметическое равно: " + average); },
                    () -> { System.out.println("Четных чисел в представленном списке нет."); }
                );
    }
}
