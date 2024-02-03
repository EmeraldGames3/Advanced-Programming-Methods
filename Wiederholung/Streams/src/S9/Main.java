package S9;

import java.util.*;
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
                .reduce(Integer::sum)
                .orElse(0);
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
                .mapToInt(Pair::getSecond) // Map to int to use later
                .average() // Calculates the average
                .orElse(0); // In case the list is empty, default to 0

        System.out.println("Mean grade: " + meanNotes);

        List<Integer> numbers1 = Arrays.asList(100, 50, 100, 50);
        System.out.println((numbers1.stream().mapToInt(x -> x).average().orElse(0)));

        List<Pair<String, Integer>> people = List.of(
                new Pair<>("Alice", 30),
                new Pair<>("Bob", 30),
                new Pair<>("Charlie", 25)
        );

        // Group people by age
        Map<Integer, List<String>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(
                        Pair::getSecond,
                        Collectors.mapping(Pair::getFirst, Collectors.toList())));

        System.out.println(peopleByAge);

        // Create a map of names to ages and print it
        var temp = people.stream()
                .collect(Collectors.toMap(Pair::getFirst, Pair::getSecond));
        System.out.println(temp);

        // Print each age
        var t = temp.values().stream()
                .mapToInt(p -> p) // Convert to an IntStream
                .min().orElse(0);
        System.out.println(t);
    }
}