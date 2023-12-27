package range1_10;

public class _1 {
    /***
     If we list all the natural numbers below that are multiples of or, we get and.
     The sum of these multiples is. Find the sum of all the multiples of or below 1000.
     ***/
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 3; i < 1000; i++) {
            if (i % 3 == 0)
                sum += i;
            else if (i % 5 == 0)
                sum += i;
        }

        System.out.println(sum); //234168
    }
}
