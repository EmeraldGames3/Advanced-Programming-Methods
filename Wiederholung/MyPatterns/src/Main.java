import Adapter.*;
import Builder.CarBuilder;
import Factory.Vehicle;
import Factory.VehicleFactory;
import Observer.Appointment;
import Observer.Observer1;
import Observer.Observer2;
import Proxy.ProxyInternet;
import Singleton.Singleton;
import Strategy.AddOperation;
import Strategy.Calculator;
import Strategy.SubtractOperation;

public class Main {
    public static void singleton() throws InterruptedException {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        Thread thread = new Thread(() -> {
            Singleton singleton2 = Singleton.getInstance();
        });

        thread.start();
        thread.join();
    }

    public static void strategy(){
        int n1 = 2, n2 = 1;
        Calculator calculator = new Calculator();

        calculator.setOperation(new AddOperation());
        System.out.println(calculator.executeOperation(n1, n2));

        calculator.setOperation(new SubtractOperation());
        System.out.println(calculator.executeOperation(n1, n2));
    }

    public static void proxy(){
        ProxyInternet proxyInternet = new ProxyInternet();
        proxyInternet.connectTo("banned.com");
        proxyInternet.connectTo("pornhub.com");
    }

    public static void observer() {
        Appointment appointment = new Appointment();
        Observer1 observer1 = new Observer1();
        Observer1 observer1_2 = new Observer1();
        Observer2 observer2 = new Observer2();

        appointment.addObserver(observer1);
        appointment.addObserver(observer1_2);
        appointment.addObserver(observer2);

        appointment.notifyObservers();
    }

    public static void builder() {
        CarBuilder carBuilder = new CarBuilder();
        System.out.println(carBuilder
                .addModell("mata")
                .addEngine("cox")
                .addBreaks("nuiu")
                .addTransmission("pwp")
                .buildCar());
    }

    public static void factory() {
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle vehicle1 = vehicleFactory.getVehicle("CAR");
        vehicle1.drive();

        Vehicle vehicle2 = vehicleFactory.getVehicle("BIKE");
        vehicle2.drive();

        Vehicle vehicle3 = vehicleFactory.getVehicle("TRUCK");
        vehicle3.drive();
    }

    public static void adapter() {
        NewMediaPlayer spotifyPlayer = new Spotify();
        spotifyPlayer.play(" song from Adapter.Spotify");

        OldMediaPlayer cdPlayer = new CDplayer();
        NewMediaPlayer adapter = new MediaPlayerAdapter(cdPlayer);
        adapter.play(" song from CD");
    }

    public static void main(String[] args) {
    }
}