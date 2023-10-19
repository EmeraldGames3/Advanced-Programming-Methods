package Ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Ex2Test {

    private static final String TEST_ONE = "Biggest Number";
    private static final String TEST_TWO = "Smallest Number";
    private static final String TEST_THREE = "Maximum n-1 Sum";
    private static final String TEST_FOUR = "Minimum n-1 Sum";

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testFindBiggestNr() {
        int[] arr = {1, 2, -3, 4, 5, 124};
        int expected = 124;
        int result = Ex2.findMax(arr);

        try {
            // Check if the biggest number is correctly found
            Assertions.assertEquals(expected, result);
            System.out.println(TEST_ONE + " was successful");
        } catch (AssertionError e) {
            System.out.println(TEST_ONE + " has failed");
        }
    }

    @Test
    public void testFindBiggestNrFail() {
        int[] arr = {};
        try {
            // Check if the function correctly handles an empty array
            int result = Ex2.findMax(arr);
            System.out.println(TEST_ONE + " has failed");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_ONE + " was successful");
        }
    }

    @Test
    public void testFindMinNumber() {
        int[] arr = {1, 2, -3, 4, 5, 124};
        int expected = -3;
        int result = Ex2.findMin(arr);

        try {
            // Check if the smallest number is correctly found
            Assertions.assertEquals(expected, result);
            System.out.println(TEST_TWO + " was successful");
        } catch (AssertionError e) {
            System.out.println(TEST_TWO + " has failed");
        }
    }

    @Test
    public void testFindMinNumberFail() {
        int[] arr = {};
        try {
            // Check if the function correctly handles an empty array
            int result = Ex2.findMin(arr);
            System.out.println(TEST_TWO + " has failed");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_TWO + " was successful");
        }
    }

    @Test
    public void testMaxSum() {
        int[] arr = {4, -1, 3};
        int expected = 7;
        int result = Ex2.findMaxSumOfNMinusOne(arr);

        try {
            // Check if the maximum sum of n-1 numbers is correctly calculated
            Assertions.assertEquals(expected, result);
            System.out.println(TEST_THREE + " was successful");
        } catch (AssertionError e) {
            System.out.println(TEST_THREE + " has failed");
        }
    }

    @Test
    public void testMaxSumFail() {
        int[] arr = {};
        try {
            // Check if the function correctly handles an empty array
            int result = Ex2.findMaxSumOfNMinusOne(arr);
            System.out.println(TEST_THREE + " has failed");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_THREE + " was successful");
        }
    }

    @Test
    public void testMinSum() {
        int[] arr = {4, -1, 3};
        int expected = 2;
        int result = Ex2.findMinSumOfNMinusOne(arr);

        try {
            // Check if the minimum sum of n-1 numbers is correctly calculated
            Assertions.assertEquals(expected, result);
            System.out.println(TEST_FOUR + " was successful");
        } catch (AssertionError e) {
            System.out.println(TEST_FOUR + " has failed");
        }
    }

    @Test
    public void testMinSumFail() {
        int[] arr = {};
        try {
            // Check if the function correctly handles an empty array
            int result = Ex2.findMinSumOfNMinusOne(arr);
            System.out.println(TEST_FOUR + " has failed");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_FOUR + " was successful");
        }
    }
}
