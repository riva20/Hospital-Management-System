
# Hospital Management System

A backend Hospital Management System developed in Java with MySQL integration, offering core functionalities for managing patients, doctors, and appointments via a command-line interface.

## Features

- Add and view patient records
- Add and view doctor records
- Book appointments
- Console-based user interface
- MySQL backend using JDBC

## Technologies Used

- Java (JDK 21)
- MySQL
- JDBC
- IntelliJ IDEA or NetBeans (Recommended IDE)

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/hospital-management-system.git
   cd hospital-management-system
   ```

2. **Set up MySQL Database**
   ```sql
   CREATE DATABASE hospital_db;

   CREATE TABLE doctors (
       id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100),
       specialization VARCHAR(100)
   );

   CREATE TABLE patients (
       id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100),
       age INT
   );

   CREATE TABLE appointments (
       id INT PRIMARY KEY AUTO_INCREMENT,
       patient_id INT,
       doctor_id INT,
       appointment_date DATE,
       FOREIGN KEY (patient_id) REFERENCES patients(id),
       FOREIGN KEY (doctor_id) REFERENCES doctors(id)
   );
   ```

3. **Update Database Credentials in Java**
   ```java
   String url = "jdbc:mysql://localhost:3306/hospital_db";
   String user = "root";
   String password = "your_password";
   ```

4. **Run the Application**
   - Use your IDE to run the `Main` class.
   - Ensure MySQL is running and accessible.

## Sample Console Output

```
HOSPITAL MANAGEMENT SYSTEM
1. Add Patient
2. Add Doctors
3. View Patient
4. View Doctors
5. Book Appointment
6. Exit
```

## License

This project is licensed under the MIT License.
