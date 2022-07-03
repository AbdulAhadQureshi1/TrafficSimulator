package display;
import javax.swing.*;

public class LoginPage extends JFrame{
    private JPanel resultsMainPage;
    private JButton loginButton;
    private JButton registerButton;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JPanel LoginFrame;
    private JPanel MainPanel;

    public LoginPage(int width, int height){

        this.setTitle("Welcome");
        this.setSize(width,height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(LoginFrame);

        };

    public JButton getUser() { return loginButton;}
    public JButton newUser() {
        return registerButton;
    }
    public String[] inputs(){
        return new String[]{usernameTextField.getText(), passwordTextField.getText()};
    }
    public void noMatch(){
        JOptionPane.showMessageDialog(LoginFrame, "Username or Password incorrect");
    }

}
