package Temperatures.Tests;

import Temperatures.Controller.Controller;
import Temperatures.Model.CelsiusToFahrenheit;
import Temperatures.Model.City;
import Temperatures.Model.ConversionStrategy;
import Temperatures.Model.Temperature;
import Temperatures.View.View;

import java.util.ArrayList;
import java.util.Objects;

public class Test {
    public Controller controller = new Controller(View.dummyData());

    private void testAddTemperature(){
        assert controller.getCities().size() == 2;
        controller.addTemperature(new City("Cluj", "Romania", new ArrayList<>()),
                new Temperature(100d, "Maicata", 1));
        assert Objects.equals(controller.getCities().getLast().getName(), "Sibiu");
        controller.addTemperature(new City("Sibiu", "Romania", new ArrayList<>()),
                new Temperature(100d, "Maicata", 1));
    }
    public void testConvertTemperature(){
        ConversionStrategy strategy = new CelsiusToFahrenheit();
        controller.setStrategy(strategy);
        controller.convertCityTemperaturesWithStrategy("Sighisoara");
        assert Objects.equals(controller.getCities().getFirst().getTemperatures().getFirst().getUnit(), "Fahrenheit");
        assert Objects.equals(controller.getCities().getFirst().getTemperatures().getLast().getUnit(), "Fahrenheit");
    }

    public void testAll(){
        testAddTemperature();
        testConvertTemperature();
    }
}
