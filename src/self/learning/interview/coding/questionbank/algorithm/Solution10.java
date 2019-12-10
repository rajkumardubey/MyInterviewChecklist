package self.learning.interview.coding.questionbank.algorithm;

import java.util.Scanner;

public class Solution10 {

    public static int getFirstOccurrence(final int[] A, final int N, final int X) {
        return 1 + first(A, 0, N - 1, X);
    }

    public static int getLastOccurrence(final int[] A, final int N, final int X) {
        return 1 + last(A, 0, N, X, N);
    }

    /* if `findMe` is present in list[]
     * then returns the index of FIRST occurrence of `findMe` in list[0..n-1],
     * otherwise returns -1 */
    private static int first(final int[] list, int low, int high, int findMe) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if ((mid == 0 || findMe > list[mid - 1]) && list[mid] == findMe) return mid;
        else if (findMe > list[mid]) return first(list, (mid + 1), high, findMe);
        else return first(list, low, (mid - 1), findMe);
    }

    /* if `findMe` is present in list[]
     * then returns the index of LAST occurrence of `findMe` in list[0..N],
     * otherwise returns -1 */
    private static int last(int[] list, int low, int high, int findMe, int listSize) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if ((mid == listSize - 1 || findMe < list[mid + 1]) && list[mid] == findMe) return mid;
        else if (findMe < list[mid]) return last(list, low, (mid - 1), findMe, listSize);
        else return last(list, (mid + 1), high, findMe, listSize);
    }

    public static void main(String[] args) {
        final Scanner consoleReader = new Scanner(System.in);

        final int N = consoleReader.nextInt();
        final int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = consoleReader.nextInt();
        final int X = consoleReader.nextInt();
        System.out.println("[" + getFirstOccurrence(A, N, X) + " " + getLastOccurrence(A, N, X) + "]");
    }
}
