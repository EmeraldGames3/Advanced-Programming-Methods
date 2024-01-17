package Temperatures.Model;

public class CelsiusToFahrenheit implements ConversionStrategy{
    @Override
    public Temperature convert(Temperature temperature) {
        return new Temperature(temperature.getValue() * 33.8, "Fahrenheit", temperature.getMonth());
    }
}
