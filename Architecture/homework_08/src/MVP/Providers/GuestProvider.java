package MVP.Providers;

import MVP.Base.Guest;
import MVP.Repository.GuestRepository;

import java.util.List;

public class GuestProvider {
    private GuestRepository guestRepository;

    public GuestProvider() {
        this.guestRepository = GuestRepository.getGuestRepository();
    }

    public List<Guest> getGuests(){
        return guestRepository.getAllGuests();
    }

    public Guest getGuestByPhoneNumber(String phoneNumber){
        Guest guest = null;
        for (Guest guestInList: getGuests()) {
            if(guestInList.getPhoneNumber().equalsIgnoreCase(phoneNumber))
                guest = guestInList;
        }
        return guest;
    }

    public boolean checkGuestByPhone(String phoneNumber){
        for (Guest guestInList: getGuests()) {
            if(guestInList.getPhoneNumber().equalsIgnoreCase(phoneNumber))
                return true;
        }
        return false;
    }

    public boolean checkGuestByName(String name){
        for (Guest guestInList: getGuests()) {
            if(guestInList.getName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }
    public Guest addGuest(String name, String phoneNumber){
        Guest newGuest = new Guest(name, phoneNumber);
        guestRepository.addNewGuest(newGuest);
        return newGuest;
    }


}
