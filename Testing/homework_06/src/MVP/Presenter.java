package MVP;

import Base.InputOutput;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(){
        this.model = new Model();
        this.view = new View(new InputOutput());
    }

    public String compareLists(){
        if(model.getActions().AverageMean(model.getListsVault().getFirstList()) > model.getActions().AverageMean(model.getListsVault().getSecondList())) {
            return "Первый список имеет большее среднее значение";
        } else if(model.getActions().AverageMean(model.getListsVault().getFirstList()) < model.getActions().AverageMean(model.getListsVault().getSecondList())) {
            return "Второй список имеет большее среднее значение";
        } else return "Средние значения равны";
    }

    public void start(){
        System.out.println("\n"+"Это консольное приложение, которое вычисляет среднее арифметическое двух списков\n" +
                "и сравнивает полученные значения, по окончании которого выводи сообщение о том, у какого\n" +
                "списка среднее арифметическое больше\n");
        boolean exit = false;
        while (!exit){
            if(!view.menu())
                exit = true;
            System.out.print("Введите первый список. ");
            model.getListsVault().setFirstList(view.inputList());
            System.out.print("Введите второй список. ");
            model.getListsVault().setSecondList(view.inputList());
            compareLists();
        }
    }

    public Model getModel() {
        return model;
    }
}
