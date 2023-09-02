package Application;

import Interfaces.IBuyer;
import Services.BuyersRepository;

public class BuyersProvider {
    private IBuyer buyersRepository;

    public BuyersProvider(){
        this.buyersRepository = BuyersRepository.getBuyersRepository();
    }
}
