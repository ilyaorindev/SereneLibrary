package controller;
import view.LoginForm;
import view.LoginFrame;

public class handleLoginInterface {

    public static boolean handleLoginSwitch(LoginForm form, boolean isLogin) {
        if(isLogin) {
            form.frame.setTitle("SereneLib - Login");
            form.changeFormLabel.setText("Don't have an account?");
            form.signInLabel.setText("Login");
            form.changeFormToSignUp.setText("Sign up");
            form.signInButton.setText("Sign in!");
            form.logoLabel.setText("SereneLibrary - Welcome back!");
        } else {
            form.frame.setTitle("SereneLib - Sign Up");
            form.changeFormLabel.setText("Have an account?");
            form.signInLabel.setText("Sign up");
            form.changeFormToSignUp.setText("Sign in");
            form.signInButton.setText("Sign up!");
            form.logoLabel.setText("SereneLibrary - Join now!");
        }
        return isLogin;
    }
}
