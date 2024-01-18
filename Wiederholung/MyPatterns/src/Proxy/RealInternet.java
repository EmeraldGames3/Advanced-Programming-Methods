package Proxy;

public class RealInternet implements Internet{

    @Override
    public void connectTo(String website) {
        System.out.println("Connecting to " + website);
    }
}
