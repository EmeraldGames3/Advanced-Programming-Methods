import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var animals = ReadWriteFromFile.readFromFile("src/animals_inventory.csv");
        System.out.println(animals);

        ReadWriteFromFile.writeToFile(animals, "sick_animals.txt");

        GroupAnimalsBySpecies.groupAnimalsBySpeciesAndDisplay(animals);

//        AnimalMonitor.MonitorAnimals(animals.getFirst());
        ThreadTest.twoThreads();
    }
}