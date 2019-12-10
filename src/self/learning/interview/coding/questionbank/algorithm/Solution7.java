package self.learning.interview.coding.questionbank.algorithm;

import java.util.*;

public class Solution7 {

    /*
        1) Initialize result as empty.
        2) find the largest denomination that is smaller than `withdrawalAmount`.
        3) Add found denomination to result. Subtract value of found denomination from `withdrawalAmount`.
        4) If `withdrawalAmount` becomes 0, then print result.
           Else repeat steps 2 and 3 for new value of V
    */
    private static List<Integer> dispenseNote(final int withdrawalAmount, final List<Integer> allDenominations) {
        /* Initialize result as empty array list */
        final List<Integer> dispensedNotes = new ArrayList<>();

        /* amount remaining for withdrawal. it is equal to withdrawalAmount as of now */
        int amountRemaining = withdrawalAmount;
        int currentDenomination;
        for (int index = allDenominations.size() - 1; index > 0; index--) {
            currentDenomination = allDenominations.get(index);

            /* finding the largest denomination that is smaller than `amountRemaining` */
            while (amountRemaining >= currentDenomination) {
                dispensedNotes.add(currentDenomination); // Add found denomination to result
                amountRemaining -= currentDenomination; // reducing the amount remaining
            }
        }

        return dispensedNotes;
    }

    public static void main(String[] args) {
        final Scanner consoleReader = new Scanner(System.in);
        final int amountNeedsToWithdrawn = consoleReader.nextInt();

        List<Integer> dispenseNotes = dispenseNote(amountNeedsToWithdrawn, Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 500, 2000));
        for (Integer note : dispenseNotes) System.out.print(note + " ");
    }
}