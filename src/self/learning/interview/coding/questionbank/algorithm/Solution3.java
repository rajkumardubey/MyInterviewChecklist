package self.learning.interview.coding.questionbank.algorithm;

import java.util.Scanner;

public class Solution3 {
    /*
     * Below are few important points to note:
     * a) For N < 7, the output is N itself.
     * b) Command+V can be used multiple times to print current buffer.
     *    The idea is to compute the optimal string length for N keystrokes by using a simple insight.
     *    The sequence of N keystrokes which produces an optimal string length will end
     *    with a suffix of Command-A, a Command-C, followed by only Command-V’s . (For N > 6)
     * c) The task is to find out the breakpoint after which we get the above suffix of keystrokes.
     *    Definition of a breakpoint is that instance after which we need to only press Command-A, Command-C once
     *    and the only Command-V’s afterwards to generate the optimal length.
     * */
    static int findOptimal(final int N) {
        /* The optimal string length is N when N is smaller than 7 */
        if (N <= 6) return N;

        /* An array to store result of sub-problems */
        final int[] screen = new int[N];

        /* Initializing the optimal lengths array for until 6 input strokes. */
        for (int index = 1; index <= 6; index++) screen[index - 1] = index;

        /* Solve all sub-problems in bottom-up manner */
        for (int i = 7; i <= N; i++) {
            /*
             For any keystroke i, we will need to choose between:-
              1. pressing Command-V once after copying the OM's obtained by i-3 keystrokes.
              2. pressing Command-V twice after copying the OM's obtained by i-4 keystrokes.
              3. pressing Command-V thrice after copying the OM'sobtained by i-5 keystrokes.
             */
            screen[i - 1] = Math.max(2 * screen[i - 4],
                    Math.max(3 * screen[i - 5], 4 * screen[i - 6]));
        }
        return screen[N - 1];
    }

    public static void main(String[] args) {
        final Scanner consoleReader = new Scanner(System.in);
        final int keyPressAllowed = consoleReader.nextInt();

        System.out.println(findOptimal(keyPressAllowed));
    }

}
