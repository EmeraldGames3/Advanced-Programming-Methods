package org.example;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static boolean isPerfect(long number) {
        long sum = 1;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return number == sum && number != 1;
    }

    public static void main(String[] args) throws Exception {
        // A. Sum of all odd numbers in an array
        long[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        long sumOfOdds = Arrays.stream(numbers)
                .filter(n -> n % 2 != 0)
                .sum();
        System.out.println("Sum of odd numbers: " + sumOfOdds);
        System.out.println();

        // B. Product of all squared numbers in an array
        long productOfSquares = Arrays.stream(numbers)
                .map(n -> n * n)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product of squares: " + productOfSquares);
        System.out.println();

        // C. Maximum of all perfect numbers in an array
        long[] perfectNumbers = {6, 28, 496, 8128, 33550336, 7, 10};
        long maxPerfectNumber = Arrays.stream(perfectNumbers)
                .filter(Main::isPerfect)
                .max()
                .orElse(-1);
        System.out.println("Maximum perfect number: " + maxPerfectNumber);
        System.out.println();

        // D. Students with the best grade
        List<Pair<Student, Integer>> studentGrades = List.of(
                new Pair<>(new Student("Alice", "University A"), 90),
                new Pair<>(new Student("Bob", "University B"), 85),
                new Pair<>(new Student("Charlie", "University A"), 90),
                new Pair<>(new Student("Diana", "University C"), 95),
                new Pair<>(new Student("Eve", "University C"), 95)
        );

        // Find the highest grade
        int maxGrade = studentGrades.stream()
                .mapToInt(Pair::getSecond)
                .max()
                .getAsInt();

        // Filter students with the top grade
        List<Student> bestGradedStudents = studentGrades.stream()
                .filter(pair -> pair.getSecond() == maxGrade)
                .map(Pair::getFirst)
                .toList();

        // Print the students with the top grade
        System.out.println("Students with the top grade:");
        bestGradedStudents.forEach(student ->
                System.out.println(student.getName() + " from " + student.getUniversity()));
        System.out.println();

        // E. Number of Students from each University
        List<Student> students = List.of(
                new Student("Alice", "University A"),
                new Student("Bob", "University B"),
                new Student("Charlie", "University A"),
                new Student("Diana", "University C"),
                new Student("Eve", "University C")
        );

        // Count the number of students from each university
        List<Pair<String, Long>> studentsPerUniversity = students.stream()
                .collect(Collectors.groupingBy(Student::getUniversity, Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry -> new Pair<>(entry.getKey(), entry.getValue()))
                .toList();

        System.out.println("Number of students from each university:");
        studentsPerUniversity.forEach(pair ->
                System.out.println(pair.getFirst() + ": " + pair.getSecond()));
        System.out.println();

        // F. Median of all grades per course
        List<Student> studentsWithGrades = List.of(
                new Student("Alice", "University A", "Mathematics", 69),
                new Student("Bob", "University B", "Mathematics", 85),
                new Student("Charlie", "University A", "Mathematics", 90),
                new Student("Diana", "University C", "Mathematics", 95),
                new Student("Eve", "University C", "Rizzics", 95),
                new Student("Alice", "University A", "Physics", 68),
                new Student("Bob", "University B", "Physics", 79),
                new Student("Charlie", "University A", "Rizzics", 88),
                new Student("Diana", "University C", "Physics", 85),
                new Student("Eve", "University C", "Rizzics", 85)
        );

        // Group students by course
        Map<String, List<Integer>> groupedByCourse = new HashMap<>();
        for (Student student : studentsWithGrades) {
            String course = student.getCourse().getFirst();
            Integer grade = student.getCourse().getSecond();
            groupedByCourse.computeIfAbsent(course, k -> new ArrayList<>()).add(grade);
        }

        // Calculate median grade for each course
        Map<String, Double> medianGrades = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : groupedByCourse.entrySet()) {
            List<Integer> grades = entry.getValue();
            Collections.sort(grades);
            int middle = grades.size() / 2;
            double median = grades.size() % 2 == 1 ?
                    (double) grades.get(middle) :
                    (grades.get(middle - 1) + grades.get(middle)) / 2.0;
            medianGrades.put(entry.getKey(), median);
        }

        // Print the median grade for each course
        System.out.println("Median grade per course:");
        medianGrades.forEach((course, median) -> System.out.println(course + ": " + median));
    }
}