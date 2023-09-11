package MVP.Providers;

import Base.Guest;
import Base.Order;
import MVP.Repository.OrderRepository;

import java.util.Date;

public class OrderProvider {
    private OrderRepository orderRepository;

    public OrderProvider(){
        this.orderRepository = OrderRepository.getOrderRepository();
    }

    public void createOrder(Guest guest, Date visitDate, int idHall, int idTable){
        orderRepository.addNewOrder(new Order(guest.getId(), visitDate, idHall, idTable));
    }
}
