package com.foodDelivery.service;

import java.util.List;
import com.foodDelivery.bean.Customer;
import com.foodDelivery.bean.Order;
import com.foodDelivery.repository.FoodDeliveryRepository;

public class FoodDeliveryService {

    // Singleton instance
    private static FoodDeliveryService instance;
    
    // Private constructor
    private FoodDeliveryService(){
        //private important.Why? Because Service Singleton.
        //Even though it is empty, we need to define private because it is a Singleton class.
    }

    public static FoodDeliveryService getInstance() {
        if (instance == null) {
            instance = new FoodDeliveryService();
        }
        return instance;        
    }

    private FoodDeliveryRepository repository = FoodDeliveryRepository.getInstance();

    public boolean addCustomer(Customer customer) {
        Customer existingCustomer = repository.findCustomerById(customer.getCustomerId());
            if (existingCustomer != null) {
                return false; //Customer already exists. So return false.
            }
        repository.addCustomer(customer);  //add Customer method call chesi, new customer ni add chestham.andhulo repository.saveCustomers() method call chestham. So customers.csv file update avutundi.
        return true; //Customer added successfully. So return true.
    }

    public Customer findCustomerById(String customerId) { 
        return repository.findCustomerById(customerId); 
    }

    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers(); //Service layer cannot directly access repository. So we call repository.getAllCustomers() method and return the list of customers.
    }

    public boolean addOrder(Order order) { //Cannot access reository layer !! so we use getters to get the data from repository layer
        Customer customer = repository.findCustomerById(order.getCustomerId()); 
        if (customer == null) {
            return false;
        }

        Order existingOrder = repository.findOrderById(order.getOrderId());
        if (existingOrder != null) {
            return false;
        }

        repository.addOrder(order);
        return true;
    }

    public List<Order> getAllOrders() {
        return repository.getAllOrders();
    }

    public Order findOrderById(String orderId) {
        return repository.findOrderById(orderId);
    }

    public List<Order> getOrdersByCustomerId(String customerId) {
        return repository.getOrdersByCustomerId(customerId);
    }
}