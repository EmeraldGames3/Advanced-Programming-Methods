package Lander.Strategies;

import Lander.Land;

import java.util.List;
import java.util.stream.Collectors;

public class FlacheFilterStrategy implements FilterStrategy{
    private Long flacheThreshhold;

    public FlacheFilterStrategy(Long flacheThreshhold) {
        this.flacheThreshhold = flacheThreshhold;
    }

    @Override
    public List<Land> filter(List<Land> lands) {
        return lands.stream()
                .filter(land -> land.getFlache() > flacheThreshhold)
                .collect(Collectors.toList());
    }
}
