import BuilderPattern.Meal;
import DecoratorPattern.MilkDecorator;
import DecoratorPattern.SimpleCoffee;
import DecoratorPattern.SugarDecorator;
import FactoryPattern.*;
import ObserverPattern.Appointment;
import ObserverPattern.AppointmentObserver1;
import ObserverPattern.AppointmentObserver2;
import ProxyPattern.Internet;
import ProxyPattern.ProxyInternet;
import ProxyPattern.RealInternet;
import StrategyPattern.Calculator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void factoryPattern() {
        ShapeFactory circleFactory = new CircleFactory();
        ShapeFactory squareFactory = new SquareFactory();

        Shape circle = circleFactory.create();
        Shape square = squareFactory.create();

        circle.draw();
        square.draw();
    }

    public static void observerPattern() {
        Appointment appointment = new Appointment();
        AppointmentObserver1 appointmentObserver1 = new AppointmentObserver1();
        AppointmentObserver2 appointmentObserver2 = new AppointmentObserver2();
        appointment.addObserver(appointmentObserver1);
        appointment.addObserver(appointmentObserver2);
        appointment.notifyObservers();
    }

    public static void strategyPattern() {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculateSum(2, 3));
        System.out.println(calculator.calculateDiff(2, 3));
    }

    public void decoratorPatter() {
        SimpleCoffee simpleCoffee = new SimpleCoffee();
        MilkDecorator milkDecorator = new MilkDecorator(simpleCoffee);
        SugarDecorator sugarDecorator = new SugarDecorator(simpleCoffee);
        System.out.println(milkDecorator.getDescription() + " " + milkDecorator.price());
        System.out.println(sugarDecorator.getDescription() + " " +
                sugarDecorator.price());
    }

    public void builderPattern() {
        Meal meal = new Meal.MealBuilder().withMainCourse("a").withSideDish("B").withDrink("C").withDessert("D").build();
        System.out.println(meal);
    }

    public void proxyPattern(){

        Internet realInternet = new RealInternet();
        realInternet.connectTo("example.com");
        realInternet.connectTo("restricted.com");

        System.out.println("----------------------");

        // Using ProxyInternet to control access
        Internet proxyInternet = new ProxyInternet();
        proxyInternet.connectTo("example.com");
        proxyInternet.connectTo("restricted.com");
    }

    public static void main(String[] args) {

    }
}