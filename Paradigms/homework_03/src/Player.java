import java.util.Scanner;

public class Player {

    private String name;
    private String mark;
    public Player(String name){
        this.name = name;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return this.mark;
    }

    public String getName() {
        return name;
    }

    public int move(){
        int choice = 0;
        Scanner consoleInput = new Scanner(System.in);
        System.out.print("Ваш выбор: ");
        choice = consoleInput.nextInt();
        return choice;
    }
}
