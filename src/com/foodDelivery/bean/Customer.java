package com.foodDelivery.bean;

public class Customer {

    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String address;

    // Default Constructor
    public Customer() {
        
    }

    // Parameterized Constructor
    public Customer(String customerId, String customerName, String phoneNumber, String address) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters and Setters

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return customerId + "," + customerName + "," + phoneNumber + "," + address;
    }
}