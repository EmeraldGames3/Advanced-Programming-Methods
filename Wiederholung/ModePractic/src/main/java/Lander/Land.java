package Lander;

public class Land {
    private String name;
    private String kontinent;
    private Long flache;
    private Long bevolkerung;
    private String Hauptstadt;

    public Land(String name, String kontinent, Long flache, Long bevolkerung, String hauptstadt) {
        this.name = name;
        this.kontinent = kontinent;
        this.flache = flache;
        this.bevolkerung = bevolkerung;
        Hauptstadt = hauptstadt;
    }

    public static Land parseCountry(String data) {
        String[] string = data.split(" ");
        return new Land(string[0], string[1], Long.parseLong(string[2]), Long.parseLong(string[3]), string[4]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKontinent() {
        return kontinent;
    }

    public void setKontinent(String kontinent) {
        this.kontinent = kontinent;
    }

    public Long getFlache() {
        return flache;
    }

    public void setFlache(Long flache) {
        this.flache = flache;
    }

    public Long getBevolkerung() {
        return bevolkerung;
    }

    public void setBevolkerung(Long bevolkerung) {
        this.bevolkerung = bevolkerung;
    }

    public String getHauptstadt() {
        return Hauptstadt;
    }

    public void setHauptstadt(String hauptstadt) {
        Hauptstadt = hauptstadt;
    }

    @Override
    public String toString() {
        return name + ';' +
                kontinent + ';' +
                flache + ';' +
                bevolkerung + ';' +
                Hauptstadt + ';';
    }
}
