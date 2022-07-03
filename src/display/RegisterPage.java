package display;

import javax.swing.*;

public class RegisterPage extends JFrame {
    private JLabel newPassword;
    private JLabel NewUserName;
    private JPanel MPanel;
    private JPanel Main;
    private JButton submitButton;
    private JTextField passwordTextField;
    private JTextField userTextField;
    public RegisterPage(int width, int height){
        this.setTitle("Register");
        this.setSize(width,height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(Main);

    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public String[] details() {
        return new String[]{userTextField.getText(), passwordTextField.getText()};
    }
    public void userExist(){
        JOptionPane.showMessageDialog(Main, "Username taken");
    }
}