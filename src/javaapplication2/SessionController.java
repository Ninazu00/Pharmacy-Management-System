package javaapplication2;

public class SessionController {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }
    
    public static boolean loginUser(String email, String password, String userType) {
        if(userType.equals("Client"))
        {
            //Runs through the list of Clients to compare the login data to login data in the database of credentials
           for (Client client : Client.getClients()) {
            if (client.getEmail().equals(email) && client.getPassword().equals(password)) {
                currentUser = client;
                return true;
            }
           }
        }
        if(userType.equals("Doctor"))
        {
            //Runs through the list of Doctors to compare the login data to login data in the database of credentials
           for (Doctor doctor : Doctor.getDoctors()) {
            if (doctor.getEmail().equals(email) && doctor.getPassword().equals(password)) {
                currentUser = doctor;
                return true;
            }
           }
        }
        if(userType.equals("Admin"))
        {
            //Runs through the list of admins to compare the login data to login data in the database of credentials
           for (Admin admin : Admin.getAdmins()) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                currentUser = admin;
                return true;
            }
           }
        }

        return false;
    }
    // Method to sign up a new client and add them to the system
    public static boolean signUpClient(String id, String name, String username, String email, String phone, String password, String address) {
        Client newClient = new Client(id,name,username,email,phone,password,address);
        Client.addClient(newClient);
        return true;
    }
    // Method to log out the current     
    public static void logoutUser() {
        currentUser = null;

    }
}