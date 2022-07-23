package display;

import javax.swing.*;

public class ResultsPage extends JFrame {
    private JPanel resultsMainPage;
    private JButton backToMain;
    private JPanel VLabels;
    private JLabel shotDist;
    private JLabel longDist;
    private JLabel time;
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

    public void Text(float[] data) {
        shotDist.setText("Shortest Distance is " + data[0]);
        longDist.setText("Longest Distance is " + data[1]);
        time.setText("Average Commute Time is " + (data[2]) + " Seconds");
    }
}