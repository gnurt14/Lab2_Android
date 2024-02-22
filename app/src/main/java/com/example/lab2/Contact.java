package com.example.lab2;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
    private boolean Status;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public Contact(int id, String name, String phoneNumber, boolean status) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        Status = status;
    }
}
