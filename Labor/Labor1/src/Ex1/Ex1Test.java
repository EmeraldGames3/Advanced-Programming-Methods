package Ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Ex1.Ex1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

public class Ex1Test {

    private static final String TEST_ONE = "Failing Grades Test";
    private static final String TEST_TWO = "Average Grade Test";
    private static final String TEST_THREE = "Rounded Grades Test";
    private static final String TEST_FOUR = "Max Rounded Grade Test";

    private static final String SUCCESSFUL = "was successful";
    private static final String FAILED = "has failed";

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testFailingGrades() {
        int[] grades = {84, 29, 72, 38, 41};
        int[] result = Ex1.getFailingGrades(grades);
        int[] expected = {29, 38};

        try {
            // Assert that the failing grades are correctly obtained
            Assertions.assertArrayEquals(expected, result);
            System.out.println(TEST_ONE + " " + SUCCESSFUL);
        } catch (AssertionError e) {
            System.out.println(TEST_ONE + " " + FAILED);
        }
    }

    @Test
    public void testFailingGradesNull() {
        int[] grades = {};

        try {
            // Assert that the method correctly handles a null array
            assertThrows(IllegalArgumentException.class, () -> Ex1.getFailingGrades(grades));
            System.out.println(TEST_ONE + " " + SUCCESSFUL);
        } catch (AssertionError e) {
            System.out.println(TEST_ONE + " " + FAILED);
        }
    }

    @Test
    public void testAverageGrade() {
        int[] grades = {84, 29, 72, 38, 41};
        double expected = 52.8;

        double result = Ex1.calculateAverage(grades);

        try {
            // Assert that the average grade is correctly calculated
            assertEquals(expected, result);
            System.out.println(TEST_TWO + " " + SUCCESSFUL);
        } catch (AssertionError e) {
            System.out.println(TEST_TWO + " " + FAILED);
        }
    }

    @Test
    public void testAverageGradeFail() {
        int[] grades = {};

        try {
            // Assert that the method correctly handles an empty or null array
            assertThrows(IllegalArgumentException.class, () -> Ex1.calculateAverage(grades));
            System.out.println(TEST_TWO + " " + SUCCESSFUL);
        } catch (AssertionError e) {
            System.out.println(TEST_TWO + " " + FAILED);
        }
    }

    @Test
    public void testRoundedGrades() {
        int[] grades = {84, 29, 72, 38, 41};
        int[] expected = {85, 29, 72, 40, 41};

        int[] result = Ex1.roundedGrades(grades);

        try {
            // Assert that the grades are correctly rounded
            Assertions.assertArrayEquals(expected, result);
            System.out.println(TEST_THREE + " " + SUCCESSFUL);
        } catch (AssertionError e) {
            System.out.println(TEST_THREE + " " + FAILED);
        }
    }

    @Test
    public void testRoundedGradesFail() {
        int[] grades = {};

        try {
            // Assert that the method correctly handles an empty or null array
            assertThrows(IllegalArgumentException.class, () -> Ex1.roundedGrades(grades));
            System.out.println(TEST_THREE + " " + SUCCESSFUL);
        } catch (AssertionError e) {
            System.out.println(TEST_THREE + " " + FAILED);
        }
    }

    @Test
    public void testMaxRoundedGrade() {
        int[] grades = {84, 29, 72, 38, 41};
        int expected = 85;

        int result = Ex1.getMaxRoundedGrade(grades);

        try {
            // Assert that the maximum rounded grade is correctly obtained
            Assertions.assertEquals(expected, result);
            System.out.println(TEST_FOUR + " " + SUCCESSFUL);
        } catch (AssertionError e) {
            System.out.println(TEST_FOUR + " " + FAILED);
        }
    }

    @Test
    public void testMaxRoundedGradeFail() {
        int[] grades = {};

        try {
            // Assert that the method correctly handles an empty or null array
            assertThrows(IllegalArgumentException.class, () -> Ex1.getMaxRoundedGrade(grades));
            System.out.println(TEST_FOUR + " " + SUCCESSFUL);
        } catch (AssertionError e) {
            System.out.println(TEST_FOUR + " " + FAILED);
        }
    }
}
