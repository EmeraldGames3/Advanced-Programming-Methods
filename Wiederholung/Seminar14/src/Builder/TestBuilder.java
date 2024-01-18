package Builder;

public class TestBuilder {
    private int expectedValue;
    private String description;
    private int value;

    public TestBuilder expectedValue(int value){
        this.expectedValue = value;
        return this;
    }

    public TestBuilder description(String description){
        this.description = description;
        return this;
    }

    public TestBuilder result(int value){
        this.value = value;
        return this;
    }

    public Test build(){
        return new Test(description, value, expectedValue);
    }
}
