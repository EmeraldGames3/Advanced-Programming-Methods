package Temperature;

public class CelsiusToFahrenheit implements TemperatureConversionStrategy {
    @Override
    public Temperature convert(Temperature oldTemperature) {
        if ("C".equals(oldTemperature.getMasseinheit())) {
            double fahrenheit = (oldTemperature.getWert() * 9/5) + 32;
            return new Temperature(fahrenheit, "F", oldTemperature.getMonth());
        }
        return oldTemperature;
    }
}
