package S9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static boolean isPerfect(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        int sumUngerade = numbers
                .stream()
                .filter(n -> n % 2 == 1)
                .reduce(0, (sum, number) -> sum + number);
        System.out.println(sumUngerade);

        int multiplySquares = numbers.stream()
                .filter(n -> Math.pow(Math.sqrt(n), 2) == n)
                .reduce(1, (mul, number) -> mul * number);
        System.out.println(multiplySquares);

        int maxPerfectNumber = numbers
                .stream()
                .filter(Main::isPerfect)
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println(maxPerfectNumber);

        List<Pair<Student, Integer>> studentGrades = new ArrayList<>();
        studentGrades.add(new Pair<>(new Student("Alice", "University A"), 90));
        studentGrades.add(new Pair<>(new Student("Bob", "University B"), 85));
        studentGrades.add(new Pair<>(new Student("Dob", "University A"), 75));
        studentGrades.add(new Pair<>(new Student("Cob", "University C"), 95));
        studentGrades.add(new Pair<>(new Student("Zob", "University C"), 100));

        Student bestStudent = studentGrades.stream()
                .max(Comparator.comparingInt(Pair::getSecond))
                .map(Pair::getFirst)
                .orElse(null);
        System.out.println(bestStudent);

        System.out.println();

        Map<String, Long> universityStudentsCounts = studentGrades.stream()
                .map(pair -> pair.getFirst().getUniversity())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        universityStudentsCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // Sorting by university names (keys)
                .forEach(entry ->
                        System.out.println("University: " + entry.getKey() + ", Number of Students: " + entry.getValue())
                );

        System.out.println();

        universityStudentsCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // Sorting by the count of students in descending order
                .forEach(entry ->
                        System.out.println("University: " + entry.getKey() + ", Number of Students: " + entry.getValue())
                );

        double meanNotes = studentGrades.stream()
                .mapToInt(Pair::getSecond) // Map to int to use sum() later
                .average() // Calculates the average
                .orElse(0); // In case the list is empty, default to 0

        System.out.println("Mean grade: " + meanNotes);
    }
}