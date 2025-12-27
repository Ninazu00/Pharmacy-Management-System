package javaapplication2;
import java.util.ArrayList;

public class Doctor extends User{
    private static ArrayList<Doctor> doctors = new ArrayList<>(); 
    private String specialization;
    private String licenseNumber;
    private ArrayList<String> avaliableHours = new ArrayList<>();
    private float consultstionFee;

    public Doctor(String specialization, String licenseNumber, float consultstionFee, String id, String name, String username, String email, String phone, String password) {
        super(id, name, username, email, phone, password);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.consultstionFee = consultstionFee;
    }

    
    public static void setDoctors(ArrayList<Doctor> doctors) {
        Doctor.doctors = doctors;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setAvaliableHours(ArrayList<String> avaliableHours) {
        this.avaliableHours = avaliableHours;
    }


    public void setConsultstionFee(float consultstionFee) {
        this.consultstionFee = consultstionFee;
    }

    public static ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public ArrayList<String> getAvaliableHours() {
        return avaliableHours;
    }

    public float getConsultstionFee() {
        return consultstionFee;
    }
    
    public static boolean addDoctor(Doctor doctor) {
        return doctors.add(doctor);
    }
    
    public static boolean removeDoctor(Doctor doctor) {
        return doctors.remove(doctor);
    }
    
    public String diagnoseClient(Client client, String symptoms) {
    String diagnosis;
    
    if (symptoms.toLowerCase().contains("fever") && symptoms.contains("cough")) {
        diagnosis = "Likely a common cold or the flu. Rest, stay hydrated, and use fever reducers if needed.";
    } else if (symptoms.contains("headache") && symptoms.contains("nausea")) {
        diagnosis = "Possibly a migraine, dehydration, or a mild viral infection. Rest, drink fluids, and avoid bright lights.";
    } else {
        diagnosis = "Symptoms unclear. Further tests or observation recommended.";
    }
    
    return "Diagnosis for " + client.getName() + ": " + diagnosis;
    }
     
    public boolean addAvailableSlot(String day, int startHour, int endHour) {
    if (startHour >= endHour || startHour < 0 || endHour > 24) {
        return false;
    }
    String newSlot = day + " " + startHour + "-" + endHour;
    
    for (int i = 0; i< avaliableHours.size(); i++) {
        String slot = avaliableHours.get(i);
        if (slot.startsWith(day)) {
            return false; 
        }
    }
    avaliableHours.add(newSlot); 
    return true;
    }
}

