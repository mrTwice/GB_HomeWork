package MVP;

import Base.InputOutput;
import Base.Validation;

import java.util.ArrayList;
import java.util.List;

public class View extends Validation {
    private InputOutput inputOutput;

    public View(InputOutput inputOutput){
        this.inputOutput = inputOutput;
    }

    public boolean menu(){
        System.out.print("Желаете сравнить два списка (Y|N): ");
        return inputOutput.getChoise();
    }

    public List<Integer> inputList(){
        List<Integer> inputList = new ArrayList<>();
        boolean stopInput = false;
        System.out.println("Чтобы завершить, введите 'Stop' ");
        while (!stopInput){
            System.out.print("Ввод: ");
            String input = inputOutput.getInput();
            if(checkInput(input))
                inputList.add(Integer.parseInt(input));
            if(input.equalsIgnoreCase("Stop"))
                stopInput = true;
        }
        return inputList;
    }

}
