package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import static controller.handleLoginInterface.*;
import static controller.handleLoginLogic.handleLoginStart;
import static utils.interfaceHelper.resizeIcon;

public class LoginForm {
    public LoginFrame frame;
    public JPanel leftPane;
    public JPanel rightPane;
    public JLabel signInLabel;
    public JLabel usernameLabel;
    public JLabel passwordLabel;
    public JLabel confirmLabel;
    public JButton signInButton;
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JPasswordField confirmField;
    public JLabel imageHolder;
    public JLabel logoLabel;
    public JLabel changeFormLabel;
    public JButton changeFormToSignUp;
    public JLabel infoLabel;
    public boolean isLogin;
    public boolean passError;
    public boolean loginError;
    public boolean validError;
    public JLabel errorLabel;
    public JLabel validLabel;
    private Connection connection;


    //Frame is 1000 width, 600 height, keep in mind.
    public LoginForm(Connection sqlCon) {
        frame = new LoginFrame(true);
        this.isLogin = true;
        this.connection = sqlCon;
        setupPanels();
        setupLabels();
        setupInputs();
        setupErrors();
        frame.setVisible(true);
    }

    public void setupPanels() {
        frame.setLayout(null);
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        leftPanel.setBounds(0,0,500,600);
        rightPanel.setBounds(500,0,500,600);
        leftPanel.setBackground(Color.white);
        rightPanel.setBackground(new Color(0x304C89));
        leftPane = leftPanel;
        rightPane = rightPanel;
        this.frame.add(this.leftPane);
        this.frame.add(this.rightPane);
    }

    public void setupLabels() {
        JLabel signInLabel = new JLabel();
        JLabel usernameLabel = new JLabel();
        JLabel passwordLabel = new JLabel();
        JLabel confirmLabel = new JLabel();
        JLabel changeFormLabel = new JLabel();
        JLabel infoLabel = new JLabel();

        ImageIcon backImage = new ImageIcon("SereneLibrary/background.png");
        backImage = resizeIcon(backImage, 500, 400);
        JLabel imageHolder = new JLabel();
        imageHolder.setIcon(backImage);
        JLabel logoLabel = new JLabel();
        logoLabel.setForeground(Color.white);

        infoLabel.setText("<html>We are glad to have you back</html>");
        signInLabel.setText("Login");
        usernameLabel.setText("Enter Username:");
        passwordLabel.setText("Enter Password:");
        confirmLabel.setText("Confirm Password:");
        logoLabel.setText("SereneLibrary - Welcome back!");
        changeFormLabel.setText("Don't have an account?");

        signInLabel.setFont(new Font("Montserrat", Font.BOLD, 26));
        usernameLabel.setFont(new Font("Montserrat", Font.ITALIC, 15));
        passwordLabel.setFont(new Font("Montserrat", Font.ITALIC, 15));
        confirmLabel.setFont(new Font("Montserrat", Font.ITALIC, 15));
        logoLabel.setFont(new Font("Montserrat", Font.ITALIC, 26));
        infoLabel.setFont(new Font("Montserrat", Font.ITALIC, 20));
        usernameLabel.setForeground(Color.gray);
        passwordLabel.setForeground(Color.gray);
        confirmLabel.setForeground(Color.gray);


        leftPane.setLayout(null);
        rightPane.setLayout(null);

        signInLabel.setBounds(30, 90, 150, 30);
        usernameLabel.setBounds(30,200, 150, 24);
        passwordLabel.setBounds(30, 250, 150, 24);
        confirmLabel.setBounds(30, 300, 150, 24);
        imageHolder.setBounds(0, 190, 500, 222);
        logoLabel.setBounds(35, 90, 500, 30);
        changeFormLabel.setBounds(30, 420, 160, 16);
        infoLabel.setBounds(30, 115, 400, 55);


        this.infoLabel = infoLabel; this.changeFormLabel = changeFormLabel; this.signInLabel = signInLabel; this.usernameLabel = usernameLabel; this.passwordLabel = passwordLabel; this.confirmLabel = confirmLabel; this.imageHolder = imageHolder; this.logoLabel = logoLabel;
        leftPane.add(this.signInLabel);
        leftPane.add(this.usernameLabel);
        leftPane.add(this.passwordLabel);
        leftPane.add(this.confirmLabel);
        leftPane.add(this.changeFormLabel);
        rightPane.add(this.imageHolder);
        rightPane.add(this.logoLabel);

    }

    public void setupInputs() {
        JButton signInButton = new JButton();
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField ();
        JPasswordField confirmField = new JPasswordField ();
        JButton changeFormToSignUp = new JButton();

        changeFormToSignUp.setText("Sign up");
        changeFormToSignUp.setBackground(Color.white);
        changeFormToSignUp.setForeground(new Color(0x5F4B66));
        changeFormToSignUp.setBorder(null);
        changeFormToSignUp.setFocusPainted(false);

        usernameField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        confirmField.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        LoginForm toPass = this;
        changeFormToSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLogin = handleLoginSwitch(toPass, !isLogin);
            }
        });

        signInButton.setText("Sign in!");
        signInButton.setBackground(new Color(0x648DE5));
        signInButton.setForeground(Color.white);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validCheck(toPass)) {
                    toPass.validError = true;
                    toPass.loginError = false;
                    toPass.passError = false;
                    handleError(toPass);
                    return;
                }

                if(passwordCheck(toPass)) {
                    toPass.passError = false;
                    toPass.loginError = false;
                    toPass.validError = false;
                    handleError(toPass);
                    handleLoginStart(toPass);
                } else {
                    toPass.passError = true;
                    toPass.loginError = false;
                    toPass.validError = false;
                    handleError(toPass);
                }
            }
        });

        signInButton.setBounds(30, 380, 370, 30);
        changeFormToSignUp.setBounds(165, 420, 45, 16);
        usernameField.setBounds(180, 200, 220, 24);
        passwordField.setBounds(180, 250, 220, 24);
        confirmField.setBounds(180, 300, 220, 24);


        this.signInButton = signInButton; this.usernameField = usernameField; this.passwordField = passwordField; this.confirmField = confirmField; this.changeFormToSignUp = changeFormToSignUp;
        leftPane.add(this.signInButton);
        leftPane.add(this.changeFormToSignUp);
        leftPane.add(this.usernameField);
        leftPane.add(this.passwordField);
        leftPane.add(this.confirmField);
    }

    public void setupErrors() {
        passError = false;
        loginError = false;
        validError = false;

        JLabel errorLabel = new JLabel();
        errorLabel.setForeground(Color.red);
        errorLabel.setFont(new Font("Montserrat", Font.PLAIN, 12));
        errorLabel.setBounds(180, 320, 220, 24);

        JLabel validLabel = new JLabel();
        validLabel.setForeground(Color.red);
        validLabel.setFont(new Font("Montserrat", Font.PLAIN, 11));
        validLabel.setBounds(405, 115, 60, 300);

        this.validLabel = validLabel;
        this.errorLabel = errorLabel;
        leftPane.add(this.errorLabel);
        leftPane.add(this.validLabel);
    }


}
