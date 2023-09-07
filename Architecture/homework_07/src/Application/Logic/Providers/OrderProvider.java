package Application.Logic.Providers;

import Domain.OrderRepository;

public class OrderProvider {
    private OrderRepository orderReposytory;

    public OrderProvider(){
        this.orderReposytory = OrderRepository.getOrderRepository();
    }
}
