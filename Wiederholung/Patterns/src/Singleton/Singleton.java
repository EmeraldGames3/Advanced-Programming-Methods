package Singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Creating object");
    }

    public Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void doSomething(){
        System.out.println("Do something...");
    }
}
