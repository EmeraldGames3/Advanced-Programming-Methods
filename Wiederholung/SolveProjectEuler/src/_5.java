import Utils.MyMath;

public class _5 {
    /***
     *  2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
     *  What is the smallest positive number that is divisible with no remainder by all the numbers from 1 to 20?
     ***/
    public static void main(String[] args) {
        long result = 1;

        for (long i = 1; i <= 20; i++)
            result = MyMath.lcm(result, i);

        System.out.println(result);
    }
}
