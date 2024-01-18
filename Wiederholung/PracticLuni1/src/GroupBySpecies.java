import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBySpecies {
    public static void groupBySpecies(ArrayList<Animal> animals){
        animals.stream()
                .collect(Collectors.groupingBy(Animal::getSpecies, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
