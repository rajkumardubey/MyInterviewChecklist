package self.learning.interview.coding;

import java.util.Arrays;

/**
 * Given two fractions passed in as int arrays,
 * returns the fraction which is result of adding the two input fractions.
 */

public class FractionAddition {
    private static int[] addFractions(int[] fraction1, int[] fraction2) {
        // Write your code here
        if (fraction1.length < 2 || fraction2.length < 2) {
            System.out.println("Wrong Input");
            return (new int[]{0, 0});
        } else {
            final int lcm = lcm(fraction1[1], fraction2[1]);
            final int numeratorSum = fraction1[0] * lcm / fraction1[1] + fraction2[0] * lcm / fraction2[1];
            return (new int[]{numeratorSum, lcm});
        }
    }

    private static int gcd(int number1, int number2) {
        if (number2 == 0) return number1; //base case
        return gcd(number2, number1 % number2);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int[] result = addFractions(new int[]{2, 3}, new int[]{1, 2});

        System.out.println(Arrays.toString(result));
        if (result[0] == 7 && result[1] == 6) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed.");
        }
    }

}
