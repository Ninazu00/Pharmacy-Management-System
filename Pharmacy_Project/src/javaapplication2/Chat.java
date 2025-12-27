package javaapplication2;

import java.util.ArrayList;

public class Chat {
    private static ArrayList<Chat> chats = new ArrayList<>();
    private int messageCount; 
    private String clientID;
    private String doctorID;
    private ArrayList<Message> messages;
    public Chat(String doctorID) {
        if((!(SessionController.getCurrentUser() instanceof Client))||(!(SessionController.getCurrentUser() instanceof Doctor)))
            return;
        this.messageCount = 0;
        this.clientID = SessionController.getCurrentUser().getId();
        this.doctorID = doctorID;
        this.messages = new ArrayList<>();
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

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
    
    public void sendMessage(String mContent){
        if((!(SessionController.getCurrentUser() instanceof Client))||(!(SessionController.getCurrentUser() instanceof Doctor)))
            return;
        if(messageCount == 0)
        {
            Chat.chats.add(this);
        }
        messageCount++;
        Message temp = new Message(mContent, SessionController.getCurrentUser().getId(),messageCount);
        this.messages.add(temp);
    }
    
    public void deleteMessage(int ID){
        if((!(SessionController.getCurrentUser() instanceof Client))||(!(SessionController.getCurrentUser() instanceof Doctor)))
            return;
        messages.removeIf(message->message.getMessageID() == ID);
    }
    
    public static void deleteChat(String cID, String dID) {
        if((!(SessionController.getCurrentUser() instanceof Client))||(!(SessionController.getCurrentUser() instanceof Doctor)))
            return;
        if(SessionController.getCurrentUser().getId().equals(cID)) //checks if the current user is the doctor or client to use the respective remove if condition
        {
            chats.removeIf(chat -> chat.getClientID().equals(cID));
        }
        else if(SessionController.getCurrentUser().getId().equals(dID))
        {
            chats.removeIf(chat -> chat.getDoctorID().equals(dID));
        }
    }

    @Override
    public String toString() {
        return "Chat{" + "messageCount=" + messageCount + ", clientID=" + clientID + ", doctorID=" + doctorID + ", messages=" + messages + '}';
    }
    
}