package display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import statistics.*;

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
    public void actionPerformed(ActionEvent e) {;
        for(int i=0; i<10; i++ ) {
            for(int j=0; j<20; j++) {

                // checking Junctions
                try {
                    // junction 4way
                    if (RouteAlgo.tiles_info[i][j+1] == "-" && RouteAlgo.tiles_info[i][j-1] == "-" && RouteAlgo.tiles_info[i+1][j] == "|" && RouteAlgo.tiles_info[i-1][j] == "|") {
                        btns[i][j].setIcon(junctionImg);
                        RouteAlgo.tiles_info[i][j] = "+";

                    }
                    // t junction downwards
                    else if (RouteAlgo.tiles_info[i][j+1] == "-" && RouteAlgo.tiles_info[i][j-1] == "-" && RouteAlgo.tiles_info[i+1][j] == "|" && RouteAlgo.tiles_info[i-1][j] == "x") {
                            btns[i][j].setIcon(tdownImg);
                        RouteAlgo.tiles_info[i][j] = "T";

                    }
                    // t junction upwards
                    else if (RouteAlgo.tiles_info[i][j+1] == "-" && RouteAlgo.tiles_info[i][j-1] == "-" && RouteAlgo.tiles_info[i+1][j] == "x" && RouteAlgo.tiles_info[i-1][j] == "|") {
                        btns[i][j].setIcon(tupImg);
                        RouteAlgo.tiles_info[i][j] = "^";

                    }
                    //t junction right
                    else if (RouteAlgo.tiles_info[i][j+1] == "-" && RouteAlgo.tiles_info[i][j-1] == "x" && RouteAlgo.tiles_info[i+1][j] == "|" && RouteAlgo.tiles_info[i-1][j] == "|") {
                        btns[i][j].setIcon(trightImg);
                        RouteAlgo.tiles_info[i][j] = "}";

                    }
                    //t junction left
                    else if (RouteAlgo.tiles_info[i][j+1] == "x" && RouteAlgo.tiles_info[i][j-1] == "-" && RouteAlgo.tiles_info[i+1][j] == "|" && RouteAlgo.tiles_info[i-1][j] == "|") {
                        btns[i][j].setIcon(tleftImg);
                        RouteAlgo.tiles_info[i][j] = "{";

                    }
                    //up left turn
                    else if (RouteAlgo.tiles_info[i][j+1] == "x" && RouteAlgo.tiles_info[i][j-1] == "-" && RouteAlgo.tiles_info[i+1][j] == "x" && RouteAlgo.tiles_info[i-1][j] == "|") {
                        btns[i][j].setIcon(uptoleftImg);
                        RouteAlgo.tiles_info[i][j] = "J";

                    }
                    // up right turn
                    else if (RouteAlgo.tiles_info[i][j+1] == "-" && RouteAlgo.tiles_info[i][j-1] == "x" && RouteAlgo.tiles_info[i+1][j] == "x" && RouteAlgo.tiles_info[i-1][j] == "|") {
                        btns[i][j].setIcon(uptorightImg);
                        RouteAlgo.tiles_info[i][j] = "L";

                    }
                    //down left turn
                    else if (RouteAlgo.tiles_info[i][j+1] == "x" && RouteAlgo.tiles_info[i][j-1] == "-" && RouteAlgo.tiles_info[i+1][j] == "|" && RouteAlgo.tiles_info[i-1][j] == "x") {
                        btns[i][j].setIcon(lefttodownImg);
                        RouteAlgo.tiles_info[i][j] = "1";

                    }
                    // down right turn
                    else if (RouteAlgo.tiles_info[i][j+1] == "-" && RouteAlgo.tiles_info[i][j-1] == "x" && RouteAlgo.tiles_info[i+1][j] == "|" && RouteAlgo.tiles_info[i-1][j] == "x") {
                        btns[i][j].setIcon(righttodownImg);
                        RouteAlgo.tiles_info[i][j] = "F";
                    }
                }catch (Exception ignored) {}
            }
        }

    }
}
