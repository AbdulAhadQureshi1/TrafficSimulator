package display;
import javax.swing.*;

public class OptionsMenu extends JFrame{
    private JPanel optionsMenu;
    private JTextField noOfVehicles;
    private JButton backButton;
    private JTextField speedLimit;
    private JTextField time;

    public OptionsMenu(int width, int height){

        this.setTitle("Welcome");
        this.setSize(width,height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(optionsMenu);

    }

    public JButton getBackButton() {
        return backButton;
    }
}
