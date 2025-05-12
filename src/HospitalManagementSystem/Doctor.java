package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
    private Connection connection;
    private Scanner scanner;

    public Doctor(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);
    }
    public void addDoctor() {
        System.out.print("Enter Doctor name:");
        String name = scanner.next();

        System.out.print("Enter doctor Specialization:");
        String specialization = scanner.next();
        try {
            String query = "INSERT INTO doctors(name,specialization) VALUES( ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, specialization);
            int affectRows = preparedStatement.executeUpdate();
            if (affectRows > 0) {
                System.out.println("Doctor Added Successfully");
            } else {
                System.out.println("Failed to add doctor");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewDoctors() {
        String query = "select * from doctors";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("+------------+--------------------+-----------------+");
            System.out.println("| Doctors Id | Name               | Specialization  |");
            System.out.println("+------------+--------------------+-----------------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("|%-12s|%-20s|%-17s|\n",id,name,specialization);
                System.out.println("+------------+--------------------+-----------------+");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getDoctorByID(int id) {
        String query = "SELECT * FROM doctors WHERE id= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

     return false;
}
}


