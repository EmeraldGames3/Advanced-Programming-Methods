package Proxy;

import java.util.Arrays;
import java.util.List;

public class ProxyInternet implements Internet{
    private RealInternet realInternet;
    private final List<String> bannedSites;

    public ProxyInternet(){
        bannedSites = Arrays.asList("restricted.com","banned.com");
    }

    @Override
    public void connectTo(String website) {
        if(realInternet == null)
            realInternet = new RealInternet();
        System.out.println("Checking if trying to access banned Sites");
        if(bannedSites.contains(website)){
            System.out.println("Access denied");
            return;
        }
        realInternet.connectTo(website);
    }
}
