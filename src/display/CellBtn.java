package display;
import javax.swing.*;
import java.awt.*;

public class CellBtn extends JButton {
    private boolean state = false;
    private final int yaxis;
    private final int xaxis;
    private Icon grass = new ImageIcon("src/display/images/grass.png");
    private Icon roadh = new ImageIcon("src/display/images/roadh.png");
    private Icon roadv = new ImageIcon("src/display/images/roadv.png");

    public CellBtn(int x, int y){
        super.setIcon(grass);
        super.addActionListener(e -> {
            this.changeState();
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

        state = true;
        if (side == "Vertical"){
            super.setIcon(roadv);
        }
        else{
            super.setIcon(roadh);
        }
        System.out.print(xaxis+" "+yaxis);
    }
    public boolean getbtnState(){
        return state;
    }
    public int[] getIndex(){
        int[] coordinate  = {xaxis,yaxis};
        return coordinate;
    }
}
