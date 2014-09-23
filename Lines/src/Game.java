import java.util.Random;
import java.util.logging.Logger;

public class Game {
    public static final int numOfFutureBalls = 3;
    private int gameScore;

    FieldProcessor fieldProcessor = new FieldProcessor();
    WaveTracer wave = new WaveTracer();

    Logger logger = Logger.getLogger(Game.class.getName());
    Random random = new Random();

    final static int widthSize=12;
    final static int heightSize=9;

    Cell [][] field;

    public static final int NOT_SELECTED = -1;
    int activeCellX = NOT_SELECTED;
    int activeCellY = NOT_SELECTED;

    Game() {
        this.field = new Cell [widthSize][heightSize];
        for (int i=0; i<widthSize; i++) {
            for (int j=0; j<heightSize; j++) {
                field[i][j] = new Cell(i,j);
            }
        }
        placeBalls(5,Ball.NEW_BALL);
        placeBalls(3, Ball.FUTURE_BALL);

        gameScore=0;
    }



    void cellSelected(int i, int j) {
        if (isCellContainsBall(i, j)) {
            activeCellchange(i, j);
        }
    }

    boolean isCellContainsBall(int i, int j) {
        return field[i][j].isCellContainsBall();
    }

    void makeMoveOrSelect(int i, int j) {
        if (field[i][j].isCellContainsBall()) {
            activeCellchange(i, j);
            return;
        }

        if (activeCellX == NOT_SELECTED) {
            return;
        }

        if (wave.isMoveAvailable(field, activeCellX, activeCellY, i, j)){
            makeMove(i, j);
        }
    }

    void makeMove(int x, int y) {
        field[x][y].ball = field[activeCellX][activeCellY].ball;
        field[x][y].setBallState(Ball.INACTIVE_BALL);

        field[activeCellX][activeCellY].ball=null;

        activeCellX = NOT_SELECTED;
        activeCellY = NOT_SELECTED;

        boolean isLineRemoved = fieldProcessor.checkField(field);
        if ( !isLineRemoved) {
            placeNewBalls();
            fieldProcessor.checkField(field);
        }
        calculateScores();
        wave.createWaveArrayFrom(field);
    }

    void activeCellchange(int i, int j) {
        if (isActiveCellSelected()){
            field[activeCellX][activeCellY].setBallState(Ball.INACTIVE_BALL);
        }
        field[i][j].setBallState(Ball.ACTIVE_BALL);
        activeCellX=i;
        activeCellY=j;
    }

    private boolean isActiveCellSelected() {
        return activeCellX > NOT_SELECTED;
    }

    void placeNewBalls() {
        int remaningFutureBalls = calculateRemaningFutureBallsAndMakeThemNEW();
//        placeBalls(numOfFutureBalls -remaningFutureBalls, Ball.NEW_BALL);
        placeBalls(numOfFutureBalls, Ball.FUTURE_BALL);
    }

    int calculateRemaningFutureBallsAndMakeThemNEW(){
        int remainingFutureBallsAmount=0;
        for (int i=0; i<widthSize; i++) {
            for (int j=0; j<heightSize; j++) {
                if(field[i][j].getBallState() == Ball.FUTURE_BALL){
                    remainingFutureBallsAmount++;
                    field[i][j].setBallState(Ball.NEW_BALL);
                }
            }
        }
        return remainingFutureBallsAmount;
    }

    void placeBalls(int n, int state) {
        for (int i=0; i<n; i++) {
            placeBallOnEmptySpace(state);
        }
    }

    void placeBallOnEmptySpace(int state) {
        boolean isPlaced=false;
        do {
            int i = random.nextInt(widthSize);
            int j = random.nextInt(heightSize);

            if (field[i][j].getBallState() == 0) {
                field[i][j].ball=new Ball(state);
                isPlaced=true;
            }
        }
        while (!isPlaced);
    }



    void updateCells(){
        for (int i=0; i<widthSize; i++) {
            for (int j=0; j<heightSize; j++) {
                if (field[i][j].ball !=null){
                    field[i][j].ball.porcessBalls();
                }
            }
        }
    }

    void calculateScores(){
        int markedForDelete = 0;
        for (int i=0; i<widthSize; i++) {
            for (int j=0; j<heightSize; j++) {
                if (field[i][j].ball !=null){
                    if (field[i][j].ball.ballState==Ball.MARKED_FOR_REMOVE){
                        markedForDelete++;
                    }
                }
            }
        }
        if (markedForDelete>0){
            int bonus = (int) (4+Math.pow(markedForDelete - 4, 3));
            gameScore+=bonus;
            logger.info(gameScore + "");
        }
    }

}
