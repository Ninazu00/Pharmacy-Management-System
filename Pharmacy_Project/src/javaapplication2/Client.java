package javaapplication2;
import java.util.ArrayList;

public class Client extends User {
    private String address;
    private static ArrayList<Client> clients = new ArrayList<>();

    public Client(String id, String name, String username, String email, String phone, String password, String address) {
        super(id,name,username,email,phone,password); 
        this.address=address;
        clients.add(this);
    }

    public void manageAccount() {
        System.out.println("Client account management in progress...");
    }


    public void getClientDetails() {
        System.out.println("Name :" + getName());
        System.out.println("Address :" + getAddress());
        System.out.println("E-mail :" + getEmail());   
        System.out.println("Phone :" + getPhone()); 
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public static ArrayList<Client> getClients() {
        return clients;
    }
     
    public static void addClient(Client temp) {
        Client.clients.add(temp);
    }

    public void deleteClient(Client client) {                      
        System.out.println("Deleting client : " + client);
        clients.remove(client);
    }
}