package javaapplication2;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author IForg
 */
public class Client extends User {
    private String address;
    private static ArrayList<Client> clients = new ArrayList<>();
    private static File clientsAL = new File("clients.txt");

    public Client(String id, String name, String username, String email, String phone, String password, String address) {
        super(id, name, username, email, phone, password);
        this.address = address;
    }
    
    public String getClientDetails() {
        return (getName()+ " " + getEmail()+ " " + getPhone()+ " " + getAddress()+ " ");
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
     public static void addClient(Client a){
         try(FileWriter clientsALw = new FileWriter("clients.txt")){
         clientsALw.write(a.getId());
         Client.clients.add(a);
         } catch (Exception ex) {
            return;
        }
     }

    public void deleteClient(Client client) {                      
        System.out.println("Deleting client : " + client);
        clients.remove(client);
    }
    public boolean changePassword(String oldPassword, String newPassword, String reEnter)
    {
        if (getPassword().equals(oldPassword))
        {
            if (oldPassword.equals(newPassword))
            {
                return false;
            }
            else if(!newPassword.equals(reEnter))
                    {
                        return false;
                    }
            else 
            {
                setPassword(newPassword);
                return true;
            }
        }
        return false;   
    }
    
   public static boolean clientCheck(String Username, String password){
       
       for (Client c: clients)
       {
           if (c.getUsername().equals(Username) && c.getPassword().equals(password))
           {
               return true;
           }
       }
       return false;
   }

    @Override
    public String toString() {
        return "Client{" + "address=" + address + '}';
    }
   
}