import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<Student> students = FileReadWrite.readFromFile("src/course_registration.csv");
//        System.out.println(students);

        GroupByCourse.groupByCourse(students);
        System.out.println();

        FileReadWrite.writeToFile(students, "failed.txt");

        ArrayList<String> courses = new ArrayList<>(List.of("Test"));
        courses.add("Math");
        courses.add("Mike");
        courses.add("Garman");
        TestStrategyPattern testStrategyPattern = new TestStrategyPattern();
        testStrategyPattern.test(courses);

        AddToCourseList addToCourseList = new AddToCourseList();
        addToCourseList.addToList(students);
    }
}