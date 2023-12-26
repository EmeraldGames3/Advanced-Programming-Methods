public class _3 {
    /***
     *  The prime factors of 13195 are 5, 7, 13 and 29.
     *  What is the largest prime factor of the number 600851475143?
     ***/
    public static void main(String[] args) {
        long number = 600851475143L;
        long maxPrime;

        for (long i = 2; i * i <= number; i++) {
            while (number % i == 0) {
                number /= i;
            }
        }

        maxPrime = number;

        System.out.println(maxPrime);
    }
}
