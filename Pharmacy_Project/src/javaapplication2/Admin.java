package javaapplication2;
import java.util.ArrayList;

public class Admin extends User{
    private static ArrayList<Admin> admins = new ArrayList<>(); 

    public Admin(String id, String name, String username, String email, String phone, String password) {
        super(id, name, username, email, phone, password);
    }

    public static void setAdmins(ArrayList<Admin> admins) {
        Admin.admins = admins;
    }

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    public static boolean addAdmin(Admin admin) {
        return admins.add(admin);
    }

    public boolean removeAdmin(Admin admin) {
        return admins.remove(admin);
    }
}
