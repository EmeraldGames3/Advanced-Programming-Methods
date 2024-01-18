package Strategy;

public class SubtractOperation implements Operation{
    @Override
    public Integer operation(int n1, int n2) {
        return n1 - n2;
    }
}
