package Application.DataBaseInterfaces;

import Application.Logic.Primitives.Order;

import java.util.List;

public interface IOrderRepo {
    List<Order> getAllOrders();
    Order getOrderByID(int id);
}
