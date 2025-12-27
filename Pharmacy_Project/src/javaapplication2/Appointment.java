package javaapplication2;

public class Appointment {
    private String appointmentID;
    private String clientID;
    private String doctorID;
    private String appointmentDate;
    private String status;

    public Appointment(String appointmentID, String clientID, String doctorID, String appointmentDate, String status) {
        this.appointmentID = appointmentID;
        this.clientID = clientID;
        this.doctorID = doctorID;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public void bookAppointment() {
        status = "Booked";
    }

    public void cancelAppointment() {
        status = "Cancelled";
    }

    public void updateAppointment(String newDate) {
        this.appointmentDate = newDate;
        this.status = "Rescheduled";
    }

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

    public String viewAppointment() {
        return "Appointment ID: " + appointmentID +
               "\nClient ID: " + clientID +
               "\nDoctor ID: " + doctorID +
               "\nAppointment Date: " + appointmentDate +
               "\nStatus: " + status;
    }
}