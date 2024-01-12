package Aufgabe2;

public class Temperature {
    private double value;
    private String unit;
    private Integer month;

    public Temperature(double value, String unit, Integer month) {
        this.value = value;
        this.unit = unit;
        this.month = month;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
