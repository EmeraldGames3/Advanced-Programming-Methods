package Ex1;

import java.util.Arrays;

public class Ex1 {

    // Return an array of failing grades
    public static int[] getFailingGrades(int[] grades) {
        if (grades == null) {
            throw new IllegalArgumentException("Array is null");
        }

        return Arrays.stream(grades)
                .filter(grade -> grade < 40)
                .toArray();
    }

    // Calculate and return the average grade
    public static double calculateAverage(int[] grades) {
        if (grades == null || grades.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int sum = Arrays.stream(grades).sum();
        return (double) sum / grades.length;
    }

    // Round the grades according to specific rules and return an array of rounded grades
    public static int[] roundGrades(int[] grades) {
        if (grades == null) {
            throw new IllegalArgumentException("Array is null");
        }

        return Arrays.stream(grades)
                .map(grade -> (grade < 38 || grade % 5 < 3) ? grade : grade + (5 - grade % 5))
                .toArray();
    }

    // Find and return the maximum rounded grade
    public static int getMaxRoundedGrade(int[] grades) {
        if (grades == null || grades.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        int maxRoundedGrade = Integer.MIN_VALUE;

        for (int grade : grades) {
            // Check if the grade should be rounded and track the maximum rounded grade
            int roundedGrade = (grade < 38 || grade % 5 < 3) ? grade : grade + (5 - grade % 5);
            maxRoundedGrade = Math.max(maxRoundedGrade, roundedGrade);
        }

        return maxRoundedGrade;
    }

    public static void getRoundedGrades(int[] grades) {
    }
}
