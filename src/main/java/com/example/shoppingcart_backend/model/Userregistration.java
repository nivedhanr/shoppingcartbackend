package com.example.shoppingcart_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registration")
public class Userregistration {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    private String address;

    private String phn;

    private String email;

    private String password;

    private String confirmpass;

    public Userregistration() {
    }

    public Userregistration(int id, String name, String address, String phn, String email, String password, String confirmpass) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phn = phn;
        this.email = email;
        this.password = password;
        this.confirmpass = confirmpass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpass() {
        return confirmpass;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = confirmpass;
    }
}
