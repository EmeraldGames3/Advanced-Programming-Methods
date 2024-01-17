package Lander;

public class Country {
    private String name;
    private String continent;
    private long area;
    private long population;
    private String capital;

    public Country(String name, String continent, long area, long population, String capital) {
        this.name = name;
        this.continent = continent;
        this.area = area;
        this.population = population;
        this.capital = capital;
    }

    public static Country parseCountry(String line){
        String[] strings = line.split(" ");
        return new Country(strings[0], strings[1], Long.parseLong(strings[2]), Long.parseLong(strings[3]), strings[4]);
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

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
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
        return name + ';' +
                continent + ';' +
                area + ';' +
                population + ';' +
                capital;
    }
}
