package Task_03;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Integer[] arrayFirst = {0,0};
        Integer[] arraySecond = {1,2};
        System.out.println(compareArrays(arrayFirst, arraySecond));

        Integer[] arrayThird = {1,1};
        Integer[] arrayFour = {2,2};
        System.out.println(compareArrays(arrayThird, arrayFour));

        Integer[] arrayFive = {1};
        Integer[] arraySix = {1,2};
        try {
            System.out.println(compareArrays(arrayFive, arraySix));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }




    }

    public static <T> boolean compareArrays(T[] first, T[] second) {
        if(first.length != second.length)
            throw new RuntimeException("Длинны массивов не равны!");
        return Arrays.deepEquals(first, second);
    }
}
