import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<Animal> animals = FileReadWrite.readFromFile("examen/animals_inventory.csv");
//        System.out.println(animals);

        FilterAndGroupAnimals.groupAnimalsBySpecies(animals);
        FileReadWrite.writeToFile(animals, "sick_animals.csv");
        AnimalCaretaker animalCaretaker = new AnimalCaretaker();
        animalCaretaker.takeCareOfAnimal(animals.getFirst());

        TestAnimalCaretaker testAnimalCaretaker = new TestAnimalCaretaker();
        testAnimalCaretaker.testAnimalCaretaker();

        System.out.println();
        AnimalMonitor animalMonitor = new AnimalMonitor();
        animalMonitor.animalHealth(animals.getFirst());
    }
}