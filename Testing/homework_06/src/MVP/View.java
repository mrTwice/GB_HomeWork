package MVP;

import Base.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View extends Validation {
    public View(){
    }

    public void message (){
        System.out.println("\n"+"Это консольное приложение, которое вычисляет среднее арифметическое двух списков\n" +
                "и сравнивает полученные значения, по окончании которого выводи сообщение о том, у какого\n" +
                "списка среднее арифметическое больше\n");
    }

    public boolean menu(){
        Scanner menuInput = new Scanner(System.in);
        boolean answer = false;
        System.out.print("Желаете сравнить два списка (Y|N): ");
        if(menuInput.next().equalsIgnoreCase("y"))
            answer = true;
        return answer;
    }

    public List<Integer> inputList(){
        Scanner consoleInput = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();
        boolean stopInput = false;
        System.out.println("Чтобы завершить, введите 'Stop' ");
        while (!stopInput){
            System.out.print("Ввод: ");
            String input = consoleInput.nextLine();
            if(checkInput(input))
                inputList.add(Integer.parseInt(input));
            if(input.equalsIgnoreCase("Stop"))
                stopInput = true;
        }
        return inputList;
    }
}
