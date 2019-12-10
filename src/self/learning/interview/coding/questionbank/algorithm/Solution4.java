package self.learning.interview.coding.questionbank.algorithm;

import java.util.Scanner;

public class Solution4 {
    /* The function moves non-empty elements in Y[] in the beginning and then merge it with X[] */
    private static int[] specialMerge(final int[] X, final int[] Y) {
        /* moves non-empty elements of Y[] in the beginning */
        int k = 0;
        for (int index = 0; index < Y.length; index++) {
            if (Y[index] != 0) Y[k++] = Y[index];
        }

        /* merge X[0..k-1] and Y[0..n-1] to X[0..m-1] */
        return merge(X, X.length - 1, Y, k - 1);
    }

    private static int[] merge(final int[] array1, int N, final int[] array2, int M) {
        int k = M + N + 1; // size of array2[] is (k+1)

        /* run till array2[] or array1[] has elements left
         * and put next greater element in next free position in array2[] from end */
        while (M >= 0 && N >= 0) {
            array2[k--] = array2[M] > array1[N] ? array2[M--] : array1[N--];
        }

        /* copy remaining elements of array1[] (if any) to array2[] */
        while (N >= 0) array2[k--] = array1[N--];

        return array2;
    }

    public static void main(String[] args) {
        final Scanner consoleReader = new Scanner(System.in);

        final int smalledArraySize = consoleReader.nextInt();
        final int[] array1 = new int[smalledArraySize];
        for (int index = 0; index < smalledArraySize; index++) array1[index] = consoleReader.nextInt();

        final int biggerArraySize = consoleReader.nextInt();
        final int[] array2 = new int[biggerArraySize];
        for (int index = 0; index < biggerArraySize; index++) array2[index] = consoleReader.nextInt();

        final int[] mergedArray = specialMerge(array1, array2);

        for (int value : mergedArray) System.out.print(value + " ");
    }
}
