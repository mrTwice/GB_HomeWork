import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteOddNumbers {
    public static void main(String[] args) {
        // Дан список ArrayList<Integer> целых чисел. Удалить из него нечетные числа.

        ArrayList<Integer> numbers = new ArrayList<>(List.of(0, -1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(numbers);
        removeOddNumbers(numbers);
        System.out.println(numbers);
    }

    static void removeOddNumbers(ArrayList<Integer> intList){
        for(int i = 0; i < intList.size(); i++){
            if(intList.get(i)%2 != 0){
                intList.remove(i);
            }
        }
    }
}
