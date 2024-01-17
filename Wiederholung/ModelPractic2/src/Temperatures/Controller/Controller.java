package Temperatures.Controller;

import Temperatures.Model.City;
import Temperatures.Model.ConversionStrategy;
import Temperatures.Model.Temperature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {
    public ArrayList<City> cities;
    private ConversionStrategy strategy = null;

    public Controller(ArrayList<City> cities) {
        this.cities = cities;
    }

    public void addTemperature(City city, Temperature temperature){
        for (City value : cities) {
            if (Objects.equals(value.getName(), city.getName())) {
                value.addOrUpdateTemperature(temperature);
            }
        }
    }

    private City findCityByName(String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        return null;
    }
    
    public void convertCityTemperaturesWithStrategy(String cityName){
        City city = findCityByName(cityName);
        
        if(city != null){
            List<Temperature> convertedTemperatures = new ArrayList<>();
            for (Temperature temp : city.getTemperatures()) {
                convertedTemperatures.add(strategy.convert(temp));
            }
            city.setTemperatures(convertedTemperatures);
        }
    }
    
    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public ConversionStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ConversionStrategy strategy) {
        this.strategy = strategy;
    }
}
