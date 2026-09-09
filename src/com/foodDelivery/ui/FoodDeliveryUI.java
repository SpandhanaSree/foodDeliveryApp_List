package com.foodDelivery.ui;

import com.foodDelivery.controller.FoodDeliveryController;
import com.foodDelivery.factory.FoodDeliveryFactory;

import com.foodDelivery.bean.Customer;
import com.foodDelivery.bean.Order;

import java.util.Scanner;
import java.util.List;  


public class FoodDeliveryUI {

    private FoodDeliveryController controller = FoodDeliveryFactory.getController();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {

        System.out.println("===== FOOD DELIVERY SYSTEM =====");
        System.out.println("1. Add Customer");
        System.out.println("2. Find Customer");
        System.out.println("3. View All Customers");
        System.out.println("4. Place Order");
        System.out.println("5. View All Orders");
        System.out.println("6. Find Order");
        System.out.println("7. View Customer Orders");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    public int getChoice() {
        return scanner.nextInt();
    }

    public void start() {

        int choice;
        do {
            showMenu();
            choice = getChoice();

            switch (choice) {

                case 1:
                    addCustomer();
                break;

                case 2:
                    findCustomer();
                break;

                case 3:
                    viewAllCustomers();
                break;

                case 4:
                    placeOrder();
                break;

                case 5:
                    viewAllOrders();
                break;

                case 6:
                    findOrder();
                break;

                case 7:
                    viewCustomerOrders();
                break;

                case 8:
                    System.out.println("Thank you for using Food Delivery System!");
                break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);
        scanner.close();
        System.out.println("Application closed successfully!");
    }
    
    public static void main(String[] args) {

        FoodDeliveryUI ui = new FoodDeliveryUI();
        ui.start();
   }

   private void addCustomer() {

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.next();

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.next();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.next();

        System.out.print("Enter Address: ");
        String address = scanner.next();

        Customer customer = new Customer( customerId, customerName, phoneNumber, address );
        boolean added = controller.addCustomer(customer);

        if (added) {
            System.out.println("Customer added successfully!");
        } else {
            System.out.println("Customer ID already exists!");
        }
    }

    private void findCustomer() {

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.next();

        Customer customer = controller.findCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer Found:");
            System.out.println(customer);
        } else {
            System.out.println("Customer not found!");
        }
    }

    private void viewAllCustomers() {

        List<Customer> customers = controller.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
        } else {
            System.out.println("===== ALL CUSTOMERS =====");

            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    private void placeOrder() {

        System.out.print("Enter Order ID: ");
        String orderId = scanner.next();

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.next();

        System.out.print("Enter Food Name: ");
        scanner.nextLine();
        String foodName = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        double totalPrice = price * quantity;

        Order order = new Order( orderId, customerId,foodName, quantity, price, totalPrice );

        boolean added = controller.addOrder(order);

        if (added) {
            System.out.println("Order placed successfully!");
            System.out.println("Total Price: " + totalPrice);
        } else {
            System.out.println("Order ID already exists");
        }
    }

    private void viewAllOrders() {

        List<Order> orders = controller.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found!");
        } else {
            System.out.println("===== ALL ORDERS =====");

            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    private void findOrder() {

        System.out.print("Enter Order ID: ");
        String orderId = scanner.next();

        Order order = controller.findOrderById(orderId);
        if (order != null) {
            System.out.println("Order Found:");
            System.out.println(order);
        } else {
            System.out.println("Order not found!");
        }
    }

    private void viewCustomerOrders() {

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.next();

        List<Order> orders = controller.getOrdersByCustomerId(customerId);
        if (orders.isEmpty()) {
            System.out.println("No orders found for this customer!");
        } else {
            System.out.println("===== CUSTOMER ORDERS =====");

            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }
}