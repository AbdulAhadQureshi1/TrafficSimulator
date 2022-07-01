package display;
import javax.swing.JButton;
import java.awt.*;

public class CellBtn extends JButton {
    private boolean state = false;
    private final int location;
    public CellBtn(int index){
        super("Grass");
        super.addActionListener(e -> {
            this.changeState();
        });
        super.setBounds(0, 0, 100, 100);
        super.setPreferredSize(new Dimension(100, 100));
        location = index;
    }
    public void changeState(){
        state = true;
        super.setText("Road");
        System.out.print(location);
    }
    public boolean getbtnState(){
        return state;
    }
    public int getIndex(){
        return location;
    }
}
