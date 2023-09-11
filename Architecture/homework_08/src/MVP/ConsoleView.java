package MVP;

import MVP.Base.Hall;
import MVP.Base.Table;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleView {
    private String name;
    private String phoneNumber;
    private Date visitDate;
    private int guestCount;
    private int idHall;
    private int idTable;

    private Presenter presenter;

    public ConsoleView(Presenter presenter){
        this.presenter = presenter;
    }

    public int getIdHall() {
        return idHall;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public int getIdTable() {
        return idTable;
    }

    protected void showStartScreen() throws ParseException {
        this.name = fillTextFild();
        this.phoneNumber = fillTextFild();
        presenter.setGest(presenter.createNewGests(this.name, this.phoneNumber));
        this.visitDate = convertStrindDateToDate(fillTextFild());
        this.guestCount = convertStringToInt(fillTextFild());

    }

    protected void showHallsSelectionScreen(){
        for (Hall hall: presenter.loadHalls()) {
            System.out.println(hall.getId());
        }
        this.idHall = convertStringToInt(fillTextFild());
    }

    protected void showTableSelectionScreen(int idHall){
        for (Table table: presenter.loadsTableByIdHall(idHall)) {
            System.out.println(table.getId());
            System.out.println(table.getSeats());
        }
        this.idTable = convertStringToInt(fillTextFild());
    }

    private String fillTextFild(){
        Scanner consoleInput = new Scanner(System.in);
        String textField = consoleInput.nextLine();
        consoleInput.close();
        return textField;
    }

    private int convertStringToInt(String number){
        int count = Integer.parseInt(number);
        return count;
    }

    private Date convertStrindDateToDate( String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String dateInString = date;
        Date correctDate = formatter.parse(dateInString);
        return correctDate;
    }

}
