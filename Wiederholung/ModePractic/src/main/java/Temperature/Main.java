package Temperature;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View();

        // Adding temperatures
        controller.addTemperature("Berlin", "Germany", new Temperature(10, "C", 5));
        controller.addTemperature("Berlin", "Germany", new Temperature(20, "C", 6));

        // Converting to Fahrenheit
        controller.convertCityTemperatures("Berlin", new CelsiusToFahrenheit());

        // Getting and displaying average temperature
        double avgTemp = controller.getAverageTemperature("Berlin");
        view.displayAverageTemperature("Berlin", avgTemp);
    }

}
