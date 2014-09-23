import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by OverMind on 14.05.14.
 */
public class WaveTracer {
    public static final int OBSTACLE = 255;
    public static final int UNDEFINED = 99;
    public static final int DEST = 0;
    private static final int SOURCE = 254;
    private int[][] waveArray;
    private int width;
    private int height;

    public boolean isMoveAvailable(Cell[][] field, int sourceX, int sourceY, int destX, int destY) {
        waveArray = createWaveArrayFrom(field);
        Coord source = new Coord(sourceX,sourceY);
        Coord dest   = new Coord(destX,destY);
        boolean result = trace(waveArray,source,dest);
        return result;
    }

    int [][] createWaveArrayFrom(Cell[][] field){
        width = field.length;
        height= field[0].length;
        int [][] waveArray = new int [width][height] ;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                waveArray[i][j]= field[i][j].isCellContainsBall() ? OBSTACLE : UNDEFINED;
            }
        }
        return waveArray;
    }

    boolean trace(int[][] waveArray, Coord source, Coord dest) {

        Deque<Coord> deque = new LinkedList<Coord>();
        deque.addLast(dest);
        dest.setVal(DEST);
        source.setVal(SOURCE);

        while (!deque.isEmpty()){
            Coord currentCoord = deque.pollFirst();
            for (int i = 0; i < 4 ; i++) {
                Coord neighborCoord = currentCoord.getNeighborCoord(i);
                if (isCoordIsCorect(neighborCoord)){
                    if (neighborCoord.equals(source)){
                        return true;
                    }
                    if (neighborCoord.getVal() > currentCoord.getVal() + 1){
                        neighborCoord.setVal(currentCoord.getVal()+1);
                        deque.addLast(neighborCoord);
                    }
                }
            }
        }
        return false;
    }

    boolean isCoordIsCorect(Coord coord){
        return coord.x >= 0 && coord.x < width && coord.y >= 0 && coord.y < height && coord.getVal() != OBSTACLE;
    }



    public class Coord {
        public static final int COLUMN_X = 0;
        public static final int COLUMN_Y = 1;
        int x;
        int y;

        int [][] moveMatrix = {
                { 1,  0},
                { 0, -1},
                {-1,  0},
                { 0,  1}
        };

        Coord(int x, int y){
            this.x = x;
            this.y = y;
        }


        public Coord getNeighborCoord(int i) {
            return new Coord(x+moveMatrix[i][COLUMN_X], y+moveMatrix[i][COLUMN_Y]);
        }

        public int getVal() {
            return waveArray[x][y];
        }

        public void setVal(int val) {
            waveArray[x][y] = val;
        }

        public boolean equals(Coord another) {
            return this.x == another.x && this.y == another.y ;
        }
    }


}