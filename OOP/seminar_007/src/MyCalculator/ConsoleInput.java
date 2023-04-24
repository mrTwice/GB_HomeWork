package MyCalculator;

import java.util.Scanner;

public class ConsoleInput implements InputData{

    public ConsoleInput(){

    }
    @Override
    public double inputRealPart(String item) {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s", item);
        return input.nextDouble();
    }

    @Override
    public double inputImaginaryPart(String item) {
        Scanner input = new Scanner(System.in);
        System.out.printf("%s", item);
        return input.nextDouble();
    }
}
