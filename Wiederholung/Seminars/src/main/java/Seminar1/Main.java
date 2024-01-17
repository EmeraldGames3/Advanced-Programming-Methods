package Seminar1;

public class Main {
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    public static int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }
        String[] words = sentence.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        // Example usage of reverseString and countWords
        String exampleString = "Hello World";
        System.out.println("Reversed String: " + reverseString(exampleString));
        System.out.println("Word Count: " + countWords(exampleString));
    }
}
