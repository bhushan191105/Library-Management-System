

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00758F?style=for-the-badge&logo=mysql&logoColor=white)
![Swing](https://img.shields.io/badge/GUI-JavaSwing-blue?style=for-the-badge)
![JDBC](https://img.shields.io/badge/JDBC-Database-orange?style=for-the-badge)

# 📚 Library Management System (Java + Swing + MySQL)

A desktop-based **Library Management System** built using **Java Swing and MySQL**, designed to manage books, students, and book transactions efficiently.

This system automates **book issuing/returning, student management, and inventory tracking**, including automatic handling of book copies.

---

## 🚀 Features

- 🔐 Admin Login Authentication
- 👨‍🎓 Student Management
  - Add Student
  - Delete Student
  - Search Student
- 📖 Book Management
  - Add Books
  - Auto-generate Book Copies
- 🔄 Issue / Return System
- 💰 Late Fine Calculation
- ⚠ Input Validation & Error Handling
- 🔗 Foreign Key Constraint Handling

---

## 🏗 System Architecture


Java Swing GUI → JDBC → MySQL Database


---

## 🛠 Technologies Used

- Java (Core + Swing)
- MySQL
- JDBC
- AWT/Swing GUI
- SQL (Constraints, Relationships)

---

## 🧠 Concepts Used

### 1. Database Normalization
Separate tables:
- Books
- Book Copies
- Students
- Transactions

---

### 2. Foreign Key Constraints

Ensures:
- A book copy must belong to a valid book
- A transaction must reference a valid student

---

### 3. Transaction Management

Used while adding books:

Insert Book → Insert Copies → Commit

Ensures consistency.

---

### 4. Exception Handling

- Missing fields validation
- Foreign key constraint errors
- SQL exceptions handled with popups

---

### 5. Real-World Library Logic

- Each book has multiple copies
- Each copy has status:
  - Available
  - Issued
  - Lost

---
### ▶ How the System Works
### 📖 Adding a Book

Admin enters book details + number of copies.
Book is inserted into books table.
Multiple entries are automatically created in book_copies.
All copies are set to Available.

---

### 🔄 Issuing a Book
System checks:
Student exists.
Copy is available.
Updates:
Copy → Issued , 
New transaction created .
Due date automatically assigned .

---

## 🔁 Returning a Book
Finds active transaction
Updates:
Return date
Fine calculation (₹5/day late)
Copy → Available

---

## 🧾 Deleting a Student
If student has issued books → ❌ Not allowed
System shows popup warning:
"Return all books before deleting student"

---

## ⚠ Error Handling
- Empty field validation
- Invalid numeric input
- Foreign key constraint handling
- SQL exception popups

---

## 📈 Future Improvements
- GUI table view (JTable)
- Book search system
- Admin roles
- Barcode integration
- Report generation
- Cloud database support

---

# Library-Management-System
A desktop-based  Library Management System built using Java Swing and MySQL, designed to manage books, students, and book transactions efficiently.  This system automates book issuing/returning, student management, and inventory tracking, including automatic handling of book copies.

## 📸 Screenshots

### 🔐 Login Page
![Login](screenshots/login.png)

### 📊 Dashboard
![Dashboard](screenshots/dashboard.png)

### 👨‍🎓 Student Management
![Student](screenshots/add_student.png)

### 📖 Issue Book
![Issue](screenshots/issue_book.png)


