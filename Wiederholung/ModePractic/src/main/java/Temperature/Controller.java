package Temperature;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Stadt> cities;

    public Controller() {
        cities = new ArrayList<>();
    }

    public void addTemperature(String cityName, String country, Temperature temperature) {
        Stadt city = findCityByName(cityName);

        if (city == null) {
            // Create a new Stadt object if it doesn't exist and add it to the list
            city = new Stadt(cityName, country, new ArrayList<>());
            cities.add(city);
        }

        // Add or update the temperature for the city
        city.addOrUpdateTemperature(temperature);
    }

    public void convertCityTemperatures(String cityName, TemperatureConversionStrategy strategy) {
        Stadt city = findCityByName(cityName);

        if (city != null) {
            List<Temperature> convertedTemperatures = new ArrayList<>();
            for (Temperature temp : city.getTemperatures()) {
                convertedTemperatures.add(strategy.convert(temp));
            }
            city.setTemperatures(convertedTemperatures);
        }
    }

    public double getAverageTemperature(String cityName) {
        Stadt city = findCityByName(cityName);
        if (city != null) {
            return city.calculateAverageTemperature();
        }
        return 0.0;
    }

    private Stadt findCityByName(String cityName) {
        for (Stadt city : cities) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        return null;
    }
}
