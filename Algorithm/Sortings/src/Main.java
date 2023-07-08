public class Main {
    static void printArray(int[] array)
    {
        for (int j : array) System.out.print(j + " ");
        System.out.println();
    }

    // Управляющая программа
    public static void main(String[] args)
    {
        int[] array = {12, 11, 13, 5, 6, 7};
        HeapSort.sort(array);

        System.out.println("Sorted array is");
        printArray(array);
    }
}
