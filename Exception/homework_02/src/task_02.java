public class task_02 {
    public static void main(String[] args) {
        try {
            int d = 0;
            //double catchedRes1 = intArray[8] / d;
            double catchedRes1 = 8/d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}
