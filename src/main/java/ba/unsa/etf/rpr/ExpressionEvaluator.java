package ba.unsa.etf.rpr;

import java.util.EmptyStackException;
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
        int brojOtvorenih = 0;
        int brojZatvorenih = 0;
       try{
           String[] splits = str.split(" ");

           for(int i = 0; i< splits.length; i++){
               if(splits[i].equals("(")) {brojOtvorenih++;}
               else if(isUnaryOperator(splits[i]) && !splits[i+1].equals("(")) {
                   throw new RuntimeException("Unos nije validan!");
               } else if(splits[i].equals(")")){
                   brojZatvorenih++;
                   if(operators.isEmpty()) continue;
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
               else if(isBinaryOperator(splits[i]) || isUnaryOperator(splits[i])){
                   operators.push(splits[i]);
               }
               else{
                   try{
                       operands.push(Double.parseDouble(splits[i]));
                   }
                   catch (NumberFormatException e){
                       throw new RuntimeException("Unos nije validan!");
                   }
               }
           }

           if(!operators.isEmpty() || operands.size() != 1){
               throw new RuntimeException("Unos nije validan!");
           }
           else if(brojOtvorenih != brojZatvorenih){
               throw new RuntimeException("Unos nije validan!");
           }

           return operands.pop();
       }
       catch (NullPointerException e){
           throw new RuntimeException("Uneseni string je prazan!");
       }
       catch(EmptyStackException e){
           throw new RuntimeException("Unos nije validan!");
       }
    }
}
