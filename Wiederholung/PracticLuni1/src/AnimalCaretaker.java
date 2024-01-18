public class AnimalCaretaker implements AnimalManipulator{
    AnimalThief animalThief = new AnimalThief();


    @Override
    public String takeCareOfAnimal(Animal animal) {
        if (animal == null)
            throw new RuntimeException("Values cannot be null");

        return animalThief.takeCareOfAnimal(animal);
    }
}
