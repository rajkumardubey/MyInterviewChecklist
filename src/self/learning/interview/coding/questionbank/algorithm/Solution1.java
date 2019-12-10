package self.learning.interview.coding.questionbank.algorithm;

import java.util.Scanner;

public class Solution1 {
    private static int findFloorSquareRoot(final int inputNumber) {
        // Write your code here
        if (inputNumber == 0 || inputNumber == 1) return inputNumber;

        /* Do Binary Search for floor(sqrt(inputNumber)) */
        long start = 1, end = inputNumber / 2, ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            // System.out.println(String.format("input number = %s, start = %s, end = %s, mid = %s, mid*mid = %s", inputNumber, start, end, mid, (long) mid * mid));
            /* If inputNumber is inputNumber perfect square */
            if (mid * mid == inputNumber) return (int) mid;

            /* Since we need floor, we update answer
             * when mid*mid is smaller than inputNumber,
             * and move closer to sqrt(inputNumber) */
            if (mid * mid < inputNumber) {
                start = mid + 1;
                ans = mid;
            } else {
                /* If mid*mid is greater than inputNumber */
                end = mid - 1;
            }
        }
        return (int) ans;
    }

    // Driver Method
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int input = scanner.nextInt();
        System.out.println(findFloorSquareRoot(input));
    }
}
