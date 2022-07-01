package display;

import javax.swing.*;
import java.awt.*;

public class TrafficSimulator extends JFrame{
    private JPanel mainPanel;
    private JPanel navBar;
    private JButton fileButton;
    private JButton saveButton;
    private JButton simulateButton;
    private JButton OptionsButton;
    private JLabel mainHeading;

    private JPanel map_frame;

    private final int NO_OF_BUTTONS = 15;
    private CellBtn btns[] = new CellBtn[NO_OF_BUTTONS];

    public TrafficSimulator(int width, int height) {

        this.setTitle("Welcome");
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);

        JPanel map = new JPanel();
        map.setBounds(0, 0, 200, 200);
        map.setLayout(new GridLayout(3, 3));
        map_frame.add(map);
        for (int i = 0; i < NO_OF_BUTTONS; i++) {
            CellBtn map_tile = new CellBtn(i);
            btns[i] = map_tile;
            map.add(btns[i]);
        }

    }
    public JButton getSimulateButton() {
        return simulateButton;
    }

    public JButton getOptionsButton() {
        return OptionsButton;
    }
}
