package Task_02.MVP;

import Task_02.Base.Calculator;

import java.util.List;

public class Presenter {
    private Model calculator;
    private View view;

    public Presenter(){
        this.calculator = new Model();
        this.view = new View();
    }

    public void start(){
        boolean flag = true;
        while (flag) {
            switch (view.menu()) {
                case 1:
                    double first = view.getDoubleNumber("первое");
                    double second = view.getDoubleNumber("второе");
                    System.out.println(calculator.addition(first, second));
                    break;
                case 2:
                    first = view.getDoubleNumber("первое");
                    second = view.getDoubleNumber("второе");
                    System.out.println(calculator.subtraction(first, second));
                    break;
                case 3:
                    first = view.getDoubleNumber("первое");
                    second = view.getDoubleNumber("второе");
                    System.out.println(calculator.multiplication(first, second));
                    break;
                case 4:
                    first = view.getDoubleNumber("первое");
                    second = view.getDoubleNumber("второе");
                    System.out.println(calculator.division(first, second));
                    break;
                case 5:
                    List<Double> lastResult = calculator.getLastResult();
                    for (Double result : lastResult) {
                        System.out.printf("%f, ", result);
                    }
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Такого пункта меню нет");
                    break;
            }
        }
    }
}
