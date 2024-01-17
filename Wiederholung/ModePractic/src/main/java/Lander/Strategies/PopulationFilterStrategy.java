package Lander.Strategies;

import Lander.Land;

import java.util.List;
import java.util.stream.Collectors;

public class PopulationFilterStrategy implements FilterStrategy{
    private long populationThreshold;

    public PopulationFilterStrategy(long populationThreshold) {
        this.populationThreshold = populationThreshold;
    }

    @Override
    public List<Land> filter(List<Land> lands) {
        return lands.stream()
                .filter(land -> land.getBevolkerung() > populationThreshold)
                .collect(Collectors.toList());
    }
}
