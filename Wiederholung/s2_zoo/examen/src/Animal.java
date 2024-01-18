public class Animal {
    private String name;
    private String species;
    private Integer age;
    private String enclosure_type;
    private String health_status;

    public Animal(String name, String species, Integer age, String enclosure_type, String health_status) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.enclosure_type = enclosure_type;
        this.health_status = health_status;
    }

    public static Animal parseAnimal(String line){
        String[] words = line.split(",");
        return new Animal(words[0], words[1], Integer.parseInt(words[2]), words[3], words[4]);
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    @Override
    public String toString() {
        return name + ',' +
                species + ',' +
                age + "," +
                enclosure_type + ',' +
                health_status;
    }

    //    "name," "species," "age," "enclosure_type," and "health_status."
// The columns are separated by the "," character.
}
