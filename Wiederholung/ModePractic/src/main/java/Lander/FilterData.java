package Lander;

import Lander.Strategies.FilterStrategy;

import java.util.List;

public class FilterData {
    private FilterStrategy strategy;

    public FilterData(FilterStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(FilterStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Land> executeStrategy(List<Land> lands) {
        return strategy.filter(lands);
    }
}
