package com.foodDelivery.service;

import java.util.List;
import com.foodDelivery.bean.Customer;
import com.foodDelivery.bean.Order;
import com.foodDelivery.repository.FoodDeliveryRepository;

public class FoodDeliveryService {
    private static FoodDeliveryService instance;
    
    private FoodDeliveryService(){

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
                return false;
            }
        repository.addCustomer(customer);
        return true;
    }

    public Customer findCustomerById(String customerId) {
        return repository.findCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    public boolean addOrder(Order order) {

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