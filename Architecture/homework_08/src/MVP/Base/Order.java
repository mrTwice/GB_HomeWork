package MVP.Base;

import java.util.Date;

public class Order {
    private int id =0;
    private  int idGuest;
    private Date visitDate;
    private int idHall;
    private int idTable;
    private boolean confirmation = false;

    public Order(int idGuest, Date visitDate, int idHall, int idTable) {
        this.idGuest = idGuest;
        this.visitDate = visitDate;
        this.idHall = idHall;
        this.idTable = idTable;
    }

    public int getId(){
        return id;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public int getIdHall() {
        return idHall;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public int getIdTable() {
        return idTable;
    }
}
