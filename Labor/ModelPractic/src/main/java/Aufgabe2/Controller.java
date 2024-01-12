package Aufgabe2;

import java.util.ArrayList;

public class Controller {
    ArrayList<City> cities;

    public void addTemperature(City city, Temperature temperature) {
        for (City c : cities) {
            if (c.getName().equals(city.getName())) {
                for (Temperature temperature1 : c.getTemperatures()) {
                    if (temperature1.getMonth() == temperature.getMonth()){
                        temperature1.setValue(temperature.getValue());
                        return;
                    }
                }
                c.addTemperature(temperature);
                return;
            }
        }
        city.addTemperature(temperature);
        cities.add(city);
    }
}
