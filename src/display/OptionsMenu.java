package display;
import javax.swing.*;

public class OptionsMenu extends JFrame {
    private JPanel optionsMenu;
    private JTextField roadLength;
    private JButton backButton;
    private JTextField speedLimit;
    private JTextField meanWidth;
    private JLabel rL;

    public OptionsMenu(int width, int height) {

        this.setTitle("Welcome");
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(optionsMenu);
        this.speedLimit.setText("60");
        this.meanWidth.setText("0.5");
        this.roadLength.setText("20");

    }

    public JButton getBackButton() {
        return backButton;
    }

    public float getSpeed() {
        return Float.parseFloat(speedLimit.getText());
    }
    public float getMeanWidth() {
        return Float.parseFloat(meanWidth.getText());
    }
    public float getLength() {
        return Float.parseFloat(roadLength.getText());
    }
}