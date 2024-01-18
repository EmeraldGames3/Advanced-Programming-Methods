package StrategyPattern;

public class AddOperation implements Operation{
    @Override
    public int doOperation(int nr1, int nr2) {
        return nr1+nr2;
    }
}
