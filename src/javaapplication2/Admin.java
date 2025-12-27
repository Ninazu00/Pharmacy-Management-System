package javaapplication2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends User implements Serializable{
    private static ArrayList<Admin> admins = new ArrayList<>(); // an ArrayList to store admins objects

    public Admin(String id, String name, String username, String email, String phone, String password) 
    { // admin constractor
        super(id, name, username, email, phone, password); // inherits from User
    }

    //Setters
    public static void setAdmins(ArrayList<Admin> admins) 
    {  
        Admin.admins = admins;
        saveAdminsToFile();
    }
    
    //Getters
    public static ArrayList<Admin> getAdmins() 
    {
        instantiateFromFile();
        return admins;
    }
    
    // this method is used to add an admin object in the admins ArrayList, and calls saveAdminsToFile() method for file handeling
    public static boolean addAdmin(Admin admin) 
    {
        boolean result = admins.add(admin);
        saveAdminsToFile();
        return result;
    }

    // this method is used to remove an admin object in the admins ArrayList, and calls saveAdminsToFile() method for file handeling
    public static boolean removeAdmin(Admin admin) 
    {
        boolean result = admins.remove(admin);
        saveAdminsToFile();
        return result;
    }
    
    public static void addMedicine(Medicine medicine) 
    {
        Medicine.addMedicine(medicine);
    }

    public static boolean removeMedicine(int medicineId) 
    {
        return Medicine.removeMedicine(medicineId);
    }

    public static boolean updateMedicineDetails(int medicineId, Medicine updatedMedicine) 
    {
        return Medicine.updateMedicine(medicineId, updatedMedicine);
    }

    public static void generateReports() 
    {
        Medicine.generateInventoryReport();
    }
    
    public static boolean adminCheck(String Username, String password)
    {
       for (Admin a: admins)
       {
           if (a.getUsername().equals(Username) && a.getPassword().equals(password))
           {
               return true;
           }
       }
       return false;
   }
      
    // File handling methods
    public static void saveAdminsToFile() 
    {
        try (FileOutputStream f = new FileOutputStream("Admins.txt");
        ObjectOutputStream o = new ObjectOutputStream(f)) 
        {
            o.writeObject(admins);
            o.close();
        }
        catch (IOException e) 
        {
            System.out.println("Error opening file while writing.");
        }
    }

    //Instantiates the ArrayList containing all admins from the file
    public static void instantiateFromFile() 
    {
        try (FileInputStream f = new FileInputStream("Admins.txt");
        ObjectInputStream o = new ObjectInputStream(f)) 
        {
            Object temp = o.readObject();
            admins = (ArrayList<Admin>)temp;
            o.close();
            f.close();
        } catch (IOException | ClassNotFoundException e) 
        {
            System.out.println("Error opening file while reading");
        }
    } 
}