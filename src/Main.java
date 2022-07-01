import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // getting the dimensions of the device
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight();

        //loading up all the pages
        StartPage start = new StartPage(width, height);
        TrafficSimulator mainPage = new TrafficSimulator(width, height);
        ResultsPage simulationResults = new ResultsPage(width, height);
        OptionsMenu options = new OptionsMenu(width, height);

        start.setVisible(true);

        // page-switching mechanism
        // used lambda functions just for saving time and lines
        start.getOpenButton().addActionListener(e -> {
            start.dispose();
            mainPage.setVisible(true);
        });
        mainPage.getSimulateButton().addActionListener(e -> {
            mainPage.setVisible(false);
            simulationResults.setVisible(true);
        });
        mainPage.getOptionsButton().addActionListener(e -> {
            mainPage.setVisible(false);
            options.setVisible(true);
        });
        simulationResults.getBackToMain().addActionListener(e -> {
            mainPage.setVisible(true);
            simulationResults.dispose();
        });
        options.getBackButton().addActionListener(e -> {
            mainPage.setVisible(true);
            options.setVisible(false);
        });

        //Functionality of Map making buttons
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();



    }
}
