import java.util.*;
import java.util.stream.Collectors;

public class GroupAnimalsBySpecies {
    public static void groupAnimalsBySpeciesAndDisplay(ArrayList<Animal> animals){
        animals.stream()
                .collect(Collectors.groupingBy(Animal::getSpecies, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
