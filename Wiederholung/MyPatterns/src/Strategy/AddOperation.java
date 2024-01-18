package Strategy;

public class AddOperation implements Operation{
    @Override
    public Integer operation(int n1, int n2) {
        return n1+n2;
    }
}
