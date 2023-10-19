package Ex4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Ex4Test {

    private static final String TEST_ONE = "Find cheapest keyboard";
    private static final String TEST_TWO = "Find most expensive product";
    private static final String TEST_THREE = "Find most expensive USB drive";
    private static final String TEST_FOUR = "Calculate total cost";

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testFindCheapestKeyboard() {
        int[] keyboards = {40, 50, 60};
        int expected = 40;

        int result = Ex4.findCheapestKeyboard(keyboards);

        try {
            Assertions.assertEquals(expected, result);
            System.out.println(TEST_ONE + " successful");
        } catch (AssertionError e) {
            System.out.println(TEST_ONE + " failed");
        }
    }

    @Test
    public void testFindCheapestKeyboardFail() {
        int[] keyboards = {};
        try {
            assertThrows(IllegalArgumentException.class, () -> Ex4.findCheapestKeyboard(keyboards));
            System.out.println(TEST_ONE + " successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_ONE + " failed");
        }
    }

    @Test
    public void testFindMostExpensiveProduct() {
        int[] keyboard = {120, 40, 66};
        int[] drives = {15, 89, 25};
        int expected = 120;

        int result = Ex4.findMostExpensiveItem(keyboard, drives);

        try {
            Assertions.assertEquals(expected, result);
            System.out.println(TEST_TWO + " successful");
        } catch (AssertionError e) {
            System.out.println(TEST_TWO + " failed");
        }
    }

    @Test
    public void testFindMostExpensiveProductFail() {
        int[] keyboard = {};
        int[] drives = {};
        try {
            assertThrows(IllegalArgumentException.class, () -> Ex4.findMostExpensiveItem(keyboard, drives));
            System.out.println(TEST_TWO + " successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_TWO + " failed");
        }
    }

    @Test
    public void testFindMostExpensiveDrive() {
        int[] drives = {15, 45, 20};
        int budget = 30;
        int expected = 20;

        int result = Ex4.findMostExpensiveDrives(drives, budget);

        try {
            Assertions.assertEquals(expected, result);
            System.out.println(TEST_THREE + " successful");
        } catch (AssertionError e) {
            System.out.println(TEST_THREE + " failed");
        }
    }

    @Test
    public void testFindMostExpensiveDriveFail() {
        int[] drives = {};
        int budget = 20;
        try {
            assertThrows(IllegalArgumentException.class, () -> Ex4.findMostExpensiveDrives(drives, budget));
            System.out.println(TEST_THREE + " successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_THREE + " failed");
        }
    }

    @Test
    public void testBudget() {
        int[] keyboards = {40, 50, 60};
        int[] usbDrives = {8, 12};
        int budget = 60;
        int expected = 58;

        int result = Ex4.calculateTotalCost(budget, keyboards, usbDrives);

        try {
            Assertions.assertEquals(expected, result);
            System.out.println(TEST_FOUR + " successful");
        } catch (AssertionError e) {
            System.out.println(TEST_FOUR + " failed");
        }
    }

    @Test
    public void testBudgetFail() {
        int[] keyboards = {};
        int[] usbDrives = {};
        int budget = 60;
        try {
            assertThrows(IllegalArgumentException.class, () -> Ex4.calculateTotalCost(budget, keyboards, usbDrives));
            System.out.println(TEST_FOUR + " successful");
        } catch (IllegalArgumentException e) {
            System.out.println(TEST_FOUR + " failed");
        }
    }
}