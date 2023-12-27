package range1_10;

import Utils.MyMath;

public class _10 {
    /***
     *  The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
     *  Find the sum of all the primes below two million.
     ***/
    public static void main(String[] args) {
        long sum = 0;

        for (long i = 0; i < 2_000_000L; i++) {
            if (MyMath.isPrime(i))
                sum += i;
        }

        System.out.println(sum);
    }
}
