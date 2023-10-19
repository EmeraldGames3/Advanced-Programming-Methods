package Ex3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ex3Test {

    private static final String TEST_ONE = "Sum of numbers in arrays";
    private static final String TEST_TWO = "Difference of numbers in arrays";
    private static final String TEST_THREE = "Multiplication of number in array with integer";
    private static final String TEST_FOUR = "Division of number in array with integer";

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testAddition() {
        int[] number1 = {1, 3, 0, 0, 0, 0, 0, 0, 0};
        int[] number2 = {8, 7, 0, 0, 0, 0, 0, 0, 0};
        int[] expectedResult = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        try {
            int[] result = Ex3.sum(number1, number2);
            Assertions.assertArrayEquals(expectedResult, result);
            System.out.println(TEST_ONE + " was successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_ONE + " failed: " + e.getMessage());
        }
    }

    @Test
    public void testAdditionFail() {
        int[] number1 = {};

        int[] number2 = {};

        try {
            Ex3.sum(number1, number2);
            System.out.println(TEST_ONE + " was successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_ONE + " failed: " + e.getMessage());
        }
    }

    @Test
    public void testSubtraction() {
        int[] number1 = {8, 3, 0, 0, 0, 0, 0};
        int[] number2 = {5, 4, 0, 0, 0, 0, 0};
        int[] expectedResult = {2, 9, 0, 0, 0, 0, 0};

        try {
            int[] result = Ex3.subtract(number1, number2);
            Assertions.assertArrayEquals(expectedResult, result);
            System.out.println(TEST_TWO + " was successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_TWO + " failed: " + e.getMessage());
        }
    }

    @Test
    public void testSubtractionFail() {
        int[] number1 = {};
        int[] number2 = {};

        try {
            Ex3.subtract(number1, number2);
            System.out.println(TEST_TWO + " was successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_TWO + " failed: " + e.getMessage());
        }
    }

    @Test
    public void testMultiplication() {
        int[] number = {2, 3, 6, 0, 0, 0, 0, 0, 0};
        int integer = 2;
        int[] expectedResult = {4, 7, 2, 0, 0, 0, 0, 0, 0};

        try {
            int[] result = Ex3.multiply(number, integer);
            Assertions.assertArrayEquals(expectedResult, result);
            System.out.println(TEST_THREE + " was successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_THREE + " failed: " + e.getMessage());
        }
    }

    @Test
    public void testMultiplicationFail() {
        int[] number = {};
        int integer = 0;

        try {
            Ex3.multiply(number, integer);
            System.out.println(TEST_THREE + " was successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_THREE + " failed: " + e.getMessage());
        }
    }

    @Test
    public void testDivision() {
        int[] number = {2, 3, 6, 0, 0, 0, 0, 0, 0};
        int divisor = 2;
        int[] expectedResult = {1, 1, 8, 0, 0, 0, 0, 0, 0};

        try {
            int[] result = Ex3.divide(number, divisor);
            Assertions.assertArrayEquals(expectedResult, result);
            System.out.println(TEST_FOUR + " was successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_FOUR + " failed: " + e.getMessage());
        }
    }

    @Test
    public void testDivisionFail() {
        int[] number = {};
        int divisor = 0;

        try {
            Ex3.divide(number, divisor);
            System.out.println(TEST_FOUR + " was successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_FOUR + " failed: " + e.getMessage());
        }
    }
}