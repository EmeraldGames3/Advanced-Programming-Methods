package Strategy;

public class Calculator {
    private Operation operation;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int executeOperation(int n1, int n2){
        return operation.operation(n1, n2);
    }
}
