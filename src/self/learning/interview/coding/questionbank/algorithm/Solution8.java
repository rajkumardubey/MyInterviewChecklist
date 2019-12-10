package self.learning.interview.coding.questionbank.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Solution8 {
    /* Returns minimum number of platforms required */
    private static int minimumNumberOfPlatform(final int n, final int[] arrivalTimings, final int[] departureTimings) {
        /* Sort arrival and departure arrays */
        Arrays.sort(arrivalTimings);
        Arrays.sort(departureTimings);

        /* platformNeededNow indicates number of platforms needed at a time */
        int platformNeededNow = 1, result = 1;
        int i = 1, j = 0;

        /* Similar to merge in merge sort to process all events in sorted order */
        while (i < n && j < n) {
            /* If next event in sorted order is arrival, increment count of platforms needed */
            if (arrivalTimings[i] <= departureTimings[j]) {
                platformNeededNow++;
                i++;
                result = Math.max(platformNeededNow, result);
            } else {
                /* Else decrement count of platforms needed */
                platformNeededNow--;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Scanner consoleReader = new Scanner(System.in);

        final int trainCount = consoleReader.nextInt();
        final int[] arrivalTimings = new int[trainCount];
        for (int index = 0; index < trainCount; index++) arrivalTimings[index] = consoleReader.nextInt();

        final int[] departureTimings = new int[trainCount];
        for (int index = 0; index < trainCount; index++) departureTimings[index] = consoleReader.nextInt();

        System.out.println(minimumNumberOfPlatform(trainCount, arrivalTimings, departureTimings));
    }
}