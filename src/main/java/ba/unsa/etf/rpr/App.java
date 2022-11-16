package ba.unsa.etf.rpr;

public class App 
{
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
