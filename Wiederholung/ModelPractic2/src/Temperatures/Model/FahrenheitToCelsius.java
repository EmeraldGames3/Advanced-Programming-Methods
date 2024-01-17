package Temperatures.Model;

public class FahrenheitToCelsius implements ConversionStrategy{

    @Override
    public Temperature convert(Temperature temperature) {
        return new Temperature(temperature.getValue() / 33.8, "Celsius", temperature.getMonth());
    }
}
