package self.learning.interview.coding;

import java.util.Arrays;

public class MaxToMinHeap {
    public static void main(String[] args) {
        int[] arr = {-2, 1, 5, 9, 4, 6, 7};
        System.out.println("the max heap created is");
        for (int a : arr) System.out.print(a + " ");

        arr = buildMaxHeap(arr, arr.length);
        System.out.println("the min heap is ");
        System.out.println(Arrays.toString(arr));
    }

    static int[] buildMaxHeap(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            // if child is bigger than parent
            if (arr[i] > arr[(i - 1) / 2]) {
                int j = i;

                // swap child and parent until parent is smaller
                while (arr[j] > arr[(j - 1) / 2]) {
                    swap(arr, j, (j - 1) / 2);
                    j = (j - 1) / 2;
                }
            }
        }
        return arr;
    }

    public static int[] max_min(int[] arr) {
        int smallest;
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            smallest = i;
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;


            if (left < arr.length && arr[i] > arr[left]) smallest = left;
            if (right < arr.length && arr[i] > arr[right]) smallest = right;

            if (smallest != i) {
                swap(arr, i, left);
                i = smallest;
            }
            System.out.println("the tree formed after loop i" + Arrays.toString(arr));
        }
        return arr;
    }

    // Utility function to swap two indices in the array
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}