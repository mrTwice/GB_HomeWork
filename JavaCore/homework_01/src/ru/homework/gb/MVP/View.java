package ru.homework.gb.MVP;

import ru.homework.gb.Base.Validation;

import java.util.Scanner;

public class View extends Validation {

    private Scanner consoleInput;

    public View(){
        consoleInput = new Scanner(System.in);
    }

    public int menu(){
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("5. Результаты последних вычислений");
        System.out.print("Выберете пункт: ");
        String menuPoint = consoleInput.next();
        int choise =0;
        if(checkInt(menuPoint))
            choise = Integer.parseInt(menuPoint);
        return choise;
    }

    public double getDoubleNumber(String str){
        System.out.print("Введите " + str + " число: ");
        String number = consoleInput.next();
        double result = result = Double.parseDouble(number);
        return result;
    }
}
