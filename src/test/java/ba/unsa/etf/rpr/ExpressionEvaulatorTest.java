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

    @Test
    void divisionOperatorTest(){
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertEquals(30,expEval.evaluate("( 60 / ( 10 / 5 ) )"));
    }

    @Test
    void sqrtOperatorTest(){
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertEquals(5,expEval.evaluate("( 1 + ( sqrt 16 ) )"));
    }










}