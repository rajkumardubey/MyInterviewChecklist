package self.learning.interview.coding.questionbank.algorithm;

import java.util.Scanner;

public class Solution6 {

    private static int optimalStrategy(final int[] pearls) {
        final int totalNumberOfPackets = pearls.length;

        /* base case: one packet left, only one choice possible */
        if (totalNumberOfPackets == 1) return pearls[0];

        /* if we're left with only two packet, choose one with maximum pearls */
        if (totalNumberOfPackets == 2) return Integer.max(pearls[0], pearls[1]);

        /* create a dynamic 2D matrix to store sub-problem solutions */
        final int[][] T = new int[totalNumberOfPackets][totalNumberOfPackets];

        for (int iteration = 0; iteration < totalNumberOfPackets; iteration++) {
            for (int i = 0, j = iteration; j < totalNumberOfPackets; i++, j++) {

                /*
                 * If player chooses front pearls i, opponent is left to choose from [i+1, j].
                 *      1. if opponent chooses front pearls i+1, recur for [i+2, j]
                 *      2. if opponent chooses rear pearls j, recur for [i+1, j-1]
                 */
                int start = pearls[i] +
                        Integer.min(calculate(T, i + 2, j), calculate(T, i + 1, j - 1));
                /*
                 * If player chooses front pearls J, opponent is left to choose from [i, j-1].
                 *      1. if opponent chooses front pearls i+1, recur for [i+1, j-1]
                 *      2. if opponent chooses rear pearls j, recur for [i, j-2]
                 */
                int end = pearls[j] +
                        Integer.min(calculate(T, i + 1, j - 1), calculate(T, i, j - 2));

                T[i][j] = Integer.max(start, end); // assign maximum of two choices
            }
        }
        return T[0][totalNumberOfPackets - 1];
    }

    private static int calculate(final int[][] T, final int i, final int j) {
        if (i <= j) return T[i][j];
        return 0;
    }


    public static void main(String[] args) {
        final Scanner consoleReader = new Scanner(System.in);

        final int totalNumberOfPackets = consoleReader.nextInt();
        final int[] pearls = new int[totalNumberOfPackets];
        for (int index = 0; index < totalNumberOfPackets; index++) pearls[index] = consoleReader.nextInt();

        System.out.println(optimalStrategy(pearls));
    }
}
