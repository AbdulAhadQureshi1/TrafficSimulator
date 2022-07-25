package display;
import javax.swing.*;
import java.awt.*;
import statistics.*;

public class CellBtn extends JButton {

    private final int yaxis;
    private final int xaxis;
    private String currentState = "x";
    private final Icon grass = new ImageIcon("src/display/images/grass.png");
    private final Icon roadh = new ImageIcon("src/display/images/roadHorizontal.png");
    private final Icon roadv = new ImageIcon("src/display/images/roadVertical.png");

    private final Icon source = new ImageIcon("src/display/images/traffic-jam.png");

    private final Icon sink = new ImageIcon("src/display/images/placeholder.png");
    public CellBtn(int x, int y){

        // these are values every btn will by default have
        super.setIcon(grass);
        super.addActionListener(e -> {
            if (this.getCurrentState().equals("x")) {
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

        int[] borderCheck = this.getCo();

        Object[] options;
        // catching indexOutofBound exception for buttons on single digit column numbers
        try {
            if (borderCheck[0] == 0 || borderCheck[1] == 0 || borderCheck[0] == 9 || borderCheck[1] == 9) {
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
                    setCurrentState("|");
                    RouteAlgo.roads++;
                }
                case "Horizontal" -> {
                    super.setIcon(roadh);
                    setCurrentState("-");
                    RouteAlgo.roads++;
                }
                case "Source" -> {
                    super.setIcon(source);
                    setCurrentState("source");
                    RouteAlgo.source++;
                }
                case "Sink" -> {
                    super.setIcon(sink);
                    setCurrentState("sink");
                    RouteAlgo.sink++;
                }
            }



        }catch (Exception ignored) {}

        int[] index = this.getCo();
        RouteAlgo.tiles_info[index[0]][index[1]] = this.currentState;
    }

    public void revertState() {

        Frame f = new Frame();
        int result = JOptionPane.showConfirmDialog(f,"Are you sure you want to revert back to grass?", "Revert Back to Grass",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            setCurrentState("x");
            super.setIcon(grass);
            RouteAlgo.roads--;
        }
        int[] index = this.getCo();
        RouteAlgo.tiles_info[index[0]][index[1]] = this.currentState;
    }
    public int[] getCo(){
            int[] temp = {xaxis,yaxis};
            return temp ;
        }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

}
