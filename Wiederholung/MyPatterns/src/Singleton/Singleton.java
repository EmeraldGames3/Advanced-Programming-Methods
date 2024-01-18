package Singleton;

public class Singleton {
    private static volatile Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    System.out.println("Creating singleton");
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
