package Lander;

import Lander.Strategies.FlacheFilterStrategy;
import Lander.Strategies.NameFilterStrategy;
import Lander.Strategies.PopulationFilterStrategy;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReadWrite fileReadWrite = FileReadWrite.getInstance();
        try {
            // Reading data from the file
            List<Land> lands = fileReadWrite.readFromFile("src/main/java/Lander/land.txt");

            // Set the desired filter strategy here
            FilterData filterData = new FilterData(new PopulationFilterStrategy(500));
            filterData.setStrategy(new NameFilterStrategy('M'));

            // Execute the filtering
            List<Land> filteredLands = filterData.executeStrategy(lands);
            filterData.setStrategy(new NameFilterStrategy('M'));
            filteredLands = filterData.executeStrategy(filteredLands);
            filterData.setStrategy(new FlacheFilterStrategy(100000L));
            filteredLands = filterData.executeStrategy(filteredLands);

            // Writing the filtered data to a new file
            fileReadWrite.writeToFile(filteredLands, "filtered_lands.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
