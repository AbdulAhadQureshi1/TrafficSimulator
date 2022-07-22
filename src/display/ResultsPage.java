package display;

import javax.swing.*;
import java.awt.*;

public class ResultsPage extends JFrame {
    private JPanel resultsMainPage;
    private JButton backToMain;
    private JPanel VLabels;
    private JTextArea textArea1;

    public ResultsPage(int width, int height) {

        this.setTitle("Welcome");
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(resultsMainPage);
        this.setVisible(false);

    }

    public JButton getBackToMain() {
        return backToMain;
    }

    public void Text(int[] data) {
        JLabel sp = new JLabel("Shortest Distance = " + data[0]);
        JLabel lp = new JLabel("Longest Distance = " + data[1]);
        textArea1.append("Shortest Distance = " + data[0]);
    }
}