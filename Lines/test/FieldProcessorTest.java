import org.junit.Assert;
import org.junit.Test;

/**
 * Created by OverMind on 10.01.14.
 */
public class FieldProcessorTest {

    @Test
    public void Field_simple_square5x5_vertical_raw() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4))},
                {new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,3)), new Cell(new Ball(2,4))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,3)), new Cell(new Ball(2,4))},
                {new Cell(new Ball(2,5)), new Cell(new Ball(2,5)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4))},
        };

        Cell [][] refArr = {
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,4)), new Cell(new Ball(5,4))},
                {new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,3)), new Cell(new Ball(5,4))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,3)), new Cell(new Ball(5,4))},
                {new Cell(new Ball(2,5)), new Cell(new Ball(2,5)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(5,4))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(5,4))},
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkField(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }


    @Test
    public void Field_advanced_square6x6_cross_raws() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4))},
                {new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,5))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,3)), new Cell(new Ball(2,4)), new Cell(new Ball(2,6))},
                {new Cell(new Ball(2,5)), new Cell(new Ball(2,5)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,7))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,8))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,9))}
        };

        Cell [][] refArr = {
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,4)), new Cell(new Ball(5,4)), new Cell(new Ball(2,4))},
                {new Cell(new Ball(5,4)), new Cell(new Ball(5,4)), new Cell(new Ball(5,4)), new Cell(new Ball(5,4)), new Cell(new Ball(5,4)), new Cell(new Ball(2,5))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,3)), new Cell(new Ball(5,4)), new Cell(new Ball(2,6))},
                {new Cell(new Ball(2,5)), new Cell(new Ball(2,5)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(5,4)), new Cell(new Ball(2,7))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(5,4)), new Cell(new Ball(2,8))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(5,4)), new Cell(new Ball(2,9))}
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkField(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }


    @Test
    public void Field_advanced_rectangle_cross() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4))},
                {new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,3)), new Cell(new Ball(2,4)), new Cell(new Ball(2,6))},
                {new Cell(new Ball(2,5)), new Cell(new Ball(2,5)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,7))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(2,4)), new Cell(new Ball(2,8))}
        };

        Cell [][] refArr = {
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,4)), new Cell(new Ball(5,4)), new Cell(new Ball(2,4))},
                {new Cell(new Ball(5,4)), new Cell(new Ball(5,4)), new Cell(new Ball(5,4)), new Cell(new Ball(5,4)), new Cell(new Ball(5,4)), new Cell(new Ball(5,4))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(0,0)), new Cell(new Ball(2,3)), new Cell(new Ball(5,4)), new Cell(new Ball(2,6))},
                {new Cell(new Ball(2,5)), new Cell(new Ball(2,5)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(5,4)), new Cell(new Ball(2,7))},
                {new Cell(new Ball(2,3)), new Cell(new Ball(2,3)), new Cell(new Ball(3,7)), new Cell(new Ball(2,4)), new Cell(new Ball(5,4)), new Cell(new Ball(2,8))}
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkField(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }


    @Test
    public void Field_diagonal_simple_square() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1))}
        };

        Cell [][] refArr = {
                {new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1))}
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkDiagonals(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }

    @Test
    public void diagonal_width() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))}
        };

        Cell [][] refArr = {
                {new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))}
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkDiagonals(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }

    @Test
    public void diagonal_width_secondary() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))}
        };

        Cell [][] refArr = {
                {new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))}
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkDiagonals(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }
    
    @Test
    public void FullCheckTest() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(2,6)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,6)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(2,6)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(2,6)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(2,6)), new Cell(new Ball(0,0)), new Cell(new Ball(2,6)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7))},
                {new Cell(new Ball(2,6)), new Cell(new Ball(2,6)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(2,6)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7))},
                {new Cell(new Ball(2,6)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(2,6)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))}
        };

        Cell [][] refArr = {
                {new Cell(new Ball(5,6)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,6)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(5,6)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(5,6)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(5,6)), new Cell(new Ball(0,0)), new Cell(new Ball(5,6)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7))},
                {new Cell(new Ball(5,6)), new Cell(new Ball(5,6)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(5,6)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7))},
                {new Cell(new Ball(5,6)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(5,6)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))}
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkField(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }









    @Test
    public void FullCheckTest_bug1() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
        };

        Cell [][] refArr = {
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,7)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkField(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }

    @Test
    public void FullCheckTest_bug2() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(2,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(2,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
        };

        Cell [][] refArr = {
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(5,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(5,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,9)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkField(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }

    @Test
    public void FullCheckTest_bug3_setBallState() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(0,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
        };

        Cell [][] refArr = {
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(0,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkField(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }

    @Test
    public void FullCheckTest_bug4_outOfBoundException() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(0,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
        };

        Cell [][] refArr = {
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(0,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
                {new Cell(new Ball(2,1))},
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkField(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }

    @Test
    public void diagonal_height() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0))}
        };

        Cell [][] refArr = {
                {new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0))}
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkDiagonals(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }

    @Test
    public void Field_diagonals_height() throws Exception {
        //given
        Cell [][] field = {
                {new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(2,1)), new Cell(new Ball(0,0))}
        };

        Cell [][] refArr = {
                {new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0))},
                {new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(0,0)), new Cell(new Ball(5,1)), new Cell(new Ball(0,0))}
        };

        FieldProcessor fieldProcessor = new FieldProcessor();

        //when
        fieldProcessor.checkDiagonals(field);

        //then
        for (int i = 0; i < field.length ; i++) {
            for (int j = 0; j < field[0].length; j++) {
                Assert.assertEquals(refArr[i][j].getBallState(), field[i][j].getBallState());
                Assert.assertEquals(refArr[i][j].getColor(),  field[i][j].getColor());
            }
        }
    }

}
