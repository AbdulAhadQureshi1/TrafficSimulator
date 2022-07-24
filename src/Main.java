import display.*;
import database.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    public static void main(String[] args) {

        //Variables
        AtomicInteger serial = new AtomicInteger();

        // getting the dimensions of the device
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight();

        //loading up all the pages
        LoginPage login = new LoginPage(width, height);
        RegisterPage register = new RegisterPage(width,height);
        StartPage start = new StartPage(width, height);
        TrafficSimulator mainPage = new TrafficSimulator(width, height);
        ResultsPage simulationResults = new ResultsPage(width, height);
        OptionsMenu options = new OptionsMenu(width, height);

        login.setVisible(true);

        // page-switching mechanism
        // used lambda functions just for saving time and lines
        login.getUser().addActionListener(e -> {
            Sql s = new Sql();
            String[] credentials = login.inputs();
            serial.set(s.auth(credentials[0], credentials[1]));
            if (serial.get() != -1 ){
                login.dispose();
                start.setVisible(true);
            }
            else{
                login.noMatch();
                login.setVisible(true);
            }
        });

        login.newUser().addActionListener(e -> {
            login.dispose();
            register.setVisible(true);

        });
        register.getSubmitButton().addActionListener(e -> {
            Sql s = new Sql();
            String[] details = register.details();
            int rtn = s.newUser(details[0],details[1]);
            if (rtn == -1){
                register.userExist();
                register.setVisible(true);
            }
            else {
                register.dispose();
                login.setVisible(true);
            }
        });
        start.getOpenButton().addActionListener(e -> {
            start.dispose();
            mainPage.setVisible(true);
        });
        mainPage.getSimulateButton().addActionListener(e -> {
            mainPage.setVisible(false);
            simulationResults.setVisible(true);
            float[] data = RouteAlgo.getRoute(options.getSpeed());
            simulationResults.Text(data);
            //debug
            for(int x =0;x<10;x++) {
                for (int y = 0; y < 20; y++) {
                    System.out.print(RouteAlgo.tiles_info[x][y]+" ");

                }
                System.out.println();
            }
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


    }
}
