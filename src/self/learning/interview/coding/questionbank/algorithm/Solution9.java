package self.learning.interview.coding.questionbank.algorithm;

import java.util.Scanner;

public class Solution9 {
    /* Function to find Levenshtein Distance [Edit distance] between String X and Y.
     * Here m and n are the number of characters in X and Y respectively.
     *
     * The time complexity of above solution is O(mn) and auxiliary space used by the program is O(mn)
     */
    public static int transformationCost(String X, int m, String Y, int n) {
        /* For all i and j, table[i,j] will hold the edit distance between the first i characters of X and the first j characters of Y */
        final int[][] table = new int[m + 1][n + 1]; // note that table has (m+1)*(n+1) values

        /* source prefixes can be transformed into empty String by dropping all characters */
        for (int i = 1; i <= m; i++) table[i][0] = i;

        /* target prefixes can be reached from empty source prefix by inserting every character */
        for (int j = 1; j <= n; j++) table[0][j] = j;

        /* fill the lookup table in bottom-up manner */
        int cost;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) cost = 0;
                else cost = 1;

                table[i][j] = minimum(table[i - 1][j] + 1,
                        table[i][j - 1] + 1,
                        table[i - 1][j - 1] + cost);
            }
        }

        return table[m][n];
    }

    /* Utility function to find minimum of three numbers */
    private static int minimum(int a, int b, int c) {
        return Integer.min(a, Integer.min(b, c));
    }

    public static void main(String[] args) {
        final Scanner consoleReader = new Scanner(System.in);
        final String sourceWord = consoleReader.nextLine().trim().toLowerCase();
        final String destinationWord = consoleReader.nextLine().trim().toLowerCase();

        System.out.print(transformationCost(sourceWord, sourceWord.length(), destinationWord, destinationWord.length()));
    }
}