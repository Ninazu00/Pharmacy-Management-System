package javaapplication2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javaapplication2.Order;

public class OrderController {
    private static final String ORDERS_FILE = "orders.txt";
    private List<Order> orders;

    public OrderController() {
        
        this.orders = new ArrayList<>();
        loadOrdersFromFile(); 
     
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void createOrder(int orderID, Medicine medicine, int quantity, double price) {
        for (Order order : orders) {
            if (order.getOrderID() == orderID) {
                System.out.println("Order ID already exists!");
                return;
            }
        }
        orders.add(new Order(medicine, quantity));
        saveOrdersToFile(); 
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
                double newTotalPrice = newQuantity * unitPrice;
                order.setPrice(newTotalPrice);
                saveOrdersToFile(); 
                System.out.println("Order updated successfully.");
                return;
            }
        }
        System.out.println("Order not found.");
    }

    public void cancelOrder(String orderID) {
        for (Order order : orders) {
            if (Integer.toString(order.getOrderID()).equals(orderID)) {
                orders.remove(order);
                saveOrdersToFile(); 
                System.out.println("Order cancelled successfully.");
                return;
            }
        }
        System.out.println("Order not found.");
    }

    
       // Save orders to file
    private void saveOrdersToFile() {
        try (FileOutputStream f = new FileOutputStream(ORDERS_FILE);
             ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(orders);
            o.close();
        } catch (IOException e) {
            System.out.println("Error opening file while writing.");
        }
    }
    
   
    
    
    // Load orders from file
    @SuppressWarnings("unchecked")
    private void loadOrdersFromFile() {
        try (FileInputStream f = new FileInputStream(ORDERS_FILE);
             ObjectInputStream o = new ObjectInputStream(f)) {
            Object temp = o.readObject();
            orders = (ArrayList<Order>)temp;
            o.close();
            f.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error opening file while reading");
            orders = new ArrayList<>(); 
        }
    }
}