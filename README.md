# 💼 Job Portal Management System

A console-based **Job Portal Management System** built using **Core Java, JDBC, and MySQL**. This project demonstrates user management with CRUD operations, login authentication, input validation, exception handling, and database connectivity using a layered architecture.

---

## 📖 About the Project

The **Job Portal Management System** is designed to manage user information in a job portal environment. It allows users to register, log in, update their details, search for users, and manage records stored in a MySQL database.

This project was developed to strengthen my understanding of **Core Java**, **JDBC**, **SQL**, and **Object-Oriented Programming (OOP)** while following a clean layered architecture.

---

## ✨ Features

- 👤 User Registration
- 🔐 User Login Authentication
- 📋 View All Users
- ✏️ Update User Details
- ❌ Delete User
- 🔍 Search User by ID
- 📧 Search User by Email
- ✅ Input Validation
- ⚠️ Exception Handling
- 🗄️ MySQL Database Connectivity
- 🏗️ Layered Architecture (Model → DAO → Service)

---

## 🛠️ Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- IntelliJ IDEA
- MySQL Connector/J

---

## 📂 Project Structure

```
JobPortalManagementSystem
│
├── src
│   ├── database
│   │      DBConnection.java
│   │
│   ├── model
│   │      User.java
│   │      Job.java
│   │
│   ├── dao
│   │      UserDAO.java
│   │      JobDAO.java
│   │
│   ├── service
│   │      UserService.java
│   │      JobService.java
│   │
│   └── Main.java
│
└── README.md
```

---

## 🗄️ Database Schema

### Database

```sql
CREATE DATABASE job_portal;
```

### Users Table

```sql
CREATE TABLE users (
    user_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    phone VARCHAR(20)
);
```

---

## 🚀 How to Run the Project

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-github-username/Job-Portal-Management-System.git
```

### 2️⃣ Open in IntelliJ IDEA

Import the project into IntelliJ IDEA.

### 3️⃣ Create the Database

Create the `job_portal` database and the `users` table in MySQL.

### 4️⃣ Configure Database Connection

Update your database credentials inside:

```
database/DBConnection.java
```

Example:

```java
String url = "jdbc:mysql://localhost:3306/job_portal";
String username = "root";
String password = "your_password";
```

### 5️⃣ Add MySQL JDBC Driver

Download **MySQL Connector/J** and add the JAR file to your project's libraries.

### 6️⃣ Run the Application

Run:

```
Main.java
```

---

## 💻 Sample Console Output

```
==========================================
      JOB PORTAL MANAGEMENT SYSTEM
==========================================

1. Register User
2. View Users
3. Delete User
4. Update User
5. Login
6. Search User By ID
7. Search User By Email
8. Exit

Enter Your Choice :
```

---

## 🏗️ Project Architecture

```
                 Main.java
                      │
                      ▼
             UserService.java
                      │
                      ▼
               UserDAO.java
                      │
                      ▼
            DBConnection.java
                      │
                      ▼
               MySQL Database
```

---

## 📚 Concepts Covered

- Core Java
- Object-Oriented Programming (OOP)
- JDBC
- MySQL
- CRUD Operations
- PreparedStatement
- ResultSet
- Exception Handling
- Input Validation
- Layered Architecture

---

## 📸 Screenshots

Add your project screenshots inside a folder named **screenshots**.

Example:

```
screenshots/
│
├── menu.png
├── register-user.png
├── view-users.png
├── search-user.png
├── login.png
└── database.png
```

Then they will appear like this:

```markdown
![Main Menu](screenshots/menu.png)

![Register User](screenshots/register-user.png)

![View Users](screenshots/view-users.png)

![Database](screenshots/database.png)
```

---

## 🎯 Learning Outcomes

Through this project, I learned:

- Building a Java console application
- Connecting Java with MySQL using JDBC
- Performing CRUD operations
- Applying Object-Oriented Programming concepts
- Writing SQL queries using PreparedStatement
- Handling exceptions
- Validating user input
- Organizing code using a layered architecture

---

## 🚀 Future Enhancements

- Admin Module
- Recruiter Module
- Job Management
- Apply for Jobs
- Resume Upload
- Password Encryption
- Role-Based Authentication
- GUI using JavaFX
- Spring Boot Web Version

---

## 🎥 Project Demo

Watch the complete project demonstration here:

🔗 Google Drive Demo:
https://drive.google.com/file/d/1ybyVh1nxjb6ocO9TbFMlXHG_FM8XGHmW/view?usp=sharing
