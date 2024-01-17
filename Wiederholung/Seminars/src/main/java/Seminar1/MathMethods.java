package Seminar1;

public class MathMethods {
    public int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public int subtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }

    public int multiply(int a, int b) {
        int result = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                result = add(result, a);
            }
            a <<= 1;
            b >>= 1;
        }
        return result;
    }
}