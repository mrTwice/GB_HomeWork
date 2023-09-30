import java.util.ArrayList;

public class HeapSort {
    public static void sort (ArrayList<Integer> start) {
        ArrayList<Integer> numbers = start;
        for (int i = numbers.size()/2-1; i >=0; i--)
            heapify(numbers, numbers.size(), i);

        for (int i = numbers.size()-1; i >=0; i--) {
            Integer temp = numbers.get(0);
            numbers.set(0, numbers.get(i));
            numbers.set(i, temp);
            heapify(numbers, i, 0);
        }
    }

    private  static void  heapify(ArrayList<Integer> numbers, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if(leftChild < heapSize && numbers.get(leftChild) < numbers.get(largest))
            largest = leftChild;

        if(rightChild < heapSize && numbers.get(rightChild) < numbers.get(largest))
            largest = rightChild;

        if(largest != rootIndex) {
            Integer temp = numbers.get(rootIndex);
            numbers.set(rootIndex, numbers.get(largest));
            numbers.set(largest, temp);

            heapify(numbers, heapSize, largest);
        }
    }

}
