import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] array = {1,12,45,3,28,5,9,356,5,74};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(binSearch(array, 45, 0, array.length-1));

    }


    private static int binSearch(int[] array, int findNumber, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex )
            return (array[leftIndex] == findNumber) ? leftIndex : -1;

        int middle = leftIndex + (rightIndex - leftIndex) / 2;

        if (findNumber > array[middle])
            return binSearch(array, findNumber, middle + 1, rightIndex);
        if (findNumber < array[middle])
            return binSearch(array, findNumber, leftIndex, middle -1);
        return middle;
    }
}