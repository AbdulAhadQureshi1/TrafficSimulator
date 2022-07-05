package display;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class CellBtn extends JButton {

    private final int yaxis;
    private final int xaxis;
    private String currentState = "grass";
    private final Icon grass = new ImageIcon("src/display/images/grass.png");
    private final Icon roadh = new ImageIcon("src/display/images/roadHorizontal.png");
    private final Icon roadv = new ImageIcon("src/display/images/roadVertical.png");

    private final Icon source = new ImageIcon("src/display/images/traffic-jam.png");

    private final Icon sink = new ImageIcon("src/display/images/placeholder.png");
    public static HashMap<String, String> tilesInfo = TrafficSimulator.tiles_info;
    public CellBtn(int x, int y){

        // these are values every btn will by default have
        super.setIcon(grass);
        super.addActionListener(e -> {
            if (this.getCurrentState().equals("grass")) {
                this.changeState();
            }
            else {
                this.revertState();
            }

        });
        super.setBounds(0, 0, 30, 30);
        super.setPreferredSize(new Dimension(30, 30));
        xaxis = x;
        yaxis = y;
    }
    public void changeState(){

        Frame f = new Frame();
        String side;

        String borderCheck = this.getCo();

        Object[] options;
        // catching indexOutofBound exception for buttons on single digit column numbers
        try {
            if (borderCheck.charAt(0) == '0' || borderCheck.charAt(2) == '0' || borderCheck.charAt(0) == '9' || borderCheck.charAt(3) == '9') {
                options = new Object[]{"Vertical", "Horizontal", "Source", "Sink"};
            } else {
                options = new Object[]{"Vertical", "Horizontal"};
            }
        } catch(IndexOutOfBoundsException ignored) {
            options  = new Object[]{"Vertical", "Horizontal"};
        }

        side = (String)JOptionPane.showInputDialog(f, "Orientation:\n",
                "Road Orientation",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                "Vertical");

        // try-catch because cancelling gives an error, does not crash the program but still shows error in the terminal
        try {

            switch (side) {
                case "Vertical" -> {
                    super.setIcon(roadv);
                    setCurrentState("vertical");
                }
                case "Horizontal" -> {
                    super.setIcon(roadh);
                    setCurrentState("horizontal");
                }
                case "Source" -> {
                    super.setIcon(source);
                    setCurrentState("source");
                }
                case "Sink" -> {
                    super.setIcon(sink);
                    setCurrentState("sink");
                }
            }



        }catch (Exception ignored) {}

        tilesInfo.put(this.getCo(), this.currentState);
    }

    public void revertState() {

        Frame f = new Frame();
        int result = JOptionPane.showConfirmDialog(f,"Are you sure you want to revert back to grass?", "Revert Back to Grass",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            setCurrentState("grass");
            super.setIcon(grass);
        }
        tilesInfo.put(this.getCo(), this.currentState);

    }
    public String getCo(){
            return xaxis + " " + yaxis;
        }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

}
