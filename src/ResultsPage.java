import javax.swing.*;
import java.awt.*;

class ResultsPage extends JFrame{
    private JPanel resultsMainPage;
    private JButton backToMain;

    public ResultsPage(int width, int height){

        this.setTitle("Welcome");
        this.setSize(width,height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(resultsMainPage);
        this.setVisible(false);

    }
    public JButton getBackToMain() {
        return backToMain;
    }
}
