package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
}
