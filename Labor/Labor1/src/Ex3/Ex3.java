package Ex3;

public class Ex3 {

    // Addition of two large numbers represented as arrays
    public static int[] sum(int[] number1, int[] number2) {
        // Validate input
        if (number1 == null || number2 == null || number1.length != number2.length || number1.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int n = number1.length;
        int[] result = new int[n + 1];
        int carry = 0;

        // Iterate from the least significant digit to the most significant digit
        for (int i = n - 1; i >= 0; i--) {
            int sum = number1[i] + number2[i] + carry;
            result[i + 1] = sum % 10;  // Store the least significant digit of the sum
            carry = sum / 10;  // Update the carry
        }

        if (carry > 0) {
            result[0] = carry;  // If there's a carry after all digits, store it as the most significant digit.
        }

        return result;
    }

    // Subtraction of two large numbers represented as arrays
    public static int[] subtract(int[] number1, int[] number2) {
        // Validate input
        if (number1 == null || number2 == null || number1.length != number2.length || number1.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int n = number1.length;
        int[] result = new int[n];
        int borrow = 0;

        // Iterate from the least significant digit to the most significant digit
        for (int i = n - 1; i >= 0; i--) {
            int difference = number1[i] - number2[i] - borrow;

            if (difference < 0) {
                difference += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result[i] = difference;
        }

        return result;
    }

    // Multiplication of a large number array by a digit
    public static int[] multiply(int[] number1, int digit) {
        // Validate input
        if (number1 == null || number1.length == 0 || digit < 0 || digit > 9) {
            throw new IllegalArgumentException("Invalid input");
        }

        int n = number1.length;
        int[] result = new int[n];
        int carry = 0;

        // Iterate from the most significant digit to the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            int product = number1[i] * digit + carry;
            result[i] = product % 10;  // Store the least significant digit of the product
            carry = product / 10;  // Update the carry
        }

        if (carry > 0) {
            result = addLeadingDigit(result, carry);  // Add carry as a leading digit if it exists
        }

        return result;
    }

    // Integer division of a large number array by a digit
    public static int[] divide(int[] num1, int divisor) {
        // Validate input
        if (num1 == null || num1.length == 0 || divisor == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int n = num1.length;
        int[] result = new int[n];
        int remainder = 0;

        // Iterate from the least significant digit to the most significant digit
        for (int i = 0; i < n; i++) {
            int currentDigit = num1[i] + remainder * 10;
            result[i] = currentDigit / divisor;
            remainder = currentDigit % divisor;
        }

        return result;
    }

    // Helper method to add a leading digit to an array
    private static int[] addLeadingDigit(int[] array, int digit) {
        int[] newArray = new int[array.length + 1];
        newArray[0] = digit;
        System.arraycopy(array, 0, newArray, 1, array.length);
        return newArray;
    }
}