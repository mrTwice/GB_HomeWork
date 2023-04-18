package MyCalculator;

public class Main {
    public static void main(String[] args) {
        Controller sum = new Controller(new Sum(), new View());
        sum.startCalculating();
    }
}
