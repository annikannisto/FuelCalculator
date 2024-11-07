package org.example.fuelcalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/fuel_calculator";
    private static final String USER = "root";
    private static final String PASSWORD = "testi123!";

    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to save fuel consumption data
    public static void saveConsumption(double distance, double fuel, double consumption) {
        String query = "INSERT INTO consumption_history (distance, fuel, consumption) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, distance);
            stmt.setDouble(2, fuel);
            stmt.setDouble(3, consumption);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
