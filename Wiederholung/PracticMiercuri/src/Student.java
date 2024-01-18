public class Student {
    private int student_id;
    private int course_code;
    private String semester;
    private double grade;
    private String status;

    public Student(int student_id, int course_code, String semester, double grade, String status) {
        this.student_id = student_id;
        this.course_code = course_code;
        this.semester = semester;
        this.grade = grade;
        this.status = status;
    }

    public static Student parseStudent(String line){
        String[] words = line.split("_");
        return new Student(Integer.parseInt(words[0]), Integer.parseInt(words[1]),
                words[2], Double.parseDouble(words[3]), words[4]);
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", course_code=" + course_code +
                ", semester='" + semester + '\'' +
                ", grade=" + grade +
                ", status='" + status+
                '}';
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_code() {
        return course_code;
    }

    public void setCourse_code(int course_code) {
        this.course_code = course_code;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
