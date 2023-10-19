package Ex4;

import java.util.Arrays;

public class Ex4 {

    // Find the cheapest keyboard in the given array
    public static int findCheapestKeyboard(int[] keyboards) {
        if (keyboards == null) {
            throw new IllegalArgumentException("Array is null");
        }

        if (keyboards.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        // Sort the array to find the cheapest keyboard, then return it
        Arrays.sort(keyboards);
        return keyboards[0];
    }

    // Find the most expensive item between keyboards and USB drives
    public static int findMostExpensiveItem(int[] keyboards, int[] usbDrives) {
        if (keyboards == null || usbDrives == null) {
            throw new IllegalArgumentException("Array is null");
        }

        if (keyboards.length == 0 || usbDrives.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        // Find the maximum prices from keyboards and USB drives, and return the higher value
        int maxKeyboardPrice = Arrays.stream(keyboards).max().orElse(0);
        int maxUsbDrivePrice = Arrays.stream(usbDrives).max().orElse(0);

        return Math.max(maxKeyboardPrice, maxUsbDrivePrice);
    }

    // Find the most expensive USB drive that can be purchased within the given budget
    public static int findMostExpensiveDrives(int[] drives, int budget) {
        if (drives == null) {
            throw new IllegalArgumentException("Array is null");
        }

        if (drives.length == 0) {
            throw new  IllegalArgumentException("Array is empty");
        }

        // Sort the drives array in ascending order and then find the highest-priced drive within budget
        Arrays.sort(drives);
        for (int i = drives.length - 1; i >= 0; i--) {
            if (drives[i] <= budget) {
                return drives[i];
            }
        }

        // If no suitable drive is found, return -1
        return -1;
    }

    // Calculate the maximum total cost of buying a keyboard and a USB drive within the given budget
    public static int calculateTotalCost(int budget, int[] keyboards, int[] usbDrives) {
        if (keyboards == null || usbDrives == null) {
            throw new IllegalArgumentException("Array is null");
        }

        if (keyboards.length == 0 || usbDrives.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int maxCost = -1;

        // Iterate through all possible combinations of a keyboard and a USB drive
        for (int keyboard : keyboards) {
            for (int usbDrive : usbDrives) {
                int totalCost = keyboard + usbDrive;
                if (totalCost <= budget && totalCost > maxCost) {
                    maxCost = totalCost;
                }
            }
        }

        return maxCost;
    }
}
