package javaapplication2;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;


public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

    // Private attributes to store appointment details
    private String appointmentID;
    private String clientID;
    private String doctorID;
    private String appointmentDate;
    private String status;

    public static ArrayList<Appointment> appointments = new ArrayList<>();

    
    // Constructor to initialize an appointment object
    public Appointment(String appointmentID, String clientID, String doctorID, String appointmentDate, String status) {
        this.appointmentID = appointmentID;
        this.clientID = clientID;
        this.doctorID = doctorID;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }
    // Method to book an appointment by changing status to "Booked"
    public void bookAppointment() {
        status = "Booked";
    }
    // Method to cancel an appointment by changing status to "Cancelled"
    public void cancelAppointment() {
        status = "Cancelled";
    }
    // Method to update the appointment date and set status to "Rescheduled"
    public void updateAppointment(String newDate) {
        this.appointmentDate = newDate;
        this.status = "Rescheduled";
    }
    // Getter methods to retrieve appointment details
    public String getAppointmentID() {
        return appointmentID;
    }

    public String getClientID() {
        return clientID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getStatus() {
        return status;
    }
    // Method to return a formatted string containing all appointment details
    public String viewAppointment() {
        return "Appointment ID: " + appointmentID +
               "\nClient ID: " + clientID +
               "\nDoctor ID: " + doctorID +
               "\nAppointment Date: " + appointmentDate +
               "\nStatus: " + status;
    }
    
    
        // -------- File Handing--------
public static void saveIntoFile() {
        try (FileOutputStream f = new FileOutputStream("Appointments.txt");
             ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(appointments);
        } catch (IOException e) {
            System.out.println("Error opening file while writing.");
        }
    }

    public static void instantiateFromFile() {
        try (FileInputStream f = new FileInputStream("Appointments.txt");
             ObjectInputStream o = new ObjectInputStream(f)) {
            Object temp = o.readObject();
            appointments = (ArrayList<Appointment>) temp;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error opening file while reading.");
        }
    }
    
    public static void main(String[] args) {
       
        Appointment a1 = new Appointment("A101", "C001", "D001", "2025-05-01", "Pending");
        Appointment a2 = new Appointment("A202", "C002", "D002", "2025-05-02", "Pending");
        Appointment a3 = new Appointment("A303", "C003", "D001", "2025-05-03", "Booked");
        Appointment a4 = new Appointment("A404", "C004", "D003", "2025-05-04", "Cancelled");
        Appointment a5 = new Appointment("A505", "C005", "D002", "2025-05-05", "Rescheduled");
        Appointment a6 = new Appointment("A606", "C001", "D004", "2025-05-06", "Pending");
        Appointment a7 = new Appointment("A707", "C006", "D005", "2025-05-07", "Booked");
        Appointment a8 = new Appointment("A808", "C007", "D001", "2025-05-08", "Cancelled");
        Appointment a9 = new Appointment("A909", "C002", "D003", "2025-05-09", "Pending");
        Appointment a10 = new Appointment("A010", "C008", "D002", "2025-05-10", "Booked");

        Appointment.appointments.add(a1);
        Appointment.appointments.add(a2);
        Appointment.appointments.add(a3);
        Appointment.appointments.add(a4);
        Appointment.appointments.add(a5);
        Appointment.appointments.add(a6);
        Appointment.appointments.add(a7);
        Appointment.appointments.add(a8);
        Appointment.appointments.add(a9);
        Appointment.appointments.add(a10);

        saveIntoFile();

        appointments.clear();
        instantiateFromFile();

        for (Appointment a : appointments) {
            System.out.println(a.viewAppointment());
            System.out.println("------------");
        }
    }
}

 