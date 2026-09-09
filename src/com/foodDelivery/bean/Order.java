package com.foodDelivery.bean;

public class Order {

    private String orderId;
    private String customerId;
    private String foodName;
    private int quantity;
    private double price;
    private double totalAmount;
    
    // Default Constructor
    public Order(){

    }

    // Parameterized Constructor
    public Order(String orderId, String customerId, String foodName, int quantity, double price, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
    }

    // Getters & Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId(){
        return customerId;
    }

    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return orderId + "," + customerId + "," + foodName + "," +  quantity + "," + price + "," + totalAmount;
    }
}