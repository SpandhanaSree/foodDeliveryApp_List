package com.foodDelivery.repository;

import java.util.List;  // Customers and Orders ni memory lo multiple records ga store cheyyadaniki List use chesthamu.
import java.util.ArrayList; // List oka interface, direct ga use cheyalemu so Arraylist use chesi List interface vadutham.


import java.io.BufferedReader; //File lo line by line data read cheyyadaniki easy way.
import java.io.FileReader; // File ni open chesi characters ni read cheyyadaniki we use this. But idhi convenient ga line-by-line read cheyyadu.Anduke we use BufferedReader.
import java.io.IOException;  // File operations lo problems/errors occur avuthai while opening & reading files. So we need to handle those errors using try-catch block. And for that we need to import this class.
import java.io.FileWriter; //File lo data write cheyyadaniki we use this. But idhi convenient ga line-by-line write cheyyadu.Anduke we use PrintWriter.
import java.io.PrintWriter; //File lo formatted ga / easy ga text write cheyyadaniki use chestham.

import com.foodDelivery.bean.Customer;
import com.foodDelivery.bean.Order;

public class FoodDeliveryRepository {

    // Singleton instance 
    private static FoodDeliveryRepository instance; 
    /*Singleton = oka class ki program motham lo only ONE object undela design cheyyadam.
    *Application lo evaraina Repository kavali ante same object ni use chestaru.
    *static ante ee variable class ki belong avutundi, particular object ki kaadu.
    *ikkada instance anedi just oka variable name.ikkada instance loo foodDeliveryRepository object ni store chesi use chesthunamu.*/

    // Private constructor
    private FoodDeliveryRepository() {
        loadCustomers();
        loadOrders();
    }
    /*Normally constructor public/default ga unte outside nunchi enni objects aina create cheyyachu.
    *But Singleton goal = only ONE object. 
    *So we make the constructor private and create one object with getInstance()*/

    // Singleton getInstance()
    public static FoodDeliveryRepository getInstance() {
        if (instance == null) {  // First time getInstance() call ayye appudu instance null untundi. So new object create chestham.
            instance = new FoodDeliveryRepository();
        } // Next time getInstance() call ayye appudu instance null kaadu. So only one object create avutundi.
        return instance;
    }

    private List<Customer> customers = new ArrayList<>(); //Customer objects kosam oka empty ArrayList create chesi, danini customers variable lo store chesam.
    private List<Order> orders = new ArrayList<>();  //Order objects ni store cheyyadaniki empty ArrayList create chesi, orders variable lo store chesam.

    private String customerFile = "src/resources/customers.csv";
    private String orderFile = "src/resources/orders.csv";

    public void addCustomer(Customer customer) {
        customers.add(customer); //new customer add ienapudu. Customer ni customers list lo add chestham.
        saveCustomers(); //Customer add ayyaka, customers.csv file update cheyyali. So saveCustomers() method call chestham.
    }

    public Customer findCustomerById(String customerId) { //Customer ikkada return type.Ee method work complete ayyaka oka Customer object return chestundi.
        for (Customer customer : customers) { //customers list lo unna prathi Customer ni one-by-one check cheyyi.
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() { 
        return customers; //customers list lo unna prathi Customer ni return chestundi.
    }

    public void addOrder(Order order) {
        orders.add(order); //new order add ienapudu. Order ni orders list lo add chestham.
        saveOrders(); //Order add ayyaka, orders.csv file update cheyyali. So saveOrders() method call chestham.
    }

    public List<Order> getAllOrders() { 
        return orders; //orders list lo unna prathi Order ni return chestundi.
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
        List<Order> customerOrders = new ArrayList<>(); //Customer ki sambandhinchina orders ni store cheyyadaniki empty ArrayList create chesi, customerOrders variable lo store chesam.
        for (Order order : orders) {
            if (order.getCustomerId().equals(customerId)) {
                customerOrders.add(order);  //Customer ki sambandhinchina order ni customerOrders list lo add chestham.
            }
        }
        return customerOrders;
    }

    /*Mana project lo customers memory lo ArrayList lo unnaru: 
    *Ippudu program close ayithe, ee ArrayList data memory nunchi pothundi.
    *So manam aa data ni permanent ga: customers.csv file lo save chestham*/
    public void saveCustomers() {  //Customers ni file lo save cheyyadaniki ee method. Void because emi return cheyyadu. Just save chestundi.

        //new FileWriter(customerFile) - customers.csv file ni writing kosam open cheyyi.
        //new PrintWriter(new FileWriter(customerFile)) - File open chesam → ippudu danilo lines easy ga write cheyyadaniki PrintWriter use chestham.
        try (PrintWriter pw = new PrintWriter(new FileWriter(customerFile))) { 

            //Header save chestunnam
            pw.println("customerId,customerName,phoneNumber,address");

            //customers ArrayList lo unna each customer ni one-by-one tesukoni, dani details ni file lo write chestham.
            for (Customer customer : customers) {

                /*customer object ni directly print chestunnam.
                manam Customer.java lo override chesina toString() method automatically call avutundi.
                Anduke pw.println(customer) automatically toString() ni use chestundi.*/
                pw.println(customer);
            }
        } catch (IOException e) {

            //File save chestunnappudu problem vaste, program crash avvakunda error message chupinchadaniki.
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

    //loadCustomers() = CSV file nunchi customers ni read chesi ArrayList lo store cheyyadam. 
    public void loadCustomers() {
        try (BufferedReader br = new BufferedReader(new FileReader(customerFile))) { //File ni open chesthund. line to line read chesthundhi.

            String line; //Idi oka variable.File nunchi current line ni temporary ga store cheyyadaniki.
            br.readLine(); //Header line ni skip cheyyali. So first line read chesi, danini ignore chestham.

            while ((line = br.readLine()) != null) { //File lo next line read chesi, danini line variable lo store chestham. Loop continues till end of the file.
                String[] data = line.split(","); //split(",") comma daggara break chestundi.
                String customerId = data[0]; //"C001"
                String customerName = data[1]; //"Ravi"
                String phoneNumber = data[2]; //"9876543210"
                String address = data[3]; //"Hyderabad"

                Customer customer = new Customer( customerId, customerName, phoneNumber, address ); //Customer object create chesi, dani details constructor ki pass chestham.
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

