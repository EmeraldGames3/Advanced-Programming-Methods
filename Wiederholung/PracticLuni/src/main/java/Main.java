import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * #############################################################################################################################################################
 * <p>
 *  * 1p Correctly identify each responsibility and concern of your solution and place them in components which encapsulate them.
 *  * <p>
 *  * Develop a system for managing a zoo's animal inventory. You will find the Zoo’s inventory in the file named
 *  * "animal_inventory.csv" with columns: "name," "species," "age," "enclosure_type," and "health_status."
 *  *  The columns are separated by the "," character.
 *  * <p>
 *  * A. 2p Read the contents of the "animal_inventory.csv" file and convert each line into a Java object,
 *  * modeling it accordingly.
 *  *     Create a class that defines how an entry from the file should look like as an object.
 *  *     The result should be of type: ArrayList<Animal>.
 *  * B. 1p Using Java streams, display on the screen the species and the number of animals of that species,
 *  * sorted descending based on the count.
 *  * C. 2p Using Java streams and their respective .map() method, save to a file called "sick_animals.txt" all the names
 *  * of animals with health_status set to "sick."
 *  *     but make sure that the animal name is uppercased.
 * D. 1p Utilize a design pattern to create a class "AnimalCareTaker" which actually acts as an “AnimalThief”.
 *     Instead of taking care of the animals, it will steal the animal without anyone knowing.
 *        Leave a comment containing the name of the design pattern which you used.
 * E. 1p Prepare a test to guarantee the implementation from "D."
 * F. 1p Define two threads which monitor an Animal health. The first one acts as a doctor while the second one
 * acts as a disease.
 *     If the animal’s health status is “Sick”, the doctor thread will set it to “Healthy”.
 *     If this happens, the disease thread will wait 2 seconds and then set the animal’s health status to “Sick”.
 *     The two threads run concurrently and display on the screen the action which they’re performing.
 * <p>
 * 	Example output:
 * 	Doctor: Healing animal
 * 	Disease: Waiting 2 seconds
 * 	Disease: Making animal sick
 * 	Doctor: Healing animal
 * 	Disease: Waiting 2 seconds
 * 1p ex-officio point
 */

public class Main {
    public static void main(String[] args) throws IOException {
        FileReadWrite fileReadWrite = new FileReadWrite();
        ArrayList<Animal> animals = fileReadWrite.FileRead("src/main/java/animals_inventory.csv");

        Map<String, Long> speciesCount = animals.stream()
                .collect(Collectors.groupingBy(Animal::getSpecies, Collectors.counting()));

        speciesCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        List<Animal> sickAnimalNames = animals.stream()
                .filter(animal -> "Sick".equals(animal.getHealth_status())) // Filter sick animals
                .map(animal -> new Animal(animal.getName().toUpperCase(), animal.getSpecies(), animal.getAge(), animal.getEnclosure_type(), animal.getHealth_status())) // Map to uppercased names
                .collect(Collectors.toList()); // Collect to a list

        // Assuming FileWriteSickAnimals method writes a list of strings to a text file
        fileReadWrite.FileWriteSickAnimals(sickAnimalNames, "sick_animals.txt");

    }
}
