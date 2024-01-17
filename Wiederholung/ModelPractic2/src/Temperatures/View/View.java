package Temperatures.View;

import Temperatures.Controller.Controller;
import Temperatures.Model.CelsiusToFahrenheit;
import Temperatures.Model.City;
import Temperatures.Model.ConversionStrategy;
import Temperatures.Model.Temperature;

import java.util.ArrayList;
import java.util.Arrays;

public class View {
    private Controller controller;

    public View() {
        this.controller = new Controller(dummyData());
    }

    public static ArrayList<City> dummyData() {
        return new ArrayList<>(Arrays.asList(
                new City("Sighisoara", "Romania", Arrays.asList(
                        new Temperature(10.2, "celsius", 1),
                        new Temperature(14.5, "celsius", 5))),
                new City("Sibiu", "Romania", Arrays.asList(
                        new Temperature(15.4, "celsius", 1),
                        new Temperature(95.2, "fahrenheit", 8)))
        ));
    }

    public void addTemperature() {
        Temperature temp = new Temperature(99.0, "celsius", 1);
        controller.addTemperature(new City("Sighisoara", "Romania", new ArrayList<>()), temp);
        System.out.println(controller.cities.toString());
    }

    public void convertTemperature() {
        ConversionStrategy strategy = new CelsiusToFahrenheit();
        controller.setStrategy(strategy);
        controller.convertCityTemperaturesWithStrategy("Sighisoara");
        System.out.println(controller.cities);
    }
}
