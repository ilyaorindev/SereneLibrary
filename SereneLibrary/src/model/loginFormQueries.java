package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.passwordHashing.hashPassword;


public class loginFormQueries {

    public static boolean accountExists(Connection con, String username) {
        String query = "SELECT lusername FROM lib_account WHERE lusername='" + username + "'";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String usernamez = resultSet.getString("lusername");
                System.out.println(usernamez);
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return false;
    }

    public static void insertAcc(Connection con, String user, String pass) {
        String hashPass = hashPassword(pass);
        String query = "INSERT INTO lib_account (lusername, lpassword) VALUES(?, ?)";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, user);
            statement.setString(2, hashPass);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }

    }
}
