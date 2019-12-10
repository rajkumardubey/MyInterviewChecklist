package self.learning.interview.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestUniformString {
    private static final Map<String, int[]> testCases = new HashMap<>();

    private static int[] longestUniformSubstring(final String input) {
        int longestStart = -1;
        int longestLength = 0;

        // your code goes here
        Character previousChar = null;
        int uniformCharCount = 0;
        int charStart = -1;
        int counter = 0;
        for (Character ch : input.toCharArray()) {
            if (ch.equals(previousChar)) {
                uniformCharCount++;
            } else {
                charStart = counter;
                uniformCharCount = 1;
                previousChar = ch;
            }

            if (uniformCharCount > longestLength) {
                longestLength = uniformCharCount;
                longestStart = charStart;
            }
            counter++;
        }

        // For debugging
        // System.out.println(String.format("String: %s, longestStart: %s, longestLength: %s", input, longestStart, longestLength));

        return new int[]{longestStart, longestLength};
    }

    public static void main(String[] args) {
        testCases.put("", new int[]{-1, 0});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("aabbbbbCdAA", new int[]{2, 5});

        boolean pass = true;
        for (Map.Entry<String, int[]> testCase : testCases.entrySet()) {
            int[] result = longestUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if (pass) {
            System.out.println("Pass!");
        } else {
            System.out.println("Failed! ");
        }
    }
}
