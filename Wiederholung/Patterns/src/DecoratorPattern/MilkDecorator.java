package DecoratorPattern;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "with Milk";
    }

    @Override
    public double price() {
        return super.price() + 0.5;
    }

}
