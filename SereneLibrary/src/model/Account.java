package model;

import com.mysql.cj.log.Log;
import view.LoginForm;
import view.MainForm;

import java.sql.Connection;

public class Account {
    private String username;
    private String hashedPass;
    private Connection connection;
    private LoginForm form;

    public Account(String username, String hashedPass, Connection con, LoginForm form) {
        this.username = username;
        this.hashedPass = hashedPass;
        this.connection = con;
        this.form = form;
        initializeProgram();
    }

    private void initializeProgram() {
        form.frame.setVisible(false);
        new MainForm();
    }

    private void logOut() {
        this.username = null;
        this.hashedPass = null;
        this.form = null;
        new LoginForm(connection);
        this.connection = null;
    }
}
