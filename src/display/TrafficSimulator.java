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
    private CellBtn btns[] = new CellBtn[200];

    public TrafficSimulator(int width, int height) {

        this.setTitle("Welcome");
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);

        JPanel map = new JPanel();
        map_frame.setLayout(null);
        map.setBounds(0, 0, 600, 300);
        map.setLayout(new GridBagLayout());
        map.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        map_frame.add(map);
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 20 ;j++) {
                c.ipady = 0;
                c.gridx = j;
                c.gridy = i;
                CellBtn map_tile = new CellBtn(i,j);
                btns[i] = map_tile;
                map.add(btns[i], c);
            }
        }

    }
    public JButton getSimulateButton() {
        return simulateButton;
    }

    public JButton getOptionsButton() {
        return OptionsButton;
    }
}
