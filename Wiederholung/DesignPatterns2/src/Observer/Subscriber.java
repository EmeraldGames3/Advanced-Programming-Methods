package Observer;

public class Subscriber implements Observer {
    @Override
    public void update() {
        System.out.println("Received notification");
    }
}
