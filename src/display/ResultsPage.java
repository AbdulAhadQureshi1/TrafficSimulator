package display;

import javax.swing.*;

public class ResultsPage extends JFrame {
    private JPanel resultsMainPage;
    private JButton backToMain;
    private JPanel VLabels;
    private JLabel shotDist;
    private JLabel longDist;
    private JLabel time;
    private JLabel efficiency;
    private JTextArea textArea1;
    public OptionsMenu op = new OptionsMenu(1,2);

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
        efficiency.setText("Efficiency is: "+ (  (((data[1] - ((data[1] - data[0]) / 2)) / data[1]) * 100) - ((op.getSpeed() - op.getLength()*2.7 + op.getMeanWidth()/0.3)/op.getSpeed()*100)  ) + "% ");
    }
}