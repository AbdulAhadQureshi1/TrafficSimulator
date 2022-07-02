package display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class JunctionCheck extends JButton implements ActionListener{

    private final Icon junctionImg = new ImageIcon("src/display/images/junction.png");
    private CellBtn[][] btns = TrafficSimulator.getBtns();

    @Override
    public void actionPerformed(ActionEvent e) {
        HashMap<String, String> tilesInfo = CellBtn.tilesInfo;

        for(int i=0; i<10; i++ ) {
            for(int j=0; j<20; j++) {
                try {
                    if ((tilesInfo.get(i + " " + (j+1) ).equals("horizontal") && tilesInfo.get(i + " " + (j-1) ).equals("horizontal")) && (tilesInfo.get((i+1) + " " + j).equals("vertical") || tilesInfo.get((i-1) + " " + j).equals("vertical"))) {
                        btns[i][j].setIcon(junctionImg);
                    }
                    if ((tilesInfo.get((i+1) + " " + j ).equals("vertical") && tilesInfo.get((i-1) + " " + j ).equals("vertical")) && (tilesInfo.get(i + " " + (j+1)).equals("horizontal") || tilesInfo.get(i + " " + (j-1)).equals("horizontal"))) {
                        btns[i][j].setIcon(junctionImg);
                    }

                }catch (Exception ignored) {}

            }
        }
    }
}
