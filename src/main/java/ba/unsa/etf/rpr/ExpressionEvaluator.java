package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * the class in which the expression is evaluated
 */
public class ExpressionEvaluator {

    /**
     * attribute that preserves operators from expressions
     */
    private final Stack<String> operators = new Stack<>();

    /**
     * attribute that preserves operands from expressions
     */
    private final Stack<Double> operands = new Stack<>();

    /**
     * method that checks if a binary operator
     * @param str is the string to be checked
     * @return true or false depending on whether the string parameter is a binary operator
     */
    private boolean isBinaryOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    /**
     * method that checks if a unary operator
     * @param str is the string to be checked
     * @return true or false depending on whether the string parameter is a binary operator
     */
    private boolean isUnaryOperator(String str){
        return str.equals("sqrt");
    }

    /**
     * method that calculates the given string
     * @param str is the expression calculated by the method
     * @return the result of the expression
     * @throws RuntimeException if the input string is not entered correctly
     * ,if an expression containing division by zero is entered and
     * if the expression being evaluated is null
     *
     */
    public Double evaluate(String str) throws RuntimeException{
       try{
           String[] splits = str.split(" ");

           for(String x : splits){
               if(x.equals("(")) {}
               else if(x.equals(")")){

                   String operacija = operators.pop();
                   if(isBinaryOperator(operacija)){

                       double a =operands.pop();
                       double b = operands.pop();

                       switch (operacija) {
                           case "+": {
                               double rez = a + b;
                               operands.push(rez);
                               break;
                           }
                           case "-": {
                               double rez = b - a;
                               operands.push(rez);
                               break;
                           }
                           case "*": {
                               double rez = a * b;
                               operands.push(rez);
                               break;
                           }
                           case "/": {
                               if(a == 0){
                                   throw new RuntimeException("Ilegalan argument za dijeljenje!");
                               }
                               double rez = b / a;
                               operands.push(rez);
                               break;
                           }
                       }

                   }
                   else{
                       double a =operands.pop();
                       double rez = Math.sqrt(a);
                       operands.push(rez);
                   }
               }
               else if(isBinaryOperator(x) || isUnaryOperator(x)){
                   operators.push(x);
               }
               else{
                   try{
                       operands.push(Double.parseDouble(x));
                   }
                   catch (NumberFormatException e){
                       throw new RuntimeException("Unos nije validan!");
                   }
               }
           }

           if(!operators.isEmpty() || operands.size() != 1){
               throw new RuntimeException("Unos nije validan!");
           }

           return operands.pop();
       }
       catch (NullPointerException e){
           throw new RuntimeException("Uneseni string je prazan!");
       }
    }
}
