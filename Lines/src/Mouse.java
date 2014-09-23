import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by OverMind on 13.05.14.
 */
public class Mouse extends MouseAdapter {

    private int x;
    private int y;
    Game game;

    public Mouse(Game game){
        this.game = game;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        x = e.getX()/Render.SCALE;
        y = e.getY()/Render.SCALE;
        game.cellSelected(x,y);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x = e.getX()/Render.SCALE;
        y = e.getY()/Render.SCALE;
        game.makeMoveOrSelect(x, y);
    }

}
