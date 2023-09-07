package Domain;

import Application.DataBaseInterfaces.IOrderRepo;
import Application.Models.Primitives.Order;

import java.util.List;

public class OrderRepository implements IOrderRepo {
    private static OrderRepository orderReposytory;
    private List<Order> orders;

    private OrderRepository(){orderReposytory = getOrderRepository();}

    public static OrderRepository getOrderRepository(){
        if(orderReposytory == null){
            orderReposytory = new OrderRepository();
        }
        return orderReposytory;
    }
@Override
    public List<Order> getAllOrders(){
        return null;
    }

    public Order getOrderByID(int id){
        return null;
    }

}
