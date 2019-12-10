package self.learning.interview.coding.questionbank.algorithm;

import java.util.Scanner;

public class Solution2 {
    /* Returns the best obtainable price for price[]
     * as prices of different packets of potatoes */
    private static int bestObtainablePrice(final int[] price, final int hasToSell) {
        final int[] result = new int[hasToSell + 1];
        result[0] = 0;

        /* Build the table result[] in bottom up manner and return the last entry from the table */
        for (int i = 1; i <= hasToSell; i++) {
            int maxValue = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                maxValue = Math.max(maxValue, price[j] + result[i - j - 1]);
            }

            result[i] = maxValue;
        }

        return result[hasToSell];
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        final Scanner consoleReader = new Scanner(System.in);

        final int arraySize = consoleReader.nextInt();
        final int[] price = new int[arraySize];
        for (int index = 0; index < arraySize; index++) {
            price[index] = consoleReader.nextInt();
        }

        System.out.println(bestObtainablePrice(price, price.length));
    }
}
