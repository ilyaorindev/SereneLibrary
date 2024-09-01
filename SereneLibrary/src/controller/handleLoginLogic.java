package controller;

import view.LoginForm;

public class handleLoginLogic {

    public static void handleLoginStart(LoginForm form) {
        if(form.isLogin) {
            handleActualLogin(form);
        } else {
            handleActualSignUp(form);
        }
    }

    public static void handleActualLogin(LoginForm form) {
        System.out.println("Login went through!");
    }

    public static void handleActualSignUp(LoginForm form) {
        System.out.println("Sign up went through!");
    }
}
