# 🍦 Ice-Cream Distributor

A Spring Boot application built for managing an ice-cream shop’s daily business activities such as product management, stock tracking, purchases, sales, authentication, and revenue reports.
This project is designed with real-world business logic and scalable architecture.

---

# 🚀 Features

### 🧊 **Product Management**

* Add new products
* Update product details
* Delete products safely
* View all products

### 📦 **Stock Management**

* Real-time stock tracking
* Increase / decrease stock
* Invalid quantity validation
* Auto-update stock on purchases & sales

### 🛒 **Purchase Management**

* Record stock purchases
* Auto-increase inventory
* Maintain distributor purchase history

### 💵 **Sales Management**

* Create sale with multiple items
* Auto-deduct stock
* Sale history tracking
* Prevent selling more than available stock

### 📊 **Reports Module**

* Daily sales
* Monthly sales
* Daily revenue
* Monthly revenue
* Total profit calculation

### 🔐 **Authentication (Spring Security + JWT)**

* Signup
* Login
* Token-based authentication
* Protected routes for owner APIs

### 🏗 **Clean Architecture**

* DTOs + Entities
* Services + Interfaces
* Repositories
* Controllers
* Mappers
* Exception handling

---

# 🛠 Tech Stack

* **Java 17+**
* **Spring Boot**
* **Spring Web**
* **Spring JPA (Hibernate)**
* **Spring Security (JWT Authentication)**
* **MySQL Database**
* **Lombok**
* **Swagger / SpringDoc** for API documentation
* **Postman** for testing

---

# 📂 Modules Overview

### **Product Module**

Handles all product catalog operations.

### **Stock Module**

Manages and synchronizes stock quantities.

### **Purchase Module**

Tracks inventory intake from distributors.

### **Sale Module**

Manages customer sales and deducts stock.

### **Report Module**

Calculates revenue, profit, and sales analytics.

### **Auth Module**

Manages user registration & secure login.

---

# 🔍 What You Will Learn From This Project

* Building REST APIs in Spring Boot
* Implementing JWT authentication
* Proper use of JPA mappings:

    * One-to-One
    * One-to-Many / Many-to-One
* Handling real-world stock logic
* Writing clean DTOs & service layers
* Using SpringDoc Swagger
* Writing reusable mapper classes
* Building a real business use-case end-to-end

---

# 💡 Why This Project Is Valuable

This project demonstrates **real business logic**, not just CRUD:

* Stock sync with purchases & sales
* Profit calculation
* Validations
* Secure API design
* Report generation
* Clean code structure
