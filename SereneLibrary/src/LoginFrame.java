import javax.swing.*;
public class LoginFrame extends JFrame {

    public LoginFrame(boolean flag) {
        if(flag) {
            this.setSize(1000, 600);
            this.setResizable(false);
            this.setTitle("SereneLib - Login");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            this.setSize(1000, 600);
            this.setResizable(false);
            this.setTitle("SereneLib - Sign Up");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
