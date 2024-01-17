import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReadWrite {
    public List<Animal> FileRead(String fileName) throws IOException {
        return Files.lines(Path.of(fileName))
                .map(Animal::stringToAnimal)
                .collect(Collectors.toList());
    }

    public void FileWriteSickAnimals(List<Animal> animals, String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        animals.forEach( animal -> {
                    try {
                        bw.write(animal.toString());
                        bw.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        bw.close();

        countries.forEach(c -> {
                    try {
                        bw.write(c.toString());
                        bw.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
