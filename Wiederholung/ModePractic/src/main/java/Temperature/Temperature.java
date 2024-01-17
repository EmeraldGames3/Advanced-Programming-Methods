package Temperature;

public class Temperature {
    private double wert;
    private String masseinheit;
    private int month;

    public Temperature(double wert, String masseinheit, int month) {
        this.wert = wert;
        this.masseinheit = masseinheit;
        this.month = month;
    }

    public double getWert() {
        return wert;
    }

    public void setWert(double wert) {
        this.wert = wert;
    }

    public String getMasseinheit() {
        return masseinheit;
    }

    public void setMasseinheit(String masseinheit) {
        this.masseinheit = masseinheit;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
