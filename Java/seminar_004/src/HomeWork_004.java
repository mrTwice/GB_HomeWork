import java.util.*;

public class HomeWork_004 {

    /*
        Реализовать консольное приложение, которое:
        Принимает от пользователя строку вида text~num
        Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
        Если введено print~num, выводит строку из позиции num в связном списке.
        Если введено exit, завершаем программу
        Пример:
        string~4
        num~3
        print~3
        num
        print~4
        string
        my_value~1
        print~1
        my_value
     */
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        printMenu();
        while (true) {
            Scanner consoleInput = new Scanner(System.in);
            System.out.print("Введите команду или строку: ");
            String textLine = consoleInput.nextLine();
            String[] afterSplit = textLine.split("~");

            if (afterSplit.length > 2){
                System.out.print("Ввод не корректен! Введите команду или строку: ");
            } else if(afterSplit[0].equals("exit")){
                break;
            } else if (afterSplit[0].equals("menu")) {
                printMenu();
            } else if (afterSplit[0].equals("print")) {
                if (checkArrayList(data, Integer.parseInt(afterSplit[1])) && data.get(Integer.parseInt(afterSplit[1])) != null) {
                    System.out.println(String.format("Значение в ячейке: %s", data.get(Integer.parseInt(afterSplit[1]))));
                } else {
                    System.out.println("Запись не существует!");
                }
            } else {
                if (checkArrayList(data, Integer.parseInt(afterSplit[1]))) {
                    data.set(Integer.parseInt(afterSplit[1]), afterSplit[0]);
                } else {
                    extArrayList(data, Integer.parseInt(afterSplit[1]));
                    data.set(Integer.parseInt(afterSplit[1]), afterSplit[0]);
                }
            }
        }

    }

    static void printMenu(){
        System.out.println("МЕНЮ:");
        System.out.println("\t1. Если вы хотите добавить информацию, введите строку и число, разделенные тильдой. Пример: Дом~1)");
        System.out.println("\t2. Если хотите выйти, введите exit");
        System.out.println("\t3. Если хотите посмотреть значение в ячеке, ведите print и номер ячейки через тильду. Пример: print~3");
        System.out.println("\t4. Хотите посмотреть это меню, введите menu.");
    }

    static void extArrayList(ArrayList<String> list, int index){
        int i = list.size();
        while (i < index+1) {
            if(!checkArrayList(list, i)) {
                list.add(null);
            }
            i++;
        }
    }

    static boolean checkArrayList(ArrayList<String> list, int index){
        try{
            list.get(index);
        } catch (IndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
}
