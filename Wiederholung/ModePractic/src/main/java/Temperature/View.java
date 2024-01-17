package Temperature;

public class View {
    public void displayTemperature(Temperature temperature) {
        System.out.println("Temperature: " + temperature.getWert() + " " + temperature.getMasseinheit());
    }

    public void displayAverageTemperature(String cityName, double avgTemp) {
        System.out.println("Average Temperature in " + cityName + ": " + avgTemp);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

