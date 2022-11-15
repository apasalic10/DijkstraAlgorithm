package ba.unsa.etf.rpr;

public class App 
{
    public static void main( String[] args )
    {
        try{
            System.out.println("Unesite izraz koji želite izračunati '(Unos sa razmacima izmedju)' : ");
            ExpressionEvaluator expEval = new ExpressionEvaluator();
            if(args[0] == null){
                System.out.println("Unijeli ste prazan string!");
            }
            else{
                System.out.println(expEval.evaluate(args[0]));
            }
        }
        catch (RuntimeException e ){
            System.out.println(e.getMessage());
        }
    }
}
