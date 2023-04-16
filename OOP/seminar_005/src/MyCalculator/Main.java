package MyCalculator;

public class Main {
    public static void main(String[] args) {
        Controler sum = new Controler(new Sum(), new View());
        sum.startCalculating();
    }
}
