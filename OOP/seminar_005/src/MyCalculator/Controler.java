package MyCalculator;

import java.util.Scanner;

public class Controler<T extends  Calculating> {
    View view;
    Calculator calculator;

    public Controler(T typeCalculating, View view) {
        this.view = view;
        this.calculator = typeCalculating;
    }

    public void startCalculating() {
        Scanner intputChoise = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            view.printMenu();
            int answer = intputChoise.nextInt();
            switch (answer){
                case 1:
                    calculator.setNumberX(new RealNumbers(view.inputRealPart("a: ")));
                    calculator.setNumberY(new RealNumbers(view.inputRealPart("b: ")));
                    String resultOfSumRealNumbers = calculator.result();
                    view.print(resultOfSumRealNumbers, "Sum: ");
                    break;
                case 2:
                    calculator.setNumberX(new ComplexNumbers(view.inputRealPart("действительная часть первого числа: "),
                            view.inputImaginaryPart("мнимая часть первого числа: ")));
                    calculator.setNumberY(new ComplexNumbers(view.inputRealPart("действительная часть второго числа: "),
                            view.inputImaginaryPart("мнимая часть второго числа: ")));
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
