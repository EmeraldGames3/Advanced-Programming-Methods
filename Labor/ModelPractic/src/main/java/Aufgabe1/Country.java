package Aufgabe1;

public class Country {
    private String name;
    private String continent;
    private Long area;
    private Long population;
    private String capital;

    public Country(String name, String continent, Long area, Long population, String capital) {
        this.name = name;
        this.continent = continent;
        this.area = area;
        this.population = population;
        this.capital = capital;
    }

    public static Country parseCountry(String data) {
        String[] string = data.split(" ");
        return new Country(string[0], string[1], Long.parseLong(string[2]), Long.parseLong(string[3]), string[4]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return name
                + ";" + continent
                + ";" + area +
                ";" + population +
                ";" + capital;
    }
}
