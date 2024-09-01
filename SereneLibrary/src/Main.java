import view.LoginForm;

import java.sql.Connection;

import static model.database.initializeDB;

public class Main {


    public static void main(String[] args) {
        Connection sqlCon = initializeDB();
        new LoginForm(sqlCon);
    }
}
