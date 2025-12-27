package javaapplication2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Mohamed
 */
public class Message {
    private int messageID;
    private String content;
    private String date;
    private String time;
    private String senderID;
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSenderID() {
        return senderID;
    }

    public String setSenderID(String senderID) {
        return this.senderID = senderID;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public Message(String content, String senderID, int mID) {
        this.messageID = mID;
        this.content = content;
        this.senderID = senderID;
        date = LocalDate.now().toString(); //Saves message date
        time = LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString(); //Saves message time
    }

    @Override
    public String toString() {
        return "Message{" + "messageID=" + messageID + ", content=" + content + ", date=" + date + ", time=" + time + ", senderID=" + senderID + '}';
    }
}