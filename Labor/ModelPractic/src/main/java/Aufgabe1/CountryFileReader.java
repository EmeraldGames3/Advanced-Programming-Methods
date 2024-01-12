package Aufgabe1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CountryFileReader {
    public List<Country> filterFromFile(String fileName) throws IOException {
//        List<Country> countries = new ArrayList<>();

        return Files.lines(Path.of(fileName))
                .map(Country::parseCountry)
                .filter(c -> c.getName().startsWith("M") && c.getArea() > 10000)
                .collect(Collectors.toList());

//        Files.lines(Path.of(fileName))
//                .map(country -> country
//                        .split(" "))
//                .forEach(elem -> countries.add(
//                        new Country(
//                                elem[0], elem[1], Long.parseLong(elem[2]),
//                                Long.parseLong(elem[3]), elem[4]
//                        )
//                )
//        );
//
//        return countries.stream()
//                .filter(c ->  c.getName().startsWith("M") && c.getArea() > 10000)
//                .collect(Collectors.toList());
    }

    public void writeToFileCSV(List<Country> countries, String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        countries.forEach(c -> {
                    try {
                        bw.write(c.toString());
                        bw.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        bw.close();
    }
}
