package display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class JunctionCheck implements ActionListener{

    private final Icon junctionImg = new ImageIcon("src/display/images/junction.png");
    private final Icon tdownImg = new ImageIcon("src/display/images/tdown.png");
    private final Icon tupImg = new ImageIcon("src/display/images/tup.png");
    private final Icon trightImg = new ImageIcon("src/display/images/tright.png");
    private final Icon tleftImg = new ImageIcon("src/display/images/tleft.png");
    private final Icon uptoleftImg = new ImageIcon("src/display/images/uptoleft.png");
    private final Icon uptorightImg = new ImageIcon("src/display/images/uptoright.png");
    private final Icon righttodownImg = new ImageIcon("src/display/images/righttodown.png");
    private final Icon lefttodownImg = new ImageIcon("src/display/images/lefttodown.png");
    private final CellBtn[][] btns = TrafficSimulator.getBtns();

    @Override
    public void actionPerformed(ActionEvent e) {
        HashMap<String, String> tilesInfo = CellBtn.tilesInfo;

        for(int i=0; i<10; i++ ) {
            for(int j=0; j<20; j++) {

                // checking Junctions
                try {
                    // junction 4way
                    if ((tilesInfo.get(i + " " + (j+1) ).equals("horizontal") && tilesInfo.get(i + " " + (j-1) ).equals("horizontal")) && (tilesInfo.get((i+1) + " " + j).equals("vertical") && tilesInfo.get((i-1) + " " + j).equals("vertical"))) {
                        btns[i][j].setIcon(junctionImg);
                        tilesInfo.put(btns[i][j].getCo(), "junction");
                    }
                    // t junction downwards
                    else if ((tilesInfo.get(i + " " + (j+1) ).equals("horizontal") && tilesInfo.get(i + " " + (j-1) ).equals("horizontal")) && (tilesInfo.get((i+1) + " " + j).equals("vertical") && tilesInfo.get((i-1) + " " + j).equals("grass"))) {
                            btns[i][j].setIcon(tdownImg);
                            tilesInfo.put(btns[i][j].getCo(), "tdown");

                    }
                    // t junction upwards
                    else if ((tilesInfo.get(i + " " + (j+1) ).equals("horizontal") && tilesInfo.get(i + " " + (j-1) ).equals("horizontal")) && (tilesInfo.get((i+1) + " " + j).equals("grass") && tilesInfo.get((i-1) + " " + j).equals("vertical"))) {
                        btns[i][j].setIcon(tupImg);
                        tilesInfo.put(btns[i][j].getCo(), "tup");

                    }
                    //t junction right
                    else if ((tilesInfo.get(i + " " + (j+1) ).equals("horizontal") && tilesInfo.get(i + " " + (j-1) ).equals("grass")) && (tilesInfo.get((i+1) + " " + j).equals("vertical") && tilesInfo.get((i-1) + " " + j).equals("vertical"))) {
                        btns[i][j].setIcon(trightImg);
                        tilesInfo.put(btns[i][j].getCo(), "tright");

                    }
                    //t junction left
                    else if ((tilesInfo.get(i + " " + (j+1) ).equals("grass") && tilesInfo.get(i + " " + (j-1) ).equals("horizontal")) && (tilesInfo.get((i+1) + " " + j).equals("vertical") && tilesInfo.get((i-1) + " " + j).equals("vertical"))) {
                        btns[i][j].setIcon(tleftImg);
                        tilesInfo.put(btns[i][j].getCo(), "tleft");

                    }
                    //up left turn
                    else if ((tilesInfo.get(i + " " + (j+1) ).equals("grass") && tilesInfo.get(i + " " + (j-1) ).equals("horizontal")) && (tilesInfo.get((i+1) + " " + j).equals("grass") && tilesInfo.get((i-1) + " " + j).equals("vertical"))) {
                        btns[i][j].setIcon(uptoleftImg);
                        tilesInfo.put(btns[i][j].getCo(), "upleft");

                    }
                    // up right turn
                    else if ((tilesInfo.get(i + " " + (j+1) ).equals("horizontal") && tilesInfo.get(i + " " + (j-1) ).equals("grass")) && (tilesInfo.get((i+1) + " " + j).equals("grass") && tilesInfo.get((i-1) + " " + j).equals("vertical"))) {
                        btns[i][j].setIcon(uptorightImg);
                        tilesInfo.put(btns[i][j].getCo(), "upright");

                    }
                    //down left turn
                    else if ((tilesInfo.get(i + " " + (j+1) ).equals("grass") && tilesInfo.get(i + " " + (j-1) ).equals("horizontal")) && (tilesInfo.get((i+1) + " " + j).equals("vertical") && tilesInfo.get((i-1) + " " + j).equals("grass"))) {
                        btns[i][j].setIcon(lefttodownImg);
                        tilesInfo.put(btns[i][j].getCo(), "leftdown");

                    }
                    // down right turn
                    else if ((tilesInfo.get(i + " " + (j+1) ).equals("horizontal") && tilesInfo.get(i + " " + (j-1) ).equals("grass")) && (tilesInfo.get((i+1) + " " + j).equals("vertical") && tilesInfo.get((i-1) + " " + j).equals("grass"))) {
                        btns[i][j].setIcon(righttodownImg);
                        tilesInfo.put(btns[i][j].getCo(), "rightdown");
                    }
                }catch (Exception ignored) {}

            }
        }

    }
}
