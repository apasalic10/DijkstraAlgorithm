package ba.unsa.etf.rpr;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ExpressionEvaulatorTest {

    @Test
    void additionOperatorTest(){
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertEquals(15,expEval.evaluate("( 1 + ( 3 + ( 5 + 6 ) ) )"));
    }

    @Test
    void subtractionOperatorTest(){
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertEquals(9,expEval.evaluate("( 10 - ( 4 - 3 ) )"));
    }

    @Test
    void multiplicationOperatorTest(){
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertEquals(60,expEval.evaluate("( 10 * ( 3 * 2 ) )"));
    }






}
