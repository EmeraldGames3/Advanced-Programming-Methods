public class Person {
    private String name;
    private String department = "ceva";

    public Person(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }
}
