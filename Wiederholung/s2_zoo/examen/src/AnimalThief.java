public class AnimalThief implements AnimalInterface{

    public AnimalThief(){}
    @Override
    public String takeCareOfAnimal(Animal animal) {
        return  "Animal" + animal.toString() + " was stolen!";
    }
}
