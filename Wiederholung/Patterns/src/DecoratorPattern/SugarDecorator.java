package DecoratorPattern;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + "With sugar";
    }

    @Override
    public double price() {
        return super.price() + 0.3;
    }
}
