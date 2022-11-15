package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {

    Stack<String> operators = new Stack<String>();
    Stack<Double> operands = new Stack<Double>();

    private boolean isBinaryOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private boolean isUnaryOperator(String str){
        return str.equals("sqrt");
    }

    public Double evaluate(String str){
        String[] splits = str.split(" ");

        for(String x : splits){

        }

    }
}
