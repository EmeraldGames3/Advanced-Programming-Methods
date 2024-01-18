package S10;

public class Auto {
    private String mark;
    private String modell;
    private Integer baujahr;

    public Auto(String mark, String modell, Integer baujahr) {
        this.mark = mark;
        this.modell = modell;
        this.baujahr = baujahr;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public Integer getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(Integer baujahr) {
        this.baujahr = baujahr;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "mark='" + mark + '\'' +
                ", modell='" + modell + '\'' +
                ", baujahr=" + baujahr +
                '}';
    }
}
