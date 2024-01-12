package Aufgabe1;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CountryFileReader countryFileReader = new CountryFileReader();

        List<Country> filteredCountries = countryFileReader
                .filterFromFile("src/main/java/Aufgabe1/laender.txt");

        countryFileReader.writeToFileCSV(filteredCountries,"Solution");

        System.out.println(filteredCountries);
    }
}
