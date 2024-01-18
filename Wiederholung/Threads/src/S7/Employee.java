package S7;

public class Employee {
    private String name;
    private Integer gehalt;

    public Employee(String name, Integer gehalt) {
        this.name = name;
        this.gehalt = gehalt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGehalt() {
        return gehalt;
    }

    public void setGehalt(Integer gehalt) {
        this.gehalt = gehalt;
    }
}
