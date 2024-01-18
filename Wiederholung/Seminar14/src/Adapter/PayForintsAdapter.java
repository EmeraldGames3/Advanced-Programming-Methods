package Adapter;

public class PayForintsAdapter implements ConverstionCurrency {
    private Pay adaptee;

    public PayForintsAdapter(Pay adaptee){
        this.adaptee = adaptee;
    }

    public int convertToF(int amount) {
        return amount * 1000;
    }
    @Override
    public void pay(int amount) {
        adaptee.pay(convertToF(amount));
    }
}
