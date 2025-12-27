package javaapplication2;

/**
 *
 * @author IForg
 */
public class Order {
    private static int orderID = 0;
    private Medicine medicine;
    private int quantity;
    private double price;
    private boolean delivered;

  
    public Order(Medicine medicine, int quantity) {
        this.medicine = medicine;
        this.quantity = quantity;
        this.price = this.medicine.getPrice() * quantity;
        this.delivered = false;
        this.orderID++;
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
    
    public void updateOrder(int quantity) {
            this.quantity = quantity;
            this.price = this.medicine.getPrice() * quantity;
    }
    
    public boolean discountOrder (double discount)
    {
        if (discount > 100 || discount < 1)
        {
            return false;
        }
        else if(discount == 0)
        {
            return true;
        }
        else 
        {
            discount = discount / 100;
            this.price = this.price - (discount * this.price);
            return true;
        }
    }
}