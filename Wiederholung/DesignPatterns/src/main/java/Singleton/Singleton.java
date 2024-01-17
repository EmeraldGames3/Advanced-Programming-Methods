package Singleton;

public class Singleton {
    private static volatile Singleton singleton = null;

    private String s = "";

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    private Singleton() {
        s = "Let's go singleton";
    }

    public static synchronized Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
