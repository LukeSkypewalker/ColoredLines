import org.junit.Test;

import static org.junit.Assert.*;

/**
* Created by OverMind on 15.05.14.
*/
public class WaveTracerTest {
    @Test
    public void testIsMoveAvailable() throws Exception {
        //given
        WaveTracer waveTracer = new WaveTracer();
        Cell [][] field = {
                {new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(2,6)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(2,6)), new Cell(new Ball(2,6)), new Cell(new Ball(0,0))},
        };
        WaveTracer.Coord start =waveTracer.new Coord(3, 2);
        WaveTracer.Coord targetPossible = waveTracer.new Coord(2,0);
        WaveTracer.Coord targetImpossible = waveTracer.new Coord(0,0);

        //when and then
        assertTrue(waveTracer.isMoveAvailable(field, start.x, start.y, targetPossible.x, targetPossible.y));
        assertFalse(waveTracer.isMoveAvailable(field, start.x, start.y, targetImpossible.x, targetImpossible.y));
    }
}
