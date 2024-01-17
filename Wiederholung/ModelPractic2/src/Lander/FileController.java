package Lander;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileController {
    public static List<Country> readFromFile(String path) throws IOException {
        return Files.lines(Path.of(path))
                .map(Country::parseCountry)
                .collect(Collectors.toList());
    }

    public static void writeToCSVFile(List<Country> countries, String file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        countries.forEach(country -> {
            try {
                bw.write(country.toString());
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.close();
    }
}