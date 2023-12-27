package range1_10;

public class _9 {
    /***
     *  A Pythagorean triplet is a set of three natural numbers,
     *  a < b < c, for which, a ^ 2 + b ^ 2 = c ^ 2.
     *  For example, 3 ^ 2 + 4 ^ 2 = 9 + 16 = 25 = 5 ^ 2.
     *  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
     *  Find the product a * b * c.
     ***/
    public static void main(String[] args) {
        // s = a + b + c
        // a ^ 2 + b ^ 2 = c ^ 2
        // b = (s ^ 2 - 2 a * s) / (2 * (s - a)) 

        int sum = 1000;
        int a, b = 0, c = 0;
        boolean found = false;

        for (a = 1; a < sum / 3; a++) {
            for (b = a; b < sum / 2; b++) {
                c = sum - a - b;
                if (a * a + b * b == c * c) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (found)
            System.out.println(a * b * c);
    }
}