package ba.unsa.etf.rpr;

/**
 * App is the main class of the project
 */
public class App 
{
    /**
     * main method of the project
     * @param args is array of strings sent from cmd, of which the first string is calculated via ExpressionEvaluator
     */
    public static void main( String[] args )
    {
        try{
            ExpressionEvaluator expEval = new ExpressionEvaluator();
            System.out.println(Math.round(expEval.evaluate(args[0]) * 100. )/100.);
        }
        catch (RuntimeException e ){
            System.out.println(e.getMessage());
        }
    }
}
