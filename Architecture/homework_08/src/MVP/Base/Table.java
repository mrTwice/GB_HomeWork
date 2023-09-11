package MVP.Base;

import java.util.Date;

public class Table {
    private static int id =0;
    private int idHall;
    private int seats;
    private boolean isBusy;
    private Guest guest;
    private Date reserveDate;

    public Table(int idHall, int seats) {
        this.idHall = idHall;
        this.seats = seats;
    }

    public int getIdHall() {
        return idHall;
    }

    public int getSeats() {
        return seats;
    }

    public static int getId(){
        return id;
    }

    public boolean getTableStatus(){
        return isBusy;
    }

    public void setTableStatusIsBusy(){
        this.isBusy = true;
    }

    public void setTableStatusIsFree(){
        this.isBusy = false;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }
}
