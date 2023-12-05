package Task_04;

import java.util.ArrayList;
import java.util.Collections;

public class Pair  <T, E> {
    private T first;
    private E second;

    public Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "First: " + first.toString() + "\n" +
                "Second: " + second.toString()+"\n";
    }

    public static void main(String[] args) {
        int[] array = {1,2};
        Pair<Integer, String> pair = new Pair(1, "1");
        Pair<Double, String> pair1 = new Pair(1.0, "1");
        Pair<Integer, int[]> pair2 = new Pair(1, array);
        Pair<int[], Character> pair3 = new Pair(1, '1');

        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(pair);
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);

        for (Pair p: pairs){
            System.out.println("##########################");
            System.out.println(p.getFirst());
            System.out.println(p.getSecond());
        }
    }
}
