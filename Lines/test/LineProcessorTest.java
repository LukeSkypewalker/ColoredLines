import org.junit.Assert;
import org.junit.Test;

/**
 * Created by OverMind on 10.01.14.
 */
public class LineProcessorTest {

    @Test
    public void line_advanced_match1() throws Exception {
        //given
        Cell [] testArr = {
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,4))
        };
        Cell [] refArr  = {
                new Cell(new Ball(5,3)),
                new Cell(new Ball(5,3)),
                new Cell(new Ball(5,3)),
                new Cell(new Ball(5,3)),
                new Cell(new Ball(5,3)),
                new Cell(new Ball(2,4))
        };
        LineProcessor lineProcessor = new LineProcessor();

        //when
        boolean isFound = lineProcessor.checkLine(testArr);

        //then
        Assert.assertTrue(isFound);
        for (int i = 0; i < testArr.length; i++) {
            Assert.assertEquals(refArr[i].getBallState(), testArr[i].getBallState());
            Assert.assertEquals(refArr[i].getColor(), testArr[i].getColor());
        }
    }

    @Test
    public void line_should_not_match() throws Exception {
        //given
        Cell [] testArr = {
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,4)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,3)),
                new Cell(new Ball(2,4))
        };
        Cell [] refArr  = {
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,4)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,3)),
                new Cell(new Ball(2,4))
        };
        LineProcessor lineProcessor = new LineProcessor();

        //when
        boolean isFound = lineProcessor.checkLine(testArr);

        //then
        Assert.assertFalse(isFound);
        for (int i = 0; i < testArr.length; i++) {
            Assert.assertEquals(refArr[i].getBallState(), testArr[i].getBallState());
            Assert.assertEquals(refArr[i].getColor(), testArr[i].getColor());
        }
    }

    @Test
    public void line_should_not_match_2() throws Exception {
        //given
        Cell [] testArr = {
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3))
        };
        Cell [] refArr  = {
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3))
        };
        LineProcessor lineProcessor = new LineProcessor();

        //when
        boolean isFound = lineProcessor.checkLine(testArr);

        //then
        Assert.assertFalse(isFound);
        for (int i = 0; i < testArr.length; i++) {
            Assert.assertEquals(refArr[i].getBallState(), testArr[i].getBallState());
            Assert.assertEquals(refArr[i].getColor(), testArr[i].getColor());
        }
    }

    @Test
    public void line_should_not_match_ref_color_from_empty() throws Exception {
        //given
        Cell [] testArr = {
                new Cell(new Ball(0,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,3)),
                new Cell(new Ball(0,3))
        };
        Cell [] refArr  = {
                new Cell(new Ball(0,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,3)),
                new Cell(new Ball(0,3))
        };
        LineProcessor lineProcessor = new LineProcessor();

        //when
        boolean isFound = lineProcessor.checkLine(testArr);

        //then
//        Assert.assertFalse(isFound);
        for (int i = 0; i < testArr.length; i++) {
            Assert.assertEquals(refArr[i].getBallState(), testArr[i].getBallState());
            Assert.assertEquals(refArr[i].getColor(), testArr[i].getColor());
        }
    }

    @Test
    public void line_advanced_double_match() throws Exception {
        //given
        Cell [] testArr = {
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,0)),
                new Cell(new Ball(2,4)),
                new Cell(new Ball(2,4)),
                new Cell(new Ball(2,4)),
                new Cell(new Ball(2,4)),
                new Cell(new Ball(2,4)),
                new Cell(new Ball(2,4)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,0)),
                new Cell(new Ball(2,5)),
                new Cell(new Ball(2,5)),
                new Cell(new Ball(2,5)),
                new Cell(new Ball(2,5)),
                new Cell(new Ball(2,5)),
                new Cell(new Ball(2,5)),
                new Cell(new Ball(2,5)),
                new Cell(new Ball(2,4)),
                new Cell(new Ball(2,3))
        };

        Cell [] refArr = {
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,0)),
                new Cell(new Ball(5,4)),
                new Cell(new Ball(5,4)),
                new Cell(new Ball(5,4)),
                new Cell(new Ball(5,4)),
                new Cell(new Ball(5,4)),
                new Cell(new Ball(5,4)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(2,3)),
                new Cell(new Ball(0,0)),
                new Cell(new Ball(5,5)),
                new Cell(new Ball(5,5)),
                new Cell(new Ball(5,5)),
                new Cell(new Ball(5,5)),
                new Cell(new Ball(5,5)),
                new Cell(new Ball(5,5)),
                new Cell(new Ball(5,5)),
                new Cell(new Ball(2,4)),
                new Cell(new Ball(2,3))
        };
        LineProcessor lineProcessor = new LineProcessor();

        //when
        boolean isFound = lineProcessor.checkLine(testArr);

        //then
        Assert.assertTrue(isFound);
        for (int i = 0; i < testArr.length; i++) {
            Assert.assertEquals(refArr[i].getBallState(), testArr[i].getBallState());
            Assert.assertEquals(refArr[i].getColor(),  testArr[i].getColor());
        }
    }

}
