import javax.swing.*;

public class TrafficSimulator extends JFrame{
    private JPanel mainPanel;
    private JPanel navBar;
    private JButton fileButton;
    private JButton saveButton;
    private JButton simulateButton;
    private JButton OptionsButton;
    private JLabel mainHeading;
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
