package self.learning.interview.coding;

/*
 <b>Problem Statement</b>
    Input two words returns the shortest distance between their two midpoints in number of characters
    Words can appear multiple times in any order and should be case insensitive.
    E.g. for the document="Example we just made up" shortestDistance( document, "we", "just" ) == 4
 */
class Solution {
    public double shortestDistance(final String document, String word1, String word2) {
        final String[] words = document.split("[,. ]");

        int wordCount = 0;
        double wordOneCount = 0;
        double wordTwoCount = 0;
        double shortestDistance = Double.MAX_VALUE;
        for (String word : words) {
            if (word.equalsIgnoreCase(word1)) wordOneCount = wordCount + (word.length() / 2d);
            else if (word.equalsIgnoreCase(word2)) wordTwoCount = wordCount + (word.length() / 2d);

            if (wordOneCount > 0 && wordTwoCount > 0) {
                shortestDistance = Math.min(shortestDistance, Math.abs(wordTwoCount - wordOneCount));
            }

            wordCount += word.length() + 1;
        }

        System.out.println(String.format("Word1 : %s, word2: %s, distance: %s", word1, word2, shortestDistance));

        return shortestDistance;
    }

}


public class DistanceBetweenTwoWords {
    private static final String document;

    static {
        final StringBuffer sb = new StringBuffer();
        sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
        sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
        sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

        document = sb.toString();
    }

    public static boolean pass(Solution sol) {
        return sol.shortestDistance(document, "and", "graphic") == 6d &&
                sol.shortestDistance(document, "transfer", "it") == 14d &&
                sol.shortestDistance(document, "Design", "filler") == 25d;
    }

    public static void main(String[] args) {
        final Solution sol = new Solution();
        if (pass(sol)) System.out.println("Pass");
        else System.out.println("Some Fail");
    }

}
