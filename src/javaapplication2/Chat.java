package javaapplication2;

import java.io.*;
import java.util.ArrayList;

public class Chat implements Serializable {
    private static ArrayList<Chat> chats = new ArrayList<>();
    private int messageCount; 
    private String clientID;
    private String doctorID;
    private ArrayList<Message> messages;
    public Chat(String doctorID) {
        if((!(SessionController.getCurrentUser() instanceof Client))) //Function does NOT execute if the current user is not a Client since you cannot start a chat unless you are a Client
            return;
        this.messageCount = 0;
        this.clientID = SessionController.getCurrentUser().getId();
        this.doctorID = doctorID;
        this.messages = new ArrayList<>();
        chats.add(this);
        saveIntoFile();
    }
    
    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
    
    //Saves the ArrayList containing all chats from the file
    public static void saveIntoFile(){
        try (FileOutputStream f = new FileOutputStream("Chats.txt");
        ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(chats);
            o.close();
        } catch (IOException e) {
            System.out.println("Error opening file while writing.");
        }
    }
    
    //Instantiates the ArrayList containing all chats from the file
    public static void instantiateFromFile(){
        try (FileInputStream f = new FileInputStream("Chats.txt");
        ObjectInputStream o = new ObjectInputStream(f)) {
            Object temp = o.readObject();
            chats = (ArrayList<Chat>)temp;
            o.close();
            f.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error opening file while reading");
        }
    }

    public static void setChats(ArrayList<Chat> chats) {
        Chat.chats = chats;
        saveIntoFile();
    }

    public static ArrayList<Chat> getChats() {
        instantiateFromFile();
        return chats;
    }
    
    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
        saveIntoFile();
    }
    
    //Sends a message in the current chat. The message sender automatically is the currently logged in user.
    public void sendMessage(String mContent){
        if((!(SessionController.getCurrentUser() instanceof Client))&&(!(SessionController.getCurrentUser() instanceof Doctor))) //Function does NOT execute if the current user is not a Doctor or Client
            return;
        messageCount++;
        Message temp = new Message(mContent, SessionController.getCurrentUser().getId(),messageCount);
        this.messages.add(temp);
        saveIntoFile();
    }
    
    //Deletes a message based on it's ID
    public void deleteMessage(int ID){
        if((!(SessionController.getCurrentUser() instanceof Client))&&(!(SessionController.getCurrentUser() instanceof Doctor))) //Function does NOT execute if the current user is not a Doctor or Client
            return;
        messages.removeIf(message->message.getMessageID() == ID);
        saveIntoFile();
    }
    
    //Deletes a chat
    public static void deleteChat(Chat a) {
        if((!(SessionController.getCurrentUser() instanceof Client))&&(!(SessionController.getCurrentUser() instanceof Doctor))) //Function does NOT execute if the current user is not a Doctor or Client
            return;
        chats.remove(a);
        saveIntoFile();
        a = null;
    }
    
    //Returns all the Chats which user is a participant in
    public static ArrayList<Chat> getUserChats(){
        instantiateFromFile();
        ArrayList<Chat> currUserChats = new ArrayList<>();
        if((!(SessionController.getCurrentUser() instanceof Client))&&(!(SessionController.getCurrentUser() instanceof Doctor))) //Function does NOT execute if the current user is not a Doctor or Client
            return currUserChats;
        for(Chat a: chats){
            if((SessionController.getCurrentUser().getId().equals(a.getDoctorID()))||(SessionController.getCurrentUser().getId().equals(a.getClientID()))) //Checks if the User is a participant in the chat
            {
                currUserChats.add(a);
            }
        }
        return currUserChats;
    }

    @Override
    public String toString() {
        return "Chat{" + "messageCount=" + messageCount + ", clientID=" + clientID + ", doctorID=" + doctorID + ", messages=" + messages + '}';
    }
}