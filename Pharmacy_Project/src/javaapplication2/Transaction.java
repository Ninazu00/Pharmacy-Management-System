package javaapplication2;

public class Transaction {
    private String transactionId;
    private float amount;
    private String paymentMethod;
    private int transactionDate; 
    private String status;
    private Order order;


    public Transaction(String transactionId, float amount, String paymentMethod, 
                      int transactionDate, String status, Order order) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionDate = transactionDate;
        this.status = status;
        this.order = order;
    }

     public float getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public Order getOrder() {
        return order;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getTransactionStatus() {
        return status;
    }

    private boolean isValidStatus(String status) {
        return this.status.equals(status);
    }
    
    public void setTransactionStatus(String newStatus) {
        if (isValidStatus(newStatus)) {
            this.status = newStatus;
        } else {
            System.out.println("Invalid status: " + newStatus);
        }
    }


    public void updatePaymentMethod(String newMethod) {
        if (newMethod != null && !newMethod.trim().isEmpty()) {
            this.paymentMethod = newMethod;
        } else {
            System.out.println("Payment method cannot be empty");
        }
    }


    public void cancelTransaction() {
        if (this.status.equals("Pending")) {
            this.status = "Cancelled";
            System.out.println("Transaction cancelled successfully");
        } else {
            System.out.println("Cannot cancel transaction in status: " + status);
        }
    }


    public String getTransactionDetails() {
        return "Transaction ID: " + transactionId + ", Amount: " + amount + 
               ", Payment Method: " + paymentMethod + ", Date: " + transactionDate + 
               ", Status: " + status + ", Order ID: " + (order != null ? order.getOrderID() : "N/A");
    }
}
