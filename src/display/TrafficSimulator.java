package display;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import javax.swing.Timer;

public class TrafficSimulator extends JFrame{
    private JPanel mainPanel;
    private JPanel navBar;
    private JButton fileButton;
    private JButton saveButton;
    private JButton simulateButton;
    private JButton OptionsButton;
    private JLabel mainHeading;

    private JPanel map_frame;
    private static CellBtn btns[][] = new CellBtn[10][20];

    //must be static because it doesn't need object to be initialized.
    public static HashMap<String, String> tiles_info = new HashMap<>();
    public TrafficSimulator(int width, int height) {

        this.setTitle("Welcome");
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);

        // creating infinite loop that runs in background to check the junctions
        Timer timer = new Timer(1000/60,new JunctionCheck());
        timer.start();

        // map panel
        JPanel map = new JPanel();
        map_frame.setLayout(null);
        map.setBounds(0, 0, 600, 300);
        map.setLayout(new GridBagLayout());
        map.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        map_frame.add(map);

        // map buttons
        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 20 ;j++) {
                c.ipady = 0;
                c.gridx = j;
                c.gridy = i;
                CellBtn map_tile = new CellBtn(i,j);
                btns[i][j] = map_tile;
                map.add(btns[i][j], c);

                tiles_info.put(i + " " + j, map_tile.getCurrentState());
            }
        }

    }
    public JButton getSimulateButton() {
        return simulateButton;
    }

    public JButton getOptionsButton() {
        return OptionsButton;
    }

    public static CellBtn[][] getBtns(){
        return btns;
    }
}
