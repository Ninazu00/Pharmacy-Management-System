package javaapplication2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Doctor extends User{
    private static ArrayList<Doctor> doctors = new ArrayList<>(); // an ArrayList to store doctors objects
    private String specialization; // the doctor specialization
    private String licenseNumber; // the doctor license number
    private ArrayList<String> avaliableHours = new ArrayList<>(); // an ArrayList to store doctors avaliable hours
    private float consultstionFee; // a float variable to store the doctor consultstion fee

    public Doctor(String specialization, String licenseNumber, float consultstionFee, String id, String name, String username, String email, String phone, String password) { // doctor constractor
        super(id, name, username, email, phone, password); // inherits from User
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.consultstionFee = consultstionFee;
    }

    //Setters
    public static void setDoctors(ArrayList<Doctor> doctors) {
        Doctor.doctors = doctors;
        saveDoctorsToFile();
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
    
    // Gettters
    public static ArrayList<Doctor> getDoctors() {
        instantiateFromFile();
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
    
    // this method is used to add a doctor object in the doctors ArrayList
    public static boolean addDoctor(Doctor doctor) 
    {
        boolean result = doctors.add(doctor);
        saveDoctorsToFile();
        return result;
    }
    
    // this method is used to remove a doctor object in the doctors ArrayList
    public static boolean removeDoctor(Doctor doctor) 
    {
        boolean result = doctors.remove(doctor);
        saveDoctorsToFile();
        return result;
    }
    
    // this method is to diagnose a client, it gets the client object and his description of his symptoms
    public String diagnoseClient(Client client, String symptoms) 
    {
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
     
    // this method adds the available slot of doctors 
    public boolean addAvailableSlot(String day, int startHour, int endHour) 
    {
    if (startHour < 0) {
    System.out.println("Error: Start hour cannot be negative (received " + startHour + ")");
    return false;
    } 
    else if (endHour > 24) {
    System.out.println("Error: End hour cannot be greater than 24 (received " + endHour + ")");
    return false;
    } 
    else if (startHour >= endHour) {
    System.out.println("Error: Start hour (" + startHour + ") must be before end hour (" + endHour + ")");
    return false;
    }
    
    if (!day.equalsIgnoreCase("Monday") && !day.equalsIgnoreCase("Tuesday") &&!day.equalsIgnoreCase("Wednesday") && !day.equalsIgnoreCase("Thursday") &&!day.equalsIgnoreCase("Friday") && !day.equalsIgnoreCase("Saturday") &&!day.equalsIgnoreCase("Sunday")) 
    {
        System.out.println("Error: '" + day + "' is not a valid day. Please enter Monday-Sunday.\n");
        return false;
    }
    
    String newSlot = day + " " + startHour + "-" + endHour;
    
    // this for loop is used to ensure that the new avaliable slot is vaild
    for (int i = 0; i< avaliableHours.size(); i++) 
    {
        String slot = avaliableHours.get(i);
        if (slot.startsWith(day)) {
            return false; 
        }
    }
    avaliableHours.add(newSlot); // adds the new slot into the  avaliableHours ArrayList
    return true;
    }
    
    public static boolean docCheck(String Username, String password)
    {
       
       for (Doctor d: doctors)
       {
           if (d.getUsername().equals(Username) && d.getPassword().equals(password))
           {
               return true;
           }
       }
       return false;
   }
    
    // File handling methods
    public static void saveDoctorsToFile() {
        try (FileOutputStream f = new FileOutputStream("Doctors.txt");
             ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(doctors);
            o.close();
        } catch (IOException e) {
            System.out.println("Error opening file while writing.");
        }
    }

    public static void instantiateFromFile() {
        try (FileInputStream f = new FileInputStream("Doctors.txt");
             ObjectInputStream o = new ObjectInputStream(f)) {
            Object temp = o.readObject();
            doctors = (ArrayList<Doctor>)temp;
            o.close();
            f.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error opening file while reading");
        }
    }
}