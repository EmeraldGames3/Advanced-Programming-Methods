package Proxy;

public class DPRCIV implements Police{
    @Override
    public void registerPlate(String plateNumber) {
        System.out.println("The plate number is " + plateNumber);
    }
}
