import java.util.ArrayList;

public class Animal {
    private String name;
    private String species;
    private int age;
    private String enclosure_type;
    private String health_status;

    public Animal(String name, String species, int age, String enclosure_type, String health_status) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.enclosure_type = enclosure_type;
        this.health_status = health_status;
    }

    public static Animal stringToAnimal(String string){
        String[] line = string.split(",");
        return new Animal(line[0], line[1], Integer.parseInt(line[2]), line[3], line[4]);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", enclosure_type='" + enclosure_type + '\'' +
                ", health_status='" + health_status + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEnclosure_type() {
        return enclosure_type;
    }

    public void setEnclosure_type(String enclosure_type) {
        this.enclosure_type = enclosure_type;
    }

    public String getHealth_status() {
        return health_status;
    }

    public void setHealth_status(String health_status) {
        this.health_status = health_status;
    }
}
