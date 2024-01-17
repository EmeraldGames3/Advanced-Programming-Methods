package Temperature;

import java.util.List;
import java.util.Optional;

public class Stadt {
    private String name;
    private String land;
    private List<Temperature> temperatures;

    public Stadt(String name, String land, List<Temperature> temperatures) {
        this.name = name;
        this.land = land;
        this.temperatures = temperatures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public List<Temperature> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<Temperature> temperatures) {
        this.temperatures = temperatures;
    }

    public void addOrUpdateTemperature(Temperature newTemp) {
        for(int i = 0; i < temperatures.size(); i++){
            if(temperatures.get(i).getMonth() == newTemp.getMonth()){
                temperatures.set(i, newTemp);
                return;
            }
        }
        temperatures.add(newTemp);
    }

    // Method to calculate average temperature
    public double calculateAverageTemperature() {
        return temperatures.stream()
                .mapToDouble(Temperature::getWert)
                .average()
                .orElse(0.0);
    }
}
