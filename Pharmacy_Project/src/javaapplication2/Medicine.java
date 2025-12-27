package javaapplication2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Medicine {
    private int id;
    private String name;
    private String batchNo;
    private double price;
    private int quantity;
    private Date expiryDate;
    
     private static List<Medicine> Medicines = new ArrayList<>();
     
      public Medicine(int id, String name, String batchNo, double price, int quantity, Date expiryDate) {
        this.id = id;
        this.name = name;
        this.batchNo = batchNo;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }
      
    public int getId() { return id; }
    public String getName() { return name; }
    public String getBatchNo() { return batchNo; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Date getExpiryDate() { return expiryDate; }
    public void setName(String name) { this.name = name; }
    public void setBatchNo(String batchNo) { this.batchNo = batchNo; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
    
     @Override
    public String toString() {
        return "Medicine ID: " + id + 
               "\nName: " + name + 
               "\nBatch: " + batchNo + 
               "\nPrice: $" + price + 
               "\nQuantity: " + quantity + 
               "\nExpiry: " + expiryDate +
               "\n---------------------";
    }
    
     public static void addMedicine(Medicine medicine) {
        if (medicine == null) {
            throw new IllegalArgumentException("Medicine cannot be null");
        }
        if (Medicines.contains(medicine)) {
            throw new IllegalStateException("Medicine with ID " + medicine.getId() + " already exists");
        }
        Medicines.add(medicine);
    }
     
      public static boolean removeMedicine(int medicineId) {
        Medicine medicineToRemove = findMedicineById(medicineId);
        if (medicineToRemove != null) {
            Medicines.remove(medicineToRemove);
            return true;
        }
        return false;
    }
      
       public static boolean updateMedicine(int medicineId, Medicine updatedMedicine) {
        Medicine existingMedicine = findMedicineById(medicineId);
        if (existingMedicine != null) {
            existingMedicine.setName(updatedMedicine.getName());
            existingMedicine.setBatchNo(updatedMedicine.getBatchNo());
            existingMedicine.setPrice(updatedMedicine.getPrice());
            existingMedicine.setQuantity(updatedMedicine.getQuantity());
            existingMedicine.setExpiryDate(updatedMedicine.getExpiryDate());
            return true;
        }
        return false;
    }
       
    public static Medicine findMedicineById(int medicineId) {
    for (Medicine medicine : Medicines) {
        if (medicine.getId() == medicineId) {
            return medicine;
        }
    }
    return null;
    }
    
    public static List<Medicine> getAllMedicines() {
        return new ArrayList<>(Medicines);
    }
    
    public static int getTotalMedicineCount() {
        return Medicines.size();
    }
       
    public static double calculateTotalInventoryValue() {
        double total = 0;
        for (Medicine medicine : Medicines) {
            total += medicine.getPrice() * medicine.getQuantity();
        }
        return total;
    }
    
    public static double calculateRevenueForMedicine(int medicineId, double sellingPrice) {
        Medicine medicine = findMedicineById(medicineId);
        if (medicine != null) {
            return (sellingPrice - medicine.getPrice()) * medicine.getQuantity();
        }
        return 0;
    }
    
    public static void generateInventoryReport() {
      System.out.println("===== PHARMACY INVENTORY REPORT =====");
      System.out.println("Total Medicines: " + getTotalMedicineCount());
      System.out.printf("Total Inventory Value: $%.2f\n", calculateTotalInventoryValue());
      System.out.println("\nMedicine Details:");

      for (Medicine medicine : Medicines) {
          System.out.println(medicine); // Uses our overridden toString()
      }

    }
}