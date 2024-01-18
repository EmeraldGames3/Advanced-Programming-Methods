package ObserverPattern;

public class AppointmentObserver1 implements Observer{

    @Override
    public void update() {
        System.out.println("Observer 1 has been updated");
    }
}
