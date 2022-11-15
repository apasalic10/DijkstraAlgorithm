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
            if(x.equals("(")) {}
            else if(x.equals(")")){

                String operacija = operators.pop();
                if(isBinaryOperator(operacija)){

                    double a =operands.pop();
                    double b = operands.pop();

                    if(operacija.equals("+")){
                        double rez = a + b;
                        operands.push(rez);
                    }
                    else if(operacija.equals("-")){
                        double rez = a - b;
                        operands.push(rez);
                    }
                    else if(operacija.equals("*")){
                        double rez = a * b;
                        operands.push(rez);
                    }
                    else if(operacija.equals("/")){
                        double rez = a / b;
                        operands.push(rez);
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

        return operands.pop();
    }
}
