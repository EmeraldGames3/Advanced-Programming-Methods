package Utils;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class MyMath {
    public static boolean isPrime(long number) {
        if (number <= 1)
            return false;
        if (number <= 3)
            return true;
        if (number % 2 == 0 || number % 3 == 0)
            return false;

        for (long i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0)
                return false;
        }

        return true;
    }


    // Calculate the greatest common divisor (GCD)
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Calculate the least common multiple (LCM)
    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static ArrayList<Pair<Integer, Integer>> divideInPrimeFactors(int number){
        ArrayList<Pair<Integer, Integer>> primesAndFactors = new ArrayList<>();

        for(int i = 2; i <= number; i++){
            if(number % i == 0){
                int counter = 0;
                while (number % i == 0 && number != 0){
                    number /= i;
                    counter++;
                }
                primesAndFactors.add(new Pair<>(i, counter));
            }
        }

        return primesAndFactors;
    }

    public static boolean isPalindrome(long number) {
        String original = Long.toString(number);
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }

    public static List<Integer> Fibonacci(int limit) {
        List<Integer> fibonacciList = new ArrayList<>();
        int a = 1, b = 1;
        while (a <= limit) {
            fibonacciList.add(a);
            int c = a + b;
            a = b;
            b = c;
        }

        return fibonacciList;
    }
}
