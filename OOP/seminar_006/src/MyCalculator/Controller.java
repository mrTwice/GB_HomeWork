package MyCalculator;

import java.util.Scanner;

public class Controller<T extends  Calculating> {
    PrintToConsole view;
    Calculator calculator;
    ConsoleInput input;

    public Controller(T typeCalculating, PrintToConsole view, ConsoleInput input) {
        this.view = view;
        this.calculator = typeCalculating;
        this.input = input;
    }

    public void startCalculating() {
        Scanner intputChoise = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            view.printMenu();
            int answer = intputChoise.nextInt();
            switch (answer){
                case 1:
                    calculator.setNumberX(new RealNumbers(input.inputRealPart("a: ")));
                    calculator.setNumberY(new RealNumbers(input.inputRealPart("b: ")));
                    String resultOfSumRealNumbers = calculator.result();
                    view.print(resultOfSumRealNumbers, "Sum: ");
                    break;
                case 2:
                    calculator.setNumberX(new ComplexNumbers(input.inputRealPart("действительная часть первого числа: "),
                            input.inputImaginaryPart("мнимая часть первого числа: ")));
                    calculator.setNumberY(new ComplexNumbers(input.inputRealPart("действительная часть второго числа: "),
                            input.inputImaginaryPart("мнимая часть второго числа: ")));
                    String resultOfSumComplexNumbers = calculator.result();
                    view.print(resultOfSumComplexNumbers, "Sum: ");
                    break;
                case 3:
                    flag = false;
                    break;
            }

        }
    }
}
