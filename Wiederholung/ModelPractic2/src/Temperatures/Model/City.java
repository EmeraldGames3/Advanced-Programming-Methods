package Temperatures.Model;

import java.util.List;
import java.util.Objects;

public class City {
    private String name;
    private String country;
    private List<Temperature> temperatures;

    public City(String name, String country, List<Temperature> temperatures) {
        this.name = name;
        this.country = country;
        this.temperatures = temperatures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Temperature> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<Temperature> temperatures) {
        this.temperatures = temperatures;
    }

    public void addOrUpdateTemperature(Temperature temperature) {
        for (int i = 0; i < temperatures.size(); i++) {
            if (Objects.equals(temperatures.get(i).getMonth(), temperature.getMonth())) {
                temperatures.set(i, temperature);
                return;
            }
        }
        temperatures.add(temperature);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name +
                "', country='" + country +
                "', temperatures=" + temperatures +
                '}';
    }
}
