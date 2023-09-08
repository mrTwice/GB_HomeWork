package Application.Logic.Primitives.ReportsType;

import Application.Logic.Primitives.Order;

import java.util.LinkedList;
import java.util.List;

public class Table extends Report{
    private List<Order> orders;

    public Table() {
        this.orders = new LinkedList<>();
    }

    public void addNewOrder(Order order){
        this.orders.add(order);
    }
}
