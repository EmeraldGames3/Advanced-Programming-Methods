package Temperature;

public class FahrenheitToCelsius implements TemperatureConversionStrategy {
    @Override
    public Temperature convert(Temperature oldTemperature) {
        if ("F".equals(oldTemperature.getMasseinheit())) {
            double celsius = (oldTemperature.getWert() - 32) * 5/9;
            return new Temperature(celsius, "C", oldTemperature.getMonth());
        }
        return oldTemperature;
    }
}
