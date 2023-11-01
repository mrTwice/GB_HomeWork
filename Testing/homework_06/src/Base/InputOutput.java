package Base;

import java.util.Scanner;

public class InputOutput {

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public boolean getChoise(){
        String str = getInput();
        if (str.equalsIgnoreCase("y")){
            return true;
        } else if (str.equalsIgnoreCase("n")) {
            return false;
        } else throw new RuntimeException("Не корректный ввод");
    }
}
