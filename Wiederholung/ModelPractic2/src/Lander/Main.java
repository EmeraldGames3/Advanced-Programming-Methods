package Lander;

import java.io.IOException;
import java.util.List;

class Main{
    public static void main(String[] args) throws IOException {
        List<Country> countries = FileController.readFromFile("src/Lander/land.txt")
                .stream()
                .filter(c -> c.getArea() > 10000 && c.getName().startsWith("M"))
                .toList();

        FileController.writeToCSVFile(countries,"src/Lander/results.csv");
    }
}