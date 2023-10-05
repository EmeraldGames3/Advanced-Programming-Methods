public class WordCount {
    public static int wordCount(String s) {
        int nrWords = 0;
        for (int l = 0; l < s.length(); l++) {
            if (s.charAt(l) == ' ') {
                nrWords++;
            }
        }
        return nrWords + 1;
    }
}
