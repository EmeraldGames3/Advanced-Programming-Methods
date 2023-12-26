import static Utils.MyMath.isPalindrome;

public class _4 {
    /***
     *  A palindromic number reads the same both ways.
     *  The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 * 99.
     *  Find the largest palindrome made from the product of two 3-digit numbers.
     ***/
    public static void main(String[] args) {
        int largestPalindrome = 0;

        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                int product = i * j;

                if (product <= largestPalindrome)
                    break;

                if (isPalindrome(product))
                    largestPalindrome = product;
            }
        }

        System.out.println(largestPalindrome);
    }
}
