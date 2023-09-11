package MVP;


import MVP.Base.*;
import java.text.ParseException;
import java.util.List;

public class Presenter {
    private ConsoleView consoleView;
    private Model model;

    public Presenter(){
        this.model = new Model();
        this.consoleView = new ConsoleView(this);
    }

    public void launchApp() throws ParseException {
        consoleView.showStartScreen();
        consoleView.showHallsSelectionScreen();
        consoleView.showTableSelectionScreen(consoleView.getIdHall());
        model.getOrderProvider().createOrder(model.getGuest(), consoleView.getVisitDate(), consoleView.getIdHall(), consoleView.getIdTable());
    }

    public Guest createNewGests(String name, String phoneNumber){
        Guest guest = model.getGuestProvider().addGuest(name, phoneNumber);
        return guest;
    }

    public void setGest(Guest guest){
        model.setGuest(guest);
    }

    public List<Hall> loadHalls(){
        List<Hall> hallsList = model.getHallsProvider().getHalls();
        return hallsList;
    }
    public List<Table> loadsTableByIdHall(int id){
        List<Table> tableList = model.getTableProvider().getTablesByHallID(id);
        return tableList;
    }

}
