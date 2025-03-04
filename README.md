# Library Management System (Console-Based)

## 📌 Project Description

This is a **console-based Library Management System** built using **Java, JDBC, and MySQL**. It allows users to manage books and users in a library by performing various operations like adding books, borrowing, returning, and viewing records.

---

## ⚙️ Features

- 📖 **Add Book** (Insert new book into the database)
- 📚 **View Books** (Retrieve and display all books)
- 👤 **Register User** (Add a new user to the library system)
- 📑 **Borrow Book** (Issue a book to a user)
- 🔄 **Return Book** (Mark a book as returned)
- ❌ **Exit System**

---

## 🛠️ Technologies Used

- **Java (JDK 19)**
- **JDBC (Java Database Connectivity)**
- **MySQL Database**
- **IntelliJ IDEA / Eclipse** (Recommended IDE)

---

## 📂 Project Structure

```
Library Management System/
│── src/
│   ├── main/java/com/example/demoJDBC/
│   │   ├── BookDAO.java         # Handles database operations for books
│   │   ├── DBConnection.java    # Manages database connection
│   │   ├── Main.java            # Entry point of the application
│   │   ├── TransactionDAO.java  # Handles borrow/return book transactions
│   │   ├── UserDAO.java         # Handles database operations for users
│   ├── resources/               # Additional resources (if any)
│── README.md                    # Documentation file
```

---

## 🛠️ Setup Instructions

### 1️⃣ **Database Setup**

1. Open MySQL and create the database:
   ```sql
   CREATE DATABASE library_db;
   
   ```
2. Create the **Books** table:
   ```sql
   CREATE TABLE books (
       book_id INT PRIMARY KEY AUTO_INCREMENT,
       title VARCHAR(255) NOT NULL,
       author VARCHAR(255) NOT NULL,
       status ENUM('Available', 'Issued') DEFAULT 'Available'
   );
   ```
3. Create the **Users** table:
   ```sql
   CREATE TABLE users (
       user_id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(255) NOT NULL,
       contact VARCHAR(15) UNIQUE NOT NULL
   );
   ```
4. Create the **Transactions** table:
   ```sql
   CREATE TABLE transactions (
       trans_id INT PRIMARY KEY AUTO_INCREMENT,
       user_id INT,
       book_id INT,
       issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       return_date TIMESTAMP NULL,
       FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
       FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE
   );
   ```

---

### 2️⃣ **Project Setup in IntelliJ IDEA / Eclipse**

1. Clone this repository or download the source code.
2. Open the project in your IDE.
3. Add **MySQL Connector/J** to your classpath:
   - Download from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).
   - Add the JAR file to the project libraries.
4. Update **DBConnection.java** with your database credentials:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/library_db";
   private static final String USER = "root";
   private static final String PASSWORD = "yourpassword";
   ```
5. Run `Main.java` to start the Library Management System.

---

## 📌 Sample Console Output

```
Library Management System
---------------------------------------------
1. Add Book
2. View Books
3. Register User
4. Borrow Book
5. Return Book
6. Exit
Enter choice: 1
Enter book title: The Alchemist
Enter author: Paulo Coelho
Book added successfully!
```

---

##

