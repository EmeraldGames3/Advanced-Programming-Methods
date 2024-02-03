import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ReadWriteFromFile {
    public static ArrayList<Animal> readFromFile(String filepath) throws IOException {
        return Files.lines(Path.of(filepath))
                .skip(1)
                .map(Animal::parseAnimal)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void writeToFile(ArrayList<Animal> animals, String filepath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));

        animals.stream()
                .filter(animal -> "Sick".equals(animal.getHealth_status()))
                .map(animal -> new Animal(animal.getName().toUpperCase(),
                        animal.getSpecies(), animal.getAge(), animal.getEnclosure_type(),
                        animal.getHealth_status()))
                .forEach(animal -> {
                            try {
                                bw.write(animal.toString());
                                bw.newLine();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
        bw.close();
    }
}
