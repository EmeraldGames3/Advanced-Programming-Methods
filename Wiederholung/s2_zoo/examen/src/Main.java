import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<Animal> animals = FileReadWrite.readFromFile("sick_animals.csv");
//        System.out.println(animals);

//        FilterAndGroupAnimals.groupAnimalsBySpecies(animals);
//        FileReadWrite.writeToFile(animals, "sick_animals.csv");
//        AnimalCaretaker animalCaretaker = new AnimalCaretaker();
//        animalCaretaker.takeCareOfAnimal(animals.getFirst());
//
//        TestAnimalCaretaker testAnimalCaretaker = new TestAnimalCaretaker();
//        testAnimalCaretaker.testAnimalCaretaker();
//
//        System.out.println();
//        AnimalMonitor animalMonitor = new AnimalMonitor();
//        animalMonitor.animalHealth(animals.getFirst());

        System.out.println(addAnimals(new Animal(), new Animal(), (a, b) -> a.getAge() + b.getAge()));
    }

    public static Integer addAnimals(Animal a1, Animal a2, Func<Integer, Animal> f) {
        return f.apply(a1, a2);
    }
}