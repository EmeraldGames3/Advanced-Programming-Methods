package org.example;

public class Student {
    private String Name;
    private String University;

    private Pair<String, Integer> Course;

    public Student(String Name, String University) {
        this.Name = Name;
        this.University = University;
        this.Course = new Pair<>();
    }

    public Student(Student student) {
        this.Name = student.Name;
        this.University = student.University;
        this.Course = new Pair<>(student.Course);
    }

    public Student(String Name, String University, String Course, Integer Grade) {
        this.Name = Name;
        this.University = University;
        this.Course = new Pair<>(Course, Grade);
    }

    public Student() {
        this.Name = "";
        this.University = "";
        this.Course = new Pair<>();
    }


    public String getName() {
        return Name;
    }

    public String getUniversity() {
        return University;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setUniversity(String University) {
        this.University = University;
    }

    public Pair<String, Integer> getCourse() {
        return Course;
    }

    public void setCourse(Pair<String, Integer> course) {
        Course = course;
    }

    public String toString() {
        return "Name: " + Name + ", University: " + University;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return this.Name.equals(student.Name) && this.University.equals(student.University);
        }
        return false;
    }

    public int hashCode() {
        return Name.hashCode() + University.hashCode();
    }

    public int compareTo(Student student) {
        int result = this.Name.compareTo(student.Name);
        if (result == 0) {
            result = this.University.compareTo(student.University);
        }
        return result;
    }
}
