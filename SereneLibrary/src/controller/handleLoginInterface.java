package controller;
import view.LoginForm;
import view.LoginFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class handleLoginInterface {

    public static boolean handleLoginSwitch(LoginForm form, boolean isLogin) {
        clearError(form);
        if(isLogin) {
            form.frame.setTitle("SereneLib - Login");
            form.changeFormLabel.setText("Don't have an account?");
            form.signInLabel.setText("Login");
            form.changeFormToSignUp.setText("Sign up");
            form.signInButton.setText("Sign in!");
            form.logoLabel.setText("SereneLibrary - Welcome back!");
            form.usernameField.setText("");
            form.passwordField.setText("");
            form.confirmField.setText("");
        } else {
            form.frame.setTitle("SereneLib - Sign Up");
            form.changeFormLabel.setText("Have an account?");
            form.signInLabel.setText("Sign up");
            form.changeFormToSignUp.setText("Sign in");
            form.signInButton.setText("Sign up!");
            form.logoLabel.setText("SereneLibrary - Join now!");
            form.usernameField.setText("");
            form.passwordField.setText("");
            form.confirmField.setText("");
        }
        return isLogin;
    }

    public static void handleError(LoginForm form) {
        if(form.validError) {
            form.errorLabel.setForeground(Color.red);
            form.usernameField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            form.confirmField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            form.passwordField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            form.errorLabel.setText("");
            form.validLabel.setText("<html> Inputs are invalid: Please make sure all inputs have a length of 4 to 14 characters. </html>");
        } else if(form.passError) {
            form.errorLabel.setForeground(Color.red);
            form.usernameField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            form.confirmField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            form.passwordField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            form.errorLabel.setText("Passwords arent matching!");
            form.validLabel.setText("");
        } else if(form.loginError && form.isLogin) {
            form.errorLabel.setForeground(Color.red);
            form.usernameField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            form.confirmField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            form.passwordField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            form.errorLabel.setText("Username or password is wrong!");
            form.validLabel.setText("");
        } else if(form.loginError && !form.isLogin) {
            form.errorLabel.setForeground(Color.red);
            form.usernameField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            form.confirmField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            form.passwordField.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            form.errorLabel.setText("Account already exists!");
            form.validLabel.setText("");
        } else {
            form.errorLabel.setForeground(Color.red);
            form.usernameField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            form.confirmField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            form.passwordField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            form.errorLabel.setText("");
            form.validLabel.setText("");
        }
    }

    public static void clearError(LoginForm form) {
        form.confirmField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        form.passwordField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        form.errorLabel.setText("");
    }

    public static boolean passwordCheck(LoginForm form) {
        String passwordValue = form.passwordField.getText();
        String confirmValue = form.confirmField.getText();
        if(passwordValue.equals(confirmValue)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean validCheck(LoginForm form) {
        String usernameValue = form.usernameField.getText();
        String passValue = form.passwordField.getText();
        String confirmValue = form.confirmField.getText();

        if(usernameValue.length() > 14 || usernameValue.length() < 4) {
            return false;
        }
        if(passValue.length() > 14 || passValue.length() < 4) {
            return false;
        }
        if(confirmValue.length() > 14 || confirmValue.length() < 4) {
            return false;
        }
        return true;
    }
    public static void handleSignup(LoginForm form) {
        form.errorLabel.setForeground(Color.green);
        form.usernameField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        form.confirmField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        form.passwordField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        form.errorLabel.setText("Successfully registered!");
        form.validLabel.setText("");
    }
}
