package Services;

import DataBase.DataBase;
import Interfaces.IBuyer;
import Models.User;

import java.util.List;

public class BuyersRepository implements IBuyer {
    private static BuyersRepository buyersRepository;
    private List<User> buyers;

    private BuyersRepository() {
        this.buyers = DataBase.getBuyers();
    }

    public static BuyersRepository getBuyersRepository(){
        if(buyersRepository == null){
            BuyersRepository buyersRepository = new BuyersRepository();
        }
        return buyersRepository;
    }

    @Override
    public List<User> getBuyersList() {
        return buyers;
    }

    @Override
    public User getBuyerById(int id) {
        User findingBuyer = null;
        for (User u: this.buyers) {
            if(u.getId() == id){
                findingBuyer = u;
            } else throw new RuntimeException("Пользователь не зарегистрирован");
        }
        return findingBuyer;
    }
}
