package display;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartPage extends JFrame{
    private JPanel startPanelMain;
    private JButton openButton;
    private JButton newButton;
    private JPanel startPageButtons;

    public StartPage(int width, int height){
        this.setTitle("Welcome");
        this.setSize(width,height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(startPanelMain);

    }

    public JButton getOpenButton() {
        return openButton;
    }
}
