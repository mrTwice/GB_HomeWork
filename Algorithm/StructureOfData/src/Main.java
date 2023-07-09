public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(0);
        list.add(-4);
        //list.removeAt(4);
        //System.out.println(list.getValue(4));
        list.print();
        list.reverse();
        list.print();

    }
}