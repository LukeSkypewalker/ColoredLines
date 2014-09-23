import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;


public class Render extends JPanel implements ActionListener {

    private Timer timer;
    Game game;

    int gameWidth;
    int gameHeight;

    int widthSize;
    int heightSize;


    int cellSize;
    int ballStandartSize;
    float stepSize;
    public static final int SCALE = 100;
    Color backgroundColor  = new Color(64, 64, 64);
    private Graphics2D g;

    public Render(Game game, int gameWidth, int gameHeight) {

        Mouse ma = new Mouse(game);
        addMouseMotionListener(ma);
        addMouseListener(ma);
        setDoubleBuffered(true);

        this.game = game;
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        this.widthSize = game.widthSize;
        this.heightSize = game.heightSize;

        cellSize = gameWidth/widthSize;
        ballStandartSize = (int)( cellSize*0.8 );
        stepSize = (float)(ballStandartSize)/80;
        setBackground(backgroundColor);

        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.g = (Graphics2D) g;

        this.g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        this.g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        game.updateCells();
        drawGame();
    }


    int getCellSize(){
        return cellSize;
    }

    //TODO show scores
    void drawGame(){
        drawGrid();
        drawCells();
    }


    void drawGrid(){
        g.setColor(new Color(255, 255, 0));
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for(int i=1; i<widthSize; i++){
            g.drawLine( (gameWidth/widthSize) * i, 0,  (gameWidth/widthSize)*i, gameHeight );
        }
        for(int i=1; i<heightSize; i++){
            g.drawLine( 0, (gameHeight/heightSize) * i,  gameWidth, (gameHeight/heightSize)*i );
        }
    }


    void drawCells(){
        for (int i=0; i<widthSize; i++){
            for (int j=0; j<heightSize; j++){
                drawCell(i,j);
            }
        }
    }

    void drawCell (int i, int j){
        if (game.field[i][j].getBallState() != Ball.EMPTY){
            drawBall(i,j);
        }
    }

    void drawBall(int i,int j){
        Color ballColor = game.field[i][j].getBallColor();
        g.setColor(ballColor) ;
        int x = i*cellSize + cellSize/2;
        int y = j*cellSize + cellSize/2;
        float d = ballStandartSize * ((float) game.field[i][j].getBallSize() / 100 );
        float r = d/2;

        Ellipse2D ellipse = new Ellipse2D.Float();
        ellipse.setFrameFromCenter(x,y,x+r,y+r) ;
        GradientPaint gradient = new GradientPaint(x+r/1.4f,y-r/1.4f,ballColor,x-r, y+r,Color.BLACK);
        g.setPaint(gradient);
        g.fill(ellipse);
    }

}

