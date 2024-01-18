package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Appointment implements Observable{
    private List<Observer> observerList;
    public Appointment(){
        observerList = new ArrayList<>();
    }
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
