package StrategyPattern;

public class SubtractOperation implements Operation{
    @Override
    public int doOperation(int nr1, int nr2) {
        return nr1-nr2;
    }
}
