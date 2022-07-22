package display;
import java.util.Arrays;

public class RouteAlgo {

    //must be static because it doesn't need object to be initialized.
    public static String[][] tiles_info = new String[10][20];
    public static int source = 0;
    public static int sink = 0;
    public static int junctions = 0;
    public static int roads = 0;
    public static int[] getRoute(){
        int itemsource = 0;
        int itemsink = 0;
        int[][] locsource = new int[source][];
        int[][] locsink = new int[sink][];
        int[] distances = new int[sink*source];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if (tiles_info[i][j] == "source"){
                    locsource[itemsource] = new int[]{i, j};
                    itemsource++;
                }
                else if (tiles_info[i][j] == "sink"){
                    locsink[itemsink] = new int[]{i, j};
                    itemsink++;
                }
            }
        }
        int numb = 0;
        for(int y=0;y<source;y++){
            for(int i=0;i<sink;i++){
                ShortestPath SP = new ShortestPath();
                int dist = SP.findShortestPathLength(tiles_info, locsource[y], locsink[i]);
                distances[numb] = dist;
                numb++;
            }
        }
        //debug
        for(int jef :distances) {
            System.out.println(jef);
        }
        int[] temp = {Arrays.stream(distances).min().getAsInt(),Arrays.stream(distances).max().getAsInt()};
        return temp;
    }
}
