public class AnimalThief implements AnimalManipulator{
    @Override
    public String takeCareOfAnimal(Animal animal) {
        return "Stealing animal " + animal;
    }
}
