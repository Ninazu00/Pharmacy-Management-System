package javaapplication2;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private List<Order> orders;

    public OrderController() {
        this.orders = new ArrayList<>();
    }
    public void createOrder(int orderID, Medicine medicine, int quantity, double price) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                System.out.println("Order ID already exists!");
                return;
            }
        }
        orders.add(new Order( medicine, quantity));
        System.out.println("Order created successfully.");
    }
   public void updateOrder(String orderID, int newQuantity, double unitPrice) {
    if (orderID == null) {
        System.out.println("Order ID cannot be null.");
        return;
    }

    for (Order order : orders) {
        if (orderID.equals(order.getOrderID())) {
            order.setQuantity(newQuantity);
            double newTotalPrice = newQuantity * unitPrice;  // Automatically update price
            order.setPrice(newTotalPrice);
            System.out.println("Order updated successfully.");
            return;
        }
    }
    System.out.println("Order not found.");
    }
}
