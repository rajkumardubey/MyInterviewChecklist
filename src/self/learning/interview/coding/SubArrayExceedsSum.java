package self.learning.interview.coding;

import java.util.Arrays;

public class SubArrayExceedsSum {

    private static int subArrayExceedsSum(final int[] input, int target) {
        int currentSum = 0;
        final int length = input.length;
        int minimumLength = length + 1;
        int start = 0, end = 0;

        while (end < length) {
            while (currentSum <= target && end < length)
                currentSum += input[end++];

            while (currentSum > target && start < length) {
                if (end - start < minimumLength) minimumLength = end - start;

                currentSum -= input[start++];
            }
        }
        System.out.print(Arrays.toString(input) + " target: " + target + ", minimum Length : " + minimumLength + "\n");
        return minimumLength > length ? -1 : minimumLength;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        boolean result = true;
        int[] arr = {1, 2, 3, 4};
        result = result && subArrayExceedsSum(arr, 6) == 2;
        result = result && subArrayExceedsSum(arr, 12) == -1;

        if (result) {
            System.out.println("All tests pass\n");
        } else {
            System.out.println("There are test failures\n");
        }
    }
}
