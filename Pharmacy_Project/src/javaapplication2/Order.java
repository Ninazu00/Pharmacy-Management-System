package javaapplication2;

public class Order {
    private static int orderCount = 0;
    private int orderID;
    private Medicine medicine;
    private int quantity;
    private double price;
    private boolean delivered;

  
    public Order(Medicine medicine, int quantity) {
        this.medicine = medicine;
        this.quantity = quantity;
        this.price = this.medicine.getPrice() * quantity;
        this.delivered = false;
        orderID = orderCount;
        Order.orderCount++;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public int getOrderID() {
        return orderID;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
    
   
    public void updateOrder(int orderID, int quantity) {
            this.quantity = quantity;
            this.price = this.medicine.getPrice() * quantity;
    }
    
}