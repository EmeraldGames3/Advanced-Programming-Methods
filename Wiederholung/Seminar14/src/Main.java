import Adapter.PayForintsAdapter;
import Adapter.PayRon;
import Builder.TestBuilder;
import Factory.Placintarie;
import Proxy.DPRCIV_Proxy;

public class Main {
    public static void main(String[] args) {
        DPRCIV_Proxy proxy = new Proxy.DPRCIV_Proxy();
        proxy.registerPlate("Maicata");
//        proxy.registerPlate("xxx");

        System.out.println();
        PayRon payRon = new PayRon();
        PayForintsAdapter payForintsAdapter = new PayForintsAdapter(payRon);
        payRon.pay(100);
        payForintsAdapter.pay(100);
        System.out.println();

        TestBuilder testBuilder = new TestBuilder();
        testBuilder.expectedValue(100);
        testBuilder.result(100);
        testBuilder.description("Builder.Test");
        testBuilder.build().runTest();
        System.out.println();

        Placintarie placintarie = new Placintarie();
        System.out.println(placintarie.coace("Placinta cu Cartofi"));
    }
}