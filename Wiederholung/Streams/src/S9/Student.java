package S9;

public class Student {
    public String name;
    public String university;

    public Student(String name, String university) {
        this.name = name;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "S9.Student{" +
                "name='" + name + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}
