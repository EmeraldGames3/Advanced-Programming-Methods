package StrategyPattern;


public class Calculator {
    private Operation operation;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    public int calculateSum(int nr1,int nr2){
        setOperation(new AddOperation());
        return operation.doOperation(nr1,nr2);
    }
    public int calculateDiff(int nr1,int nr2){
        setOperation(new SubtractOperation());
        return operation.doOperation(nr1,nr2);
    }

}
