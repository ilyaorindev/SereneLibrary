package controller;

import view.LoginForm;

import java.sql.Connection;

import static controller.handleLoginInterface.handleError;
import static model.loginFormQueries.accountExists;

public class handleLoginLogic {

    public static void handleLoginStart(LoginForm form, Connection con) {
        if(form.isLogin) {
            handleActualLogin(form, con);
        } else {
            handleActualSignUp(form, con);
        }
    }

    public static void handleActualLogin(LoginForm form, Connection con) {
        System.out.println("Login went through!");
        String username = form.usernameField.getText();
        if(!accountExists(con, username)) {
            form.loginError = true;
            handleError(form);
            return;
        }


    }

    public static void handleActualSignUp(LoginForm form, Connection con) {
        System.out.println("Sign up went through!");
        String username = form.usernameField.getText();
        accountExists(con, username);
        if(!accountExists(con, username)) {
            form.loginError = true;
            handleError(form);
            return;
        }


    }
}
