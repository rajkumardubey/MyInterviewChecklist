package self.learning.interview.coding;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueTouples {

    public static HashSet<String> uniqueTuples(final String input, final int len) {
        // your code
        HashSet<String> result = new HashSet<>();

        for (int index = 0; index < input.length() - len + 1; index++) {
            result.add(input.substring(index, index + len));
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "aab";
        String input1 = "abbccde";

        HashSet<String> result = uniqueTuples(input, 2);
        HashSet<String> result1 = uniqueTuples(input1, 2);

        if (result.contains("aa") && result.contains("ab")
                && (result1.containsAll(Arrays.asList("ab", "bb", "bc", "cc", "cd", "de")) && result1.size() == 6)) {
            System.out.println("Test passed.");

        } else {
            System.out.println("Test failed.");

        }
    }

}
