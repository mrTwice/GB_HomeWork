package MyCalculator.MVP;

import MyCalculator.Input.ConsoleInput;
import MyCalculator.Functions.Sum;

public class Presenter {
    public static void startApp(){
        Model sum = new Model(new Sum(), new PrintToConsole(), new ConsoleInput());
        sum.startCalculating();
    }
}
