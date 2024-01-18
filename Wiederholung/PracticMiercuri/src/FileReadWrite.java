import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class FileReadWrite {
    public static ArrayList<Student> readFromFile(String filepath) throws IOException {
        return Files.lines(Path.of(filepath))
                .map(Student::parseStudent)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void writeToFile(ArrayList<Student> students, String filepath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));

        students.stream()
                .filter(student -> "Failed".equals(student.getStatus()))
                .map(Student::getStudent_id)
                .forEach(s -> {
                    try {
                        bw.write(s.toString());
                        bw.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        bw.close();
    }
}
