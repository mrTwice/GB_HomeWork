import java.util.Scanner;

//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class task_04 {
    public static void main(String[] args){
        System.out.print("Ввод: ");
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        if(str == "") {
            throw new RuntimeException("Ай-яй! Пустые строки не вводить");
        } else {
            System.out.println(str);
        }
    }
}


