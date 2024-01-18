package Builder;

public class Car {
    private String modell;
    private String engine;
    private String breaks;
    private String transmission;

    public Car(String modell, String engine, String breaks, String transmission) {
        this.modell = modell;
        this.engine = engine;
        this.breaks = breaks;
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Builder.Factory.Car{" +
                "modell='" + modell + '\'' +
                ", engine='" + engine + '\'' +
                ", breaks='" + breaks + '\'' +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}
