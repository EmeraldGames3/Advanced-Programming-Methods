public class MatheAufgabe {
    public static int add(int x, int y) {
        return x + y;
    }

    public static int sub(int x, int y) {
        return x - y;
    }

    public static int mul(int x, int y) {
        int result = 0;
        for (int i = 0; i < y; i++) {
            result += x;
        }
        return result;
    }

    public static boolean isPerfect(int x) {
        int s = 1;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                s += i;
            }
        }
        return x == s;
    }
}
