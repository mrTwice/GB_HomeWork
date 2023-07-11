import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(5);
//        list.add(2);
//        list.add(9);
//        list.add(0);
//        list.add(-4);
//        list.removeAt(4);
//        System.out.println(list.getValue(4));
//        list.print();
//        list.reverse();
//        list.print();

        final BinTree tree = new BinTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("finish");
                } catch (Exception ignored){
                }
            }
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }

    }
}