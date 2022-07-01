package display;
import javax.swing.*;
import java.awt.*;

public class CellBtn extends JButton {
    private boolean state = false;
    private final int location;
    private String currentState = "grass";
    private Icon grass = new ImageIcon("src/display/images/grass.png");
    private Icon roadh = new ImageIcon("src/display/images/roadh.png");
    private Icon roadv = new ImageIcon("src/display/images/roadv.png");
    public CellBtn(int index){

        // these are values every btn will by default have
        super.setIcon(grass);
        super.addActionListener(e -> {
            if (!this.state) {
                this.changeState();
            }
            else {
                this.revertState();
            }
            System.out.println(this.getIndex());
        });
        super.setBounds(0, 0, 100, 100);
        super.setPreferredSize(new Dimension(100, 100));
        location = index;
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


        if (side == "Vertical"){
            super.setIcon(roadv);
            state = true;
        }
        else if (side == "Horizontal"){
            super.setIcon(roadh);
            state = true;
        } else {}

    }

    public void revertState() {

        Frame f = new Frame();
        int result = JOptionPane.showConfirmDialog(f,"Are you sure you want to revert back to grass?", "Revert Back to Grass",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            super.setIcon(grass);
            state = false;
        }

    }
    public boolean getbtnState(){
        return state;
    }
    public int getIndex(){
        return location;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}
