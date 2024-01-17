package Lander.Strategies;

import Lander.Land;

import java.util.List;
import java.util.stream.Collectors;

public class NameFilterStrategy implements FilterStrategy{
    private Character nameStart;

    public NameFilterStrategy(Character nameStart) {
        this.nameStart = nameStart;
    }

    @Override
    public List<Land> filter(List<Land> lands) {
        return lands.stream()
                .filter(land -> land.getName().startsWith(String.valueOf(nameStart)))
                .collect(Collectors.toList());
    }
}
