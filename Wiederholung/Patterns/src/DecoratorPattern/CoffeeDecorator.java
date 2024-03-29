package DecoratorPattern;

public abstract class CoffeeDecorator implements Coffee{
    private Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double price() {
        return decoratedCoffee.price();
    }
}
