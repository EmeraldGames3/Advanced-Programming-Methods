package Builder;

public class Test {
    private String description;
    private int value;
    private int expectedValue;

    public Test(String description, int value, int expectedValue) {
        this.description = description;
        this.value = value;
        this.expectedValue = expectedValue;
    }

    public void runTest(){
        if(value != expectedValue)
            throw new RuntimeException();
        System.out.println("Builder.Test succesfull");
    }
}
