package self.learning.interview.coding;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String A) {
        final int n = A.length();

        /* table[i][j] will be false if substring A[i..j] is not palindrome.
           Else table[i][j] will be true */
        final boolean[][] table = new boolean[n][n];

        /* All substrings of length 1 are palindromes */
        for (int i = 0; i < n; ++i) table[i][i] = true;

        /* check for sub-string of length 2 */
        int start = 0, maxLength = 1;
        for (int i = 0; i < n - 1; ++i) {
            if (A.charAt(i) == A.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        /* Check for lengths greater than 2. k is length of substring */
        for (int k = 3; k <= n; ++k) {
            /* Fix the starting index, i here is the starting index */
            for (int i = 0; i < n - k + 1; ++i) {
                /* Get the ending index of substring from starting index i and length k */
                int j = i + k - 1;

                /* checking for sub-string from ith index to jth index
                   if A.charAt(i+1) == A.charAt(j-1) && A.charAt(i) == A.charAt(j)
                   then A [i...j] is a palindrome */
                if (table[i + 1][j - 1] && A.charAt(i) == A.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(table[i][j] ? "T " : "F ");
            System.out.println();
        }
        return A.substring(start, start + maxLength);
    }

    // Another Solution in O(N) time complexity using Manacher's Algorithm: https://www.youtube.com/watch?v=nbTSfrEfo6M&t

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubstring().longestPalindrome("aaaabaaa"));
    }
}
