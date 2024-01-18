import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterAndGroupAnimals {
    public static void groupAnimalsBySpecies(ArrayList<Animal> animals){
         animals.stream()
                 .collect(Collectors.groupingBy(Animal::getSpecies, Collectors.counting()))
                 .entrySet().stream()
                 .sorted(Map.Entry.<String, Long>comparingByValue())
                 .forEach(System.out::println);
    }
}
