package Task_01;

import java.io.DataInputStream;

public class Main {
    public static void main(String[] args) {
        String t = "ololo";
        DataInputStream v = new DataInputStream(System.in);
        Integer k = 5;
        ExampleClass<String, DataInputStream, Integer> megaObject = new ExampleClass<>(t, v, k);
        megaObject.printTypes();

        Number[] numArray = new Number[3];
        numArray[0] = 1;
        numArray[1] = 2.0f;
        numArray[2] = 29384759823476L;
        ExampleList<Number> exampleList = new ExampleList<>(numArray);
        exampleList.printList();

        System.out.println(exampleList.getSize());

        Integer num = 5;
        exampleList.add(num);

        exampleList.printList();
        System.out.println("size:"+exampleList.getSize());
        System.out.println("array length:"+exampleList.getArrayLength());

        exampleList.remove(2);
        exampleList.printList();
        System.out.println("size:"+exampleList.getSize());
        System.out.println("array length:"+exampleList.getArrayLength());

        for (Number number :
                exampleList) {
            System.out.println(number);
        }
    }

}