package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {

     private final Stack<String> operators = new Stack<String>();
     private final Stack<Double> operands = new Stack<Double>();

    private boolean isBinaryOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private boolean isUnaryOperator(String str){
        return str.equals("sqrt");
    }

    public Double evaluate(String str) throws RuntimeException{
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
                            double rez = a - b;
                            operands.push(rez);
                            break;
                        }
                        case "*": {
                            double rez = a * b;
                            operands.push(rez);
                            break;
                        }
                        case "/": {
                            double rez = a / b;
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
}
