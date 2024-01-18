import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByCourse {
    public static void groupByCourse(ArrayList<Student> students) {
        students.stream()
                .collect(Collectors.groupingBy(Student::getCourse_code, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
