package genealogy.control;

public class View {
    public static void printMenu(){
        System.out.println("Меню:");
        System.out.println("\t\t1. Добавить человека");
        System.out.println("\t\t2. Добавить информацию о муже/жене");
        System.out.println("\t\t3. Добавить информацию о детях");
        System.out.println("\t\t4. Список родственников");
        System.out.println("\t\t5. Список поколений");
        System.out.println("\t\t6. Выход");
        System.out.print("Ввод: ");
    }

    public static void printSubMenuGender(){
        System.out.println("Меню:");
        System.out.println("\t\t1. Мужчина");
        System.out.println("\t\t2. Женщина");
        System.out.print("Ввод: ");
    }
}
