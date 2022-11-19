package ba.unsa.etf.rpr;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * a class that tests the ExpressionEvaluator class
 */
public class ExpressionEvaulatorTest {

    /**
     * method that tests the addition operator
     */
    @Test
    void additionOperatorTest(){
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertEquals(15,expEval.evaluate("( 1 + ( 3 + ( 5 + 6 ) ) )"));
    }

    /**
     * method that tests the subtraction operator
     */
    @Test
    void subtractionOperatorTest(){
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertEquals(9,expEval.evaluate("( 10 - ( 4 - 3 ) )"));
    }

    /**
     * method that tests the multiplication operator
     */
    @Test
    void multiplicationOperatorTest(){
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertEquals(60,expEval.evaluate("( 10 * ( 3 * 2 ) )"));
    }

    /**
     * method that tests the division operator
     */
    @Test
    void divisionOperatorTest(){
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertEquals(30,expEval.evaluate("( 60 / ( 10 / 5 ) )"));
    }

    /**
     * method that tests the sqrt operator
     */
    @Test
    void sqrtOperatorTest(){
        ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertEquals(5,expEval.evaluate("( 1 + sqrt ( 16 ) )"));
    }

    /**
     * method that tests whether the "evaluate" method throws an exception if division by zero occurs
     */
    @Test
    void ilegalArgumentTest(){
        final ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expEval.evaluate("( 60 / ( 10 / 0 ) )"), "Ilegalan argument za dijeljenje!" );
    }

    /**
     * method that tests whether the "evaluate" method throws an exception if the input isn't valid
     */
    @Test
    void invalidInput(){
        final ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expEval.evaluate("( 60 / ( 10x / 5 ) )"), "Unos nije validan!" );
    }

    /**
     * method that tests whether the "evaluate" method throws an exception if the input isn't valid
     */
    @Test
    void invalidInput1(){
        final ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expEval.evaluate("( 1 + ( 5 * 20))"), "Unos nije validan!" );
    }

    /**
     * method that tests whether the "evaluate" method throws an exception if the input isn't valid
     */
    @Test
    void invalidInput2(){
        final ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expEval.evaluate("( 1 + ( 5 * 20 ) + ( 10 + 2 ) )"), "Unos nije validan!" );
    }

    /**
     * method that tests whether the "evaluate" method throws an exception if the input is null
     */
    @Test
    void ilegalArgumentTest2(){
        final ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expEval.evaluate(null), "Uneseni string je prazan!" );
    }

    /**
     * method that tests whether the "evaluate" method throws an exception if the input isn't valid
     */
    @Test
    void invalidInputSqrt(){
        final ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expEval.evaluate("( 1 + sqrt 3 )"), "Unos nije validan!" );
    }

















}
