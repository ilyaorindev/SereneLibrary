package controller;

import model.Account;
import view.LoginForm;

import java.sql.Connection;

import static controller.handleLoginInterface.handleError;
import static controller.handleLoginInterface.handleSignup;
import static model.loginFormQueries.*;

public class handleLoginLogic {

    public static void handleLoginStart(LoginForm form, Connection con) {
        if(form.isLogin) {
            handleActualLogin(form, con);
        } else {
            handleActualSignUp(form, con);
        }
    }

    public static void handleActualLogin(LoginForm form, Connection con) {
        String username = form.usernameField.getText();
        if(!accountExists(con, username)) {
            form.loginError = true;
            handleError(form);
            return;
        }
        String password = form.passwordField.getText();
        if(signInOrNot(con, username, password)) {
            System.out.println("Signed in succesfully!");
            new Account(username, password, con, form);
        } else {
            form.loginError = true;
            handleError(form);
        }
    }

    public static void handleActualSignUp(LoginForm form, Connection con) {
        String username = form.usernameField.getText();
        if(accountExists(con, username)) {
            form.loginError = true;
            handleError(form);
            return;
        }
        String password = form.passwordField.getText();
        insertAcc(con, username, password);
        handleSignup(form);
    }
}
