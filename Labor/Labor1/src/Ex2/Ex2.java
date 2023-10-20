package Ex2;

public class Ex2 {
    // Find the maximum number in the array
    public static int findMax(int[] numbers) {
        if (numbers.length == 0)
            throw new IllegalArgumentException("Array is empty");

        int max = numbers[0];

        for (int number : numbers) {
            // If the current number is greater than max, update max
            max = Math.max(number, max);
        }

        return max;
    }

    // Find the minimum number in the array
    public static int findMin(int[] numbers) {
        if (numbers.length == 0)
            throw new IllegalArgumentException("Array is empty");

        int min = numbers[0];

        for (int number : numbers) {
            // If the current number is less than min, update min
            min = Math.min(number, min);
        }

        return min;
    }

    // Find the maximum sum of n-1 numbers
    public static int findMaxSumOfNMinusOne(int[] numbers) {
        if (numbers.length == 0)
            throw new IllegalArgumentException("Array is empty");

        int sum = 0;
        int min = numbers[0];

        for (int number : numbers) {
            // If the current number is less than min, update min
            min = Math.min(number, min);
            // Add the current number to the sum
            sum += number;
        }

        // Subtract the minimum number from the sum
        return sum - min;
    }

    // Find the minimum sum of n-1 numbers
    public static int findMinSumOfNMinusOne(int[] numbers) {
        if (numbers.length == 0)
            throw new IllegalArgumentException("Array is empty");

        int sum = 0;
        int max = numbers[0];

        for (int number : numbers) {
            // If the current number is greater than max, update max
            max = Math.max(number, max);
            // Add the current number to the sum
            sum += number;
        }

        // Subtract the maximum number from the sum
        return sum - max;
    }
}
