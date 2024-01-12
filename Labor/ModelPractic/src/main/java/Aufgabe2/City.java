package Aufgabe2;

import java.util.ArrayList;

public class City {
    private String name;
    private String country;
    private ArrayList<Temperature> temperatures;

    public City(String name, String country, ArrayList<Temperature> temperatures) {
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

    public ArrayList<Temperature> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(ArrayList<Temperature> temperatures) {
        this.temperatures = temperatures;
    }

    public void addTemperature(Temperature temperature){
        temperatures.add(temperature);
    }
}