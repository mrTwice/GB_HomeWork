package App.Core;

import App.MVP.Model;
import App.MVP.Presenter;
import App.MVP.View;

public class MainPresenter implements Presenter {
    private View consoleView;
    private Model market;

    public MainPresenter(){
        this.consoleView = new ConsoleView();
        this.market = new Market();
    }

    @Override
    public void runEntryMenuLogic() {
        boolean run = true;
        int choise = consoleView.EntryMenu(); // return int choise 1 (login), 2 (registration) or 3 (exit)
        while (run){
            switch (choise){
                case 1:
                    System.out.println("login");
                    run = login();
                    break;
                case 2:
                    System.out.println("registration");
                    run = registration();
                    break;
                case 3:
                    run = false;
            }

        }
    }

    @Override
    public boolean login() {
        return false;
    }

    @Override
    public boolean registration() {
        return false;
    }
}
