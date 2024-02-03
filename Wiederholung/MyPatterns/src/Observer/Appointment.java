package Observer;

import java.util.ArrayList;
import java.util.List;

public class Appointment implements Observable{
    private final List<Observer> observerList = new ArrayList<>();
    public Appointment(){}
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observerList){
            observer.update();
        }
    }
}
