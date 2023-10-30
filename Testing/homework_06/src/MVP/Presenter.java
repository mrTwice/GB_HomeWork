package MVP;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(){
        this.model = new Model();
        this.view = new View();
    }

    public void compareLists(){
        if(model.getActions().AverageMean(model.getListsVault().getFirstList()) > model.getActions().AverageMean(model.getListsVault().getSecondList())) {
            System.out.println("Первый список имеет большее среднее значение");
        } else if(model.getActions().AverageMean(model.getListsVault().getFirstList()) < model.getActions().AverageMean(model.getListsVault().getSecondList())) {
            System.out.println("Второй список имеет большее среднее значение");
        } else System.out.println("Средние значения равны");
    }

    public void start(){
        view.message();
        boolean exit = false;
        while (!exit){
            if(!view.menu()) {
                exit = true;
            }
            System.out.print("Введите первый список. ");
            model.getListsVault().setFirstList(view.inputList());
            System.out.print("Введите второй список. ");
            model.getListsVault().setSecondList(view.inputList());
            compareLists();
        }
    }

}
