package Adapter;

public class PayRon implements Pay{
    @Override
    public void pay(int amount) {
        System.out.println("Payed " + amount);
    }
}
