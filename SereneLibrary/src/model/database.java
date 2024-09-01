package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class database {
    public static Connection initializeDB() {
        String url = "jdbc:mysql://us-cluster-east-01.k8s.cleardb.net:3306/heroku_fdeac7008cbe170?reconnect=true";
        String username = "b7b93c6c56405e";
        String password = "9d108301";

        Connection connection = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");
                return connection;
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception: " + e.getMessage());
        } finally {
            // Close the connection if it was successful
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("SQL Exception on closing: " + e.getMessage());
                }
            }
            return null;
        }
    }
}
