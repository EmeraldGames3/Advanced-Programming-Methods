package range1_10;

import Utils.MyMath;

public class _7 {
    /***
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
     * What is the 10001st prime number?
     ***/
    public static void main(String[] args) {
        int counter = 0;
        long i = 0;

        while (counter < 10_001){
            i++;
            if(MyMath.isPrime(i)){
                counter++;
            }
        }

        System.out.println(i);
    }
}
