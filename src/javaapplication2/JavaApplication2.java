package javaapplication2;
import java.util.Date;
import java.util.ArrayList;
//Group 17 Java Pharmacy Management System Project
/*
239236-Mohamed Ayman
--------------------------
242781-Ramy Emad Eldin
--------------------------
247024-Abdelrahman Ahmed
--------------------------
249032-Mostafa Omar
--------------------------
242850-Yousef Hazem
--------------------------
222402-Loay Serag
*/

public class JavaApplication2 {
    public static void main(String[] args) {
        //TESTING FOR SessionController CLASS Ramy EmadEldin 242781
        System.out.println("Signing up a new client...");
        boolean signUpSuccess = SessionController.signUpClient("C001", "Ramy EmadEldin", "RamyE", "ramy55@gmail.com", "01223572404", "ramy55", "Elnozha");
        System.out.println("Client Sign-up Successful: " + signUpSuccess);

        System.out.println("\nAttempting to log in as Client...");
        boolean loginSuccess = SessionController.loginUser("ramy55@gmail.com", "ramy55", "Client");
        System.out.println("Client Login Successful: " + loginSuccess);
        
        User currentUser = SessionController.getCurrentUser();
        if (currentUser != null) {
            System.out.println("Current User: " + currentUser.getEmail());
        } else {
            System.out.println("No user is currently logged in.");
        }

        System.out.println("\nLogging out...");
        SessionController.logoutUser();

        if (SessionController.getCurrentUser() == null) {
            System.out.println("User successfully logged out.");
        } else {
            System.out.println("Logout failed.");
        }
        
       
        // TESTING FOR Appointment CLASS Ramy EmadEldin 242781
        Appointment appointment = new Appointment("A001", "C123", "D456", "2025-04-01", "Pending");

       
        System.out.println("Initial Appointment Details:");
        System.out.println(appointment.viewAppointment());

       
        appointment.bookAppointment();
        System.out.println("\nAfter Booking:");
        System.out.println(appointment.viewAppointment());

        
        appointment.updateAppointment("2025-04-10");
        System.out.println("\nAfter Rescheduling:");
        System.out.println(appointment.viewAppointment());

        
        appointment.cancelAppointment();
        System.out.println("\nAfter Cancellation:");
        System.out.println(appointment.viewAppointment());

        // TESTING FOR OrderController CLASS Youssef Hazem 242850
        Medicine m = new Medicine(3, "Aspirin", "BATCH003", 4.49, 100, new Date(125,0,1));
        Medicine m2 = new Medicine(4, "Vitamin C", "BATCH004", 3.49, 50, new Date(125,0,1));
        Medicine.addMedicine(m);
        Medicine.addMedicine(m2);

        OrderController orderController = new OrderController();

          System.out.println("Creating orders:");
        orderController.createOrder(1, m, 10, 10.5); 
        orderController.createOrder(2, m2, 5, 25.0);
        orderController.createOrder(2, m, 15, 10.5);


        System.out.println("\nUpdating orders:");
        orderController.updateOrder("1", 20, 12.0);
        orderController.updateOrder("3", 5, 10.0);
        orderController.updateOrder(null, 10, 15.0);


        System.out.println("\nCanceling orders:");
        orderController.cancelOrder("1");
        orderController.cancelOrder("3");
        
        // TESTING FOR Transaction CLASS Youssef Hazem 242850
        Date exp1 = new Date();
        Medicine medicine = new Medicine(1, "Aspirin", "BATCH123", 10.5, 100,exp1 );

        Order order = new Order(medicine, 10); 

        Transaction transaction = new Transaction("T123", 100.50f, "Credit Card", 20240327, "Pending", order);

        System.out.println("Amount: " + transaction.getAmount());
        System.out.println("Payment Method: " + transaction.getPaymentMethod());
        System.out.println("Status: " + transaction.getStatus());
        System.out.println("Order ID: " + transaction.getOrder().getOrderID());

        transaction.setAmount(200.75f);
        transaction.setPaymentMethod("Debit Card");
        transaction.setStatus("Completed");

        System.out.println("Updated Amount: " + transaction.getAmount());
        System.out.println("Updated Payment Method: " + transaction.getPaymentMethod());
        System.out.println("Updated Status: " + transaction.getStatus());

        transaction.setTransactionStatus("Pending"); 
        transaction.setTransactionStatus("InvalidStatus"); 

        transaction.updatePaymentMethod("PayPal");
        transaction.updatePaymentMethod(""); 

        transaction.cancelTransaction(); 
        transaction.setStatus("Pending");
        transaction.cancelTransaction(); 

        System.out.println(transaction.getTransactionDetails());
        
//TESTING FOR Doctor CLASS Mostafa Omar 249032
        Doctor D1 = new Doctor("General Practitioner","EG-123456",150.5f,"D001","Mostafa Omar","Dr.Mostafa","mostafa@hootmail.com","01099999999","A123#uMa984Hj"); // created a new doctor object
        D1.addDoctor(D1);// adding the new doctor object (D1) using the method addDoctor()
        Doctor D2 = new Doctor("Internal Medicine","EG-654321",250.5f,"D002","Mohammed Khaled","Dr.Mohammed24","Mohammed24@gmail.com","01012345678","H%67328%%Ahbcfmnss"); // created a new doctor object
        D2.addDoctor(D2); // adding the new doctor object (D2) using the method addDoctor()
        
        ArrayList temp = new ArrayList(); // creating a ArrayList called "temp"
        // this for loop is used to iterate between the doctors, from the first doctor to the last doctor
        for (int i = 0; i < D1.getDoctors().size(); i++) {
            temp.add(D1.getDoctors().get(i).getName()); // adding the doctors names to "temp" ArrayList
        }
        System.out.println("The Avalable Doctors are \n" +  temp + "\n"); // printing out the names of the doctors
        
        
        D1.addAvailableSlot("Monday", 13, 18); // adding the time slot that doctor Mostafa is available in Monday
        D1.addAvailableSlot("Tuesday", 9, 15);  // adding the time slot that doctor Mostafa is available in Tuesday
        
        System.out.println("The avalable hours for doctor Mostafa is "); // printing a message for the user
        System.out.println(D1.getAvaliableHours() + "\n"); // printing the avaliable hours for doctor Mostafa
        
        Client CT = new Client("C005", "Ahmed", "Ahmed12", "ahmed12@gmail.com", "01090824885", "CVGHFYg62##35xcs", "101 Kasr El Ainy Street P.O. 11516 Cairo"); // creating a new client 
        System.out.println(D1.diagnoseClient(CT, "I have a fever and cough")); // sending the symptoms of client Ahmed using diagnoseClient() method
        D1.removeDoctor(D1); // removing D1 Doctor object using removeDoctor() method
        D2.removeDoctor(D2); // removing D2 Doctor object using removeDoctor() method
              
        //TESTING FOR Admin CLASS Mostafa Omar 249032
        Medicine m12 = new Medicine(1, "Paracetamol", "B123", 2.5, 100, new Date(126, 0, 1));
        Medicine m21 = new Medicine(2, "Ibuprofen", "B124", 3.0, 50, new Date(125, 11, 31));
        Medicine m32 = new Medicine(3, "Amoxicillin", "B125", 5.0, 30, new Date(125, 9, 15));

        // Test adding medicines
        Admin.addMedicine(m12);
        Admin.addMedicine(m21);
        Admin.addMedicine(m32);

        
        System.out.println("\nInventory after adding medicines:"); // Generate report after adding
        Admin.generateReports();

        
        System.out.println("\nUpdating Ibuprofen...");  // Test updating a medicine
        Medicine updatedMed2 = new Medicine(2, "Ibuprofen - Updated", "B124U", 3.5, 45, new Date(126, 5, 1));
        Admin.updateMedicineDetails(2, updatedMed2);

        
        System.out.println("\nInventory after updating medicine:"); // Generate report after updating
        Admin.generateReports();

        
        System.out.println("\nRemoving Amoxicillin..."); // Test removing a medicine
        Admin.removeMedicine(3);

        
        System.out.println("\nInventory after removing medicine:"); // Generate report after removing
        Admin.generateReports();
        
        Admin A1 = new Admin("AD001", "Omar Ali", "omar54", "Omar54@gmail.com", "01090909090", "crghcb45c8"); // created a new admin object
        A1.addAdmin(A1); // adding the new admin object (A1) using the method addAdmin()
        Admin A2 = new Admin("AD002", "Ali Ahmed", "ali75", "ali75@gmail.com", "01012457856", "cbhgh%ew124652");
        A2.addAdmin(A2); // adding the new admin object (A2) using the method addAdmin()
        
        ArrayList temp1 = new ArrayList(); // creating a ArrayList called "temp"
        // this for loop is used to iterate between the admins, from the first admin to the last admin
        for (int i = 0; i < A1.getAdmins().size(); i++) {
            temp1.add(A1.getAdmins().get(i).getName()); // adding the admins names to "temp" ArrayList
        }
        System.out.println("The Avalable Admins are \n" +  temp1); // printing out the names of the admins
        A1.removeAdmin(A1); // removing A1 admin object using removeAdmin() method
        A2.removeAdmin(A2); // removing A2 admin object using removeAdmin() method
        
        // TESTING FOR Chat AND Message CLASSES Mohamed Ayman 239236
        SessionController.loginUser("ramy55@gmail.com", "ramy55", "Client");// Logging in Client to be able to test Chat class. NOT PART OF TESTING
        
        //CHAT CODE TESTING BEGINS HERE:
        SessionController.signUpClient("C001", "Ramy EmadEldin", "RamyE", "ramy55@gmail.com", "01223572404", "ramy55", "Elnozha");
        SessionController.loginUser("ramy55@gmail.com", "ramy55", "Client");
        Doctor D3 = new Doctor("Neurosurgery","EG-644321",220.5f,"D003","Ramy Emad","Ramroom","Ramroom@gmail.com","01012345678","H%673342cfmnss"); // created a new doctor object
        Doctor.addDoctor(D3); // adding the new doctor object (D2) using the method addDoctor()
        Doctor D4 = new Doctor("Heartsurgeon","EG-625321",210.5f,"D004","Youssef Hazem","Youssef Hazem","Youssef Hazem@gmail.com","01012345678","Hdasfsdhbcfmnss"); // created a new doctor object
        Doctor.addDoctor(D4); // adding the new doctor object (D2) using the method addDoctor()
        Chat a1 = new Chat("D001");
        a1.sendMessage("Good morning, Doctor");
        a1.sendMessage("I have some back pain.");
        Chat a2 = new Chat("D002");
        a2.sendMessage("Good afternoon, I have head pain.");
        SessionController.logoutUser();
        SessionController.loginUser("mostafa@hootmail.com", "A123#uMa984Hj", "Doctor");
        a1.sendMessage("Come to my office for a checkup.");
        Chat.saveIntoFile();
        System.out.println(Chat.getChats());
        System.out.println();
        System.out.println(a1);
        a1.deleteMessage(1);
        System.out.println(a1);
        System.out.println(Chat.getChats());
        System.out.println(Chat.getUserChats());
        //
        
        // TESTING FOR Order Abdelrahman Ahmed 247024
        Date exp = new Date();
        Medicine prof = new Medicine(102, "prof", "4", 5.50, 10, exp);
        Order ord = new Order( prof , 4 );
        ord.updateOrder(3);
        ord.discountOrder(20.0);
        System.out.println(ord.getPrice());
    }
}