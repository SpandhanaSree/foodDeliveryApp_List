# Food Delivery System

A console-based Food Delivery System developed using Core Java. The application allows users to manage customers and food orders through a simple command-line interface.

## Features

* Add new customers
* Find customers by Customer ID
* View all customers
* Place food orders
* View all orders
* Find orders by Order ID
* View orders of a particular customer
* Validate customer existence before placing an order
* Prevent duplicate Customer IDs and Order IDs
* Calculate total order amount
* Store and retrieve data using CSV files
* Persistent data storage between program executions

## Technologies Used

* Java
* Core Java Collections
* File Handling
* CSV Persistence
* Scanner
* VS Code

## Design Patterns Used

### Singleton Pattern

Singleton Pattern is used to ensure that only one instance of the Controller, Service, and Repository is created.

### Factory Pattern

Factory Pattern is used to provide access to the Controller, Service, and Repository objects.

## Project Architecture

The application follows a layered architecture:

```text
UI
 ↓
Controller
 ↓
Service
 ↓
Repository
 ↓
List
 ↓
CSV Files
```

### Layers

* **UI** – Takes input from the user using Scanner and displays output.
* **Controller** – Connects the UI with the Service layer.
* **Service** – Contains the business logic and validations.
* **Repository** – Manages lists and CSV file persistence.
* **Bean** – Contains Customer and Order data classes.
* **Factory** – Provides application component instances.

## Project Structure

```text
foodDeliveryApp_List
│
├── src
│   ├── com
│   │   └── foodDelivery
│   │       ├── bean
│   │       │   ├── Customer.java
│   │       │   └── Order.java
│   │       │
│   │       ├── controller
│   │       │   └── FoodDeliveryController.java
│   │       │
│   │       ├── factory
│   │       │   └── FoodDeliveryFactory.java
│   │       │
│   │       ├── repository
│   │       │   └── FoodDeliveryRepository.java
│   │       │
│   │       ├── service
│   │       │   └── FoodDeliveryService.java
│   │       │
│   │       └── ui
│   │           └── FoodDeliveryUI.java
│   │
│   └── resources
│       ├── customers.csv
│       └── orders.csv
│
└── README.md
```

## CSV Persistence

The application uses CSV files to permanently store data.

### customers.csv

Stores customer information such as:

```text
customerId,customerName,phoneNumber,address
```

### orders.csv

Stores order information such as:

```text
orderId,customerId,foodName,quantity,price,totalAmount
```

When the application starts, existing data is loaded from the CSV files. New customers and orders are saved back to the files.

## Application Menu

```text
1. Add Customer
2. Find Customer
3. View All Customers
4. Place Order
5. View All Orders
6. Find Order
7. View Customer Orders
8. Exit
```

## Example Order

```text
Customer ID: C004
Food Name: Momos
Food Price: 100
Quantity: 3

Order placed successfully!

Order ID     : 105
Customer ID  : C004
Food         : Momos
Quantity     : 3
Price        : ₹100
Total Amount : ₹300
```

## Validation

The application performs important validations such as:

* Duplicate Customer ID is not allowed.
* Duplicate Order ID is not allowed.
* An order cannot be placed for a non-existing customer.
* Customer and order data are persisted using CSV files.

## How to Run

1. Open the project in VS Code.
2. Make sure Java is installed.
3. Open `FoodDeliveryUI.java`.
4. Run the Java program.
5. Use the menu options displayed in the console.

## Author

**Spandhana Sree**

B.Tech – Computer Science and Engineering
