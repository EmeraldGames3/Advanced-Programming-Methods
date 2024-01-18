package Builder;

public class CarBuilder {
    private String modell = null;
    private String engine = null;
    private String breaks = null;
    private String transmission = null;

    public CarBuilder() {
    }

    public CarBuilder addModell(String modell) {
        this.modell = modell;
        return this;
    }

    public CarBuilder addEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder addBreaks(String breaks) {
        this.breaks = breaks;
        return this;
    }

    public CarBuilder addTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public Car buildCar() {
        return new Car(modell, engine, breaks, transmission);
    }
}
