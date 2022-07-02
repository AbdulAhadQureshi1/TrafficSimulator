package display;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class CellBtn extends JButton {

    private final int yaxis;
    private final int xaxis;
    private String currentState = "grass";
    private final Icon grass = new ImageIcon("src/display/images/grass.png");
    private final Icon roadh = new ImageIcon("src/display/images/roadh.png");
    private final Icon roadv = new ImageIcon("src/display/images/roadv.png");
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
        Object[] options = {"Vertical", "Horizontal"};
        String side = (String)JOptionPane.showInputDialog(f, "Orientation:\n",
                        "Road Orientation",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        "Vertical");

        // try-catch because cancelling gives an error, does not crash the program but still shows in the terminal
        try {
            if (side.equals("Vertical")) {
                super.setIcon(roadv);
                setCurrentState("vertical");
            } else if (side.equals("Horizontal")) {
                super.setIcon(roadh);
                setCurrentState("horizontal");
            }
        }catch (Exception e) {}

        tilesInfo.put(this.getCo(), this.currentState);
    }

    public void revertState() {

        Frame f = new Frame();
        int result = JOptionPane.showConfirmDialog(f,"Are you sure you want to revert back to grass?", "Revert Back to Grass",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            super.setIcon(grass);
            setCurrentState("grass");
        }

    }
    public String getCo(){
            int[] coordinate  = {xaxis,yaxis};
            return xaxis + " " + yaxis;
        }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

}
