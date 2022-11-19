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
    public static void main( String[] args ) {
        try{
            ExpressionEvaluator expEval = new ExpressionEvaluator();
            double rezultat = Math.round(expEval.evaluate(args[0]) * 100. )/100.;
            System.out.println("Rezultat unesenog izraza je: " + rezultat);
        }
        catch (RuntimeException e ){
            System.out.println(e.getMessage());
        }
    }
}
