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

    public static void main(String[] args) throws InterruptedException {

    }
}