import java.awt.*;
import java.util.Random;

/**
 * Created by OverMind on 14.05.14.
 */
public class Ball {
    Random random = new Random();

    //TODO implement state machine
    public static final int EMPTY = 0;
    public static final int FUTURE_BALL = 1;
    public static final int NEW_BALL = 2;
    public static final int INACTIVE_BALL = 3;
    public static final int ACTIVE_BALL = 4;
    public static final int MARKED_FOR_REMOVE = 5;
    public static final int REMOVING = 6;

    public static final Color [] colArr = {
            new Color(255, 0, 0),   new Color(0, 255, 0),
            new Color(0, 100, 255), new Color(255, 255, 0),
            new Color(255, 0, 255), new Color(0, 255, 255)
    };

    int ballColor;
    int ballState;
    int ballSize;

    int animationStep=0;
    int dir=1;

    Ball (int state, int color){
        this.ballState=state;
        this.ballColor=color;
    }

    public Ball() {
    }

    public Ball(int state) {
        this.ballState=state;
        this.ballColor = random.nextInt(colArr.length);
    }

    public boolean isBallExist() {
            return ( ballState == NEW_BALL
                    | ballState == ACTIVE_BALL
                    | ballState == INACTIVE_BALL
                    | ballState == MARKED_FOR_REMOVE);
    }

    //TODO process case - ball didn't exist
    public int getColor(){
        return ballColor;
    }

    public Color getBallColor(){
        return colArr[getColor()];
    }

    //TODO if 5th ball appears - it will be removed too fast
    public void porcessBalls(){

        switch(ballState){

            case FUTURE_BALL:
                ballSize=30;
                break;

            case NEW_BALL:
                ballSize++;
                //TODO if ball was selected till growing -problem!
                if (ballSize == 100) ballState = INACTIVE_BALL;
                break;

            case MARKED_FOR_REMOVE:
                ballState = REMOVING;
                break;

            case REMOVING:
                if (ballSize > 0) ballSize--;
                else if (ballSize == 0) ballState = EMPTY;
                break;

            case ACTIVE_BALL:
                if (animationStep>15) {
                    dir=-1;
                } else if (animationStep<-15) {
                    dir=1;
                }
                animationStep+=dir;
                ballSize = 100 +animationStep;
                break;

            case INACTIVE_BALL:
                if (ballSize>100) ballSize--;
                if (ballSize<100) ballSize++;
                break;

            default:
                ballSize=100;
        }
    }
}
