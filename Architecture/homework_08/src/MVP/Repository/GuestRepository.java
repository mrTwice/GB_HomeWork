package MVP.Repository;

import MVP.Base.Guest;

import java.util.ArrayList;
import java.util.List;


public class GuestRepository {
    private static GuestRepository guestRepository;
    private List<Guest> guests;

    private GuestRepository(){
        this.guests = new ArrayList<>();
    }

    public static GuestRepository getGuestRepository(){
        if (guestRepository == null)
            guestRepository = new GuestRepository();
        return guestRepository;
    }

    public Guest getGuestByID(int id){
        Guest guestByID= null;
        for (Guest g: this.guests) {
            if(g.getId() == id)
                guestByID = g;
        }
        return guestByID;
    }

    public List<Guest> getAllGuests(){
        return this.guests;
    }

    public void addNewGuest(Guest guest){
        guests.add(guest);
    }
}
