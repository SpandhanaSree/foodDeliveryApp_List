package com.foodDelivery.repository;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.foodDelivery.bean.Customer;
import com.foodDelivery.bean.Order;

public class FoodDeliveryRepository {

    // Singleton instance
    private static FoodDeliveryRepository instance;

    // Private constructor
    private FoodDeliveryRepository() {
        loadCustomers();
        loadOrders();
    }

    // Singleton getInstance()
    public static FoodDeliveryRepository getInstance() {
        if (instance == null) {
            instance = new FoodDeliveryRepository();
        }
        return instance;
    }

    private List<Customer> customers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    private String customerFile = "src/resources/customers.csv";
    private String orderFile = "src/resources/orders.csv";

    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveCustomers();
    }

    public Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public void addOrder(Order order) {
        orders.add(order);
        saveOrders();
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order findOrderById(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getOrdersByCustomerId(String customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId().equals(customerId)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    public void saveCustomers() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(customerFile))) {
            pw.println("customerId,customerName,phoneNumber,address");
            for (Customer customer : customers) {
                pw.println(customer);
            }
        } catch (IOException e) {
            System.out.println("Error writing customers.csv: " + e.getMessage());
        }
    }

    public void saveOrders() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(orderFile))) {
            pw.println("orderId,customerId,foodName,quantity,price,totalAmount");
                for (Order order : orders) {
                pw.println(order);
            }

        } catch (IOException e) {
            System.out.println("Error writing orders.csv: " + e.getMessage());
        }
    }
    public void loadCustomers() {
        try (BufferedReader br = new BufferedReader(new FileReader(customerFile))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                String customerId = data[0];
                String customerName = data[1];
                String phoneNumber = data[2];
                String address = data[3];

                Customer customer = new Customer( customerId, customerName, phoneNumber, address );
                customers.add(customer);
            }
        } catch (IOException e) {
            System.out.println("Error reading customers.csv"+ e.getMessage());
        }
    }
    public void loadOrders() {

        try (BufferedReader br = new BufferedReader(new FileReader(orderFile))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                String orderId = data[0];
                String customerId = data[1];
                String foodName = data[2];
                int quantity = Integer.parseInt(data[3]);
                double price = Double.parseDouble(data[4]);
                double totalAmount = Double.parseDouble(data[5]);

                Order order = new Order( orderId, customerId, foodName, quantity, price, totalAmount );
                orders.add(order);
            }
        } catch (IOException e) {
            System.out.println("Error reading orders.csv"+ e.getMessage());
        }
    }
}

