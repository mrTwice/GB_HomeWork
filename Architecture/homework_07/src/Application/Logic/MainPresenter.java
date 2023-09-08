package Application.Logic;

import Application.Logic.Presenters.Presenter;
import Application.Logic.Primitives.ReportsType.Report;
import Application.ModelInterfaces.Model;

import java.util.HashMap;

public class MainPresenter implements Presenter {
    private static MainView mainView;
    private MainLogic mainLogic;

    public MainPresenter() {
        this.mainView = new MainView();
        this.mainLogic = new MainLogic();
    }

    private boolean loginUser(HashMap<String, String> userData){
        if(mainLogic.checkUser(userData))
            return true;
        return false;
    }

    public void createReport(){
        if(loginUser(mainView.autorizationMenu())) {
            Report report = null;
            int choice = mainView.selectTypeReport();
            if (choice == 1) {
                report = MainLogic.createTable(getDataForReports());
                mainView.drawTable(report);
            }
            if (choice == 2) {
                report = MainLogic.createGraph(getDataForReports());
                mainView.drawGraph(report);
            }
        }

    }

    private  String getDataForReports(){
       String fields = mainView.fillReportsFields();
        return fields;
    }

}
