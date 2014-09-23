import java.awt.*;
import java.util.logging.Logger;

public class Cell{

    Logger logger = Logger.getLogger(Cell.class.getName());

    int x;
    int y;

    Ball ball;


    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    Cell(Ball ball){
        this.ball = ball;
    }

    public boolean isCellContainsBall(){
        return ball != null && ball.isBallExist();
    }


    public Color getBallColor() {
        if (ball == null) return null;
        return ball.getBallColor();
    }

    public int getBallState() {
        return ball != null ? ball.ballState : 0;
    }

    public int getBallSize() {
        return ball != null ?ball.ballSize : 0;
    }

    public void setBallState(int state) {
        if (ball == null){
            logger.warning(x + " " + y );
        }
        ball.ballState=state;
    }

    public int getColor() {
        return ball != null ? ball.getColor() : 0;
    }
}