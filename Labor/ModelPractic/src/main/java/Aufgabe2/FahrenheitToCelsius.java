package Aufgabe2;

public class FahrenheitToCelsius implements TemperatureConverterStrategy{
    @Override
    public double convert(double temperature) {
        return temperature * 9 / 5 + 32;
    }
}
