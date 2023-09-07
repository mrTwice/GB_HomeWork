package Application.DataBaseInterfaces;

import Application.Models.Primitives.Order;

import java.util.List;

public interface IOrderRepo {
    List<Order> getAllOrders();
    Order getOrderByID(int id);
}
