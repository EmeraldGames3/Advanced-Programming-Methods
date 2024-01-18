package ObserverPattern;

public class AppointmentObserver2 implements Observer{
    @Override
    public void update() {
        System.out.println("Observer 2 has been updated");
    }
}
