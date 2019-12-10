package self.learning.interview.coding;

import java.util.Arrays;

public class SmallestNumber {
    private static int findMin(final int[] input) {
        if (input == null) return 0; // return value can be anything & must me provided by the interviewer
        return Arrays.stream(input).min().orElse(0);
    }

    public static void main(String[] args) {
        boolean result;
        result = findMin(new int[]{3, 4, 5, 6, 1, 2}) == 1;
        result = result && findMin(new int[]{2, 1}) == 1;
        result = result && findMin(new int[]{1}) == 1;

        try {
            findMin(null);
            result = false;
        } catch (Exception ignored) {

        }

        if (result) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}
