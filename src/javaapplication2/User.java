package javaapplication2;

import java.io.Serializable;

abstract public class User implements Serializable {
    // Doctors, Admins, and Clients have these attributes common between them, so this is the purpose of User class, to be a parent for all of these classes.
    private String id; // User ID
    private String name; // User Name
    private String username; // User Username
    private String email; // User Email, can be a hotmail, gmail... etc
    private String phone; // User Phone Number, it is a string because there is no need for mathmatical operations on it
    private String password; // User Password

    public User(String id, String name, String username, String email, String phone, String password) { // User constractor 
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    
    // Setters
    public void setId(String id) { 
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", phone=" + phone + ", password=" + password + '}';
    }
}