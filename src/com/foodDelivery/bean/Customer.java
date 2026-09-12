package com.foodDelivery.bean;

public class Customer {

    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String address;

    // Default Constructor
    public Customer() {
        //Arguments lekunda Customer object create cheyyadaniki constructor kavali.
    }

    // Parameterized Constructor
    public Customer(String customerId, String customerName, String phoneNumber, String address) {

        this.customerId = customerId;    //this.variable = parameter;
        this.customerName = customerName;   //"this" is necessary when the parameter has the same name as the instance variable.
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /*
     * Getters and Setters
     * Getter -> to access/read the value, Setter -> modify/change the value
     * Because they are private variables, other classes cannot directly access or change them.So we provide getters and setters.
     * Accessing variables through getters and setters is called encapsulation.
     */

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

    @Override // allows a subclass to provide a specific implementation of a method that is already defined in its parent class.
    public String toString() {  // toString() → object ni print chesthe meaningful information chupinchadaniki.
        return customerId + "," + customerName + "," + phoneNumber + "," + address;
    }
}