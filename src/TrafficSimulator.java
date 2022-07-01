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
    private JButton roadButton;
    private JButton tunnelButton;
    private JButton bridgeButton;
    private JButton roundAboutButton;
    private JButton signalButton;

    public TrafficSimulator(int width, int height){

        this.setTitle("Welcome");
        this.setSize(width,height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);

        JPanel map = new JPanel();
        map.setBounds(0,0,200,200);
        map.setLayout(new GridLayout(2,2));
        map_frame.add(map);
        for(int i=0 ; i<9 ; i++ ) {

            JButton map_tile = new JButton("Grass");
            map_tile.setBounds(0,0,100,100);
            map_tile.setPreferredSize(new Dimension(100, 100));
            map_tile.addActionListener(e -> {
                System.out.println("You added a road");
            });
            map.add(map_tile);

        }

    }

    public JButton getSimulateButton() {
        return simulateButton;
    }

    public JButton getOptionsButton() {
        return OptionsButton;
    }

    public JButton getRoadButton() {
        return roadButton;
    }

    public JButton getTunnelButton() {
        return tunnelButton;
    }

    public JButton getBridgeButton() {
        return bridgeButton;
    }

    public JButton getRoundAboutButton() {
        return roundAboutButton;
    }

    public JButton getSignalButton() {
        return signalButton;
    }
}
