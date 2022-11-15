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

    @Test
    void IlegalArgumentTest(){
        final ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expEval.evaluate("( 60 / ( 10 / 0 ) )"), "Ilegalan argument za dijeljenje!" );
    }

    @Test
    void IlegalArgumentTest1(){
        final ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expEval.evaluate("( 60 / ( 10x / 5 ) )"), "Unos nije validan!" );
    }

    @Test
    void IlegalArgumentTest2(){
        final ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expEval.evaluate("( 1 + ( 5* 20))"), "Unos nije validan!" );
    }

    @Test
    void IlegalArgumentTest3(){
        final ExpressionEvaluator expEval = new ExpressionEvaluator();
        assertThrows(RuntimeException.class, () -> expEval.evaluate("( 1 + ( 5 * 20 ) + ( 10 + 2 ) )"), "Unos nije validan!" );
    }















}
