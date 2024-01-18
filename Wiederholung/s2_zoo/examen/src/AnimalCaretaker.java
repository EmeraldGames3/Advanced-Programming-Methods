public class AnimalCaretaker implements AnimalInterface {
    private final AnimalThief animalThief = new AnimalThief();

    @Override
    public String takeCareOfAnimal(Animal animal) {
        return animalThief.takeCareOfAnimal(animal);
    }
}
