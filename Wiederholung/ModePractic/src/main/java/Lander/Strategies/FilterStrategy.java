package Lander.Strategies;

import Lander.Land;

import java.util.List;

public interface FilterStrategy {
    List<Land> filter(List<Land> lands);
}
