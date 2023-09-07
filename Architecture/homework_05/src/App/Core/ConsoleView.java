package App.Core;

import App.MVP.View;

import java.util.Scanner;

public class ConsoleView extends EntryData implements View {
    private Scanner consoleInput;

    @Override
    public int MainMenu() {
        consoleInput = new Scanner(System.in);
        int choice =0;
        printMainMenu();
        choice = consoleInput.nextInt();
        consoleInput.close();
        return choice;
    }

    private void printMainMenu() {
        System.out.println("=========================MENU========================");
        System.out.println("1. Показвать список товаров");
        System.out.println("2. Показать список товаров в корзине");
        System.out.println("3. Добавить товар в корзину");
        System.out.println("4. Оплатить товары");
        System.out.println("5. Выход");
        System.out.println("=====================================================");
    }

    @Override
    public int EntryMenu() {
        consoleInput = new Scanner(System.in);
        int choice =0;
        printEntryMenu();
        choice = consoleInput.nextInt();
        consoleInput.close();
        return choice;
    }

    private void printEntryMenu(){
        System.out.println("=========================MENU========================");
        System.out.println("1. Вход");
        System.out.println("2. Регистрация");
        System.out.println("3. Выход");
        System.out.println("=====================================================");
        System.out.println();
        System.out.print("Выберете пункт меню: ");
    }

}
