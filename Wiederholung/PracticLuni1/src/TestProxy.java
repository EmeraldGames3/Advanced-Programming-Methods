import java.util.ArrayList;

public class TestProxy {
    void testProxy(ArrayList<Animal> animals) {
        AnimalThief animalThief = new AnimalThief();
        AnimalCaretaker animalCaretaker = new AnimalCaretaker();

        animals.forEach(
                animal -> {
                    assert animalThief.takeCareOfAnimal(animal).equals(animalCaretaker.takeCareOfAnimal(animal));
                    assert ("Stealing animal " + animal).equals(animalCaretaker.takeCareOfAnimal(animal));
                    assert ("Stealing animal " + animal).equals(animalThief.takeCareOfAnimal(animal));
                }
        );

        try {
            animalCaretaker.takeCareOfAnimal(null);
            assert false;
        } catch (RuntimeException exception){
            assert true;
        }
    }
}
