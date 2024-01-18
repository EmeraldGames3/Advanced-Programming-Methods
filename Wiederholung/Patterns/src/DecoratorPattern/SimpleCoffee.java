package DecoratorPattern;

public class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public double price() {
        return 10.5;
    }
}
