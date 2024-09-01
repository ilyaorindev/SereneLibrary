import view.LoginForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static model.database.initializeDB;

public class Main {


    public static void main(String[] args) {
        new LoginForm(initializeDB());
    }
}
