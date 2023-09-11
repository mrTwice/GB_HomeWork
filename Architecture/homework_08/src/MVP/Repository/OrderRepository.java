package MVP.Repository;

import Base.Order;

import java.util.List;

public class OrderRepository {
    private static OrderRepository orderRepository;
    private List<Order> orders;

    private OrderRepository (){
        orderRepository = getOrderRepository();
    }

    public static OrderRepository getOrderRepository(){
        if(orderRepository == null)
            orderRepository = new OrderRepository();
        return orderRepository;
    }

    public List<Order> getAllOrders(){
        return orders;
    }

    public Order getOrderById(int idOrder){
        Order order = null;
        for (Order orderInList: orders) {
            if(orderInList.getId() == idOrder)
                order = orderInList;
        }
        return order;
    }

    public void addNewOrder(Order order){
        orders.add(order);
    }

}
