import java.io.IOException;
import java.util.ArrayList;

public class TestAnimalCaretaker {
    public void testAnimalCaretaker() throws IOException {
        ArrayList<Animal> animals = FileReadWrite.readFromFile("examen/animals_inventory.csv");

        AnimalThief animalThief = new AnimalThief();
        AnimalCaretaker animalCaretaker = new AnimalCaretaker();

        for(var animal : animals) {
            assert animalCaretaker.takeCareOfAnimal(animal).equals(animalThief.takeCareOfAnimal(animal));
            assert animalCaretaker.takeCareOfAnimal(animal).equals("Animal" + animal + " was stolen!");
        }


    }
}
