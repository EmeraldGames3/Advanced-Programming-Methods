package FactoryPattern;

public class SquareFactory implements ShapeFactory{

    @Override
    public Shape create() {
        return new Square();
    }
}
