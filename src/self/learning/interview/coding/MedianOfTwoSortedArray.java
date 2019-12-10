package self.learning.interview.coding;

public class MedianOfTwoSortedArray {
    private static double findMedianSortedArrays(final int[] input1, final int[] input2) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static boolean pass() {
        boolean result = true;
        result = result
                && findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}) == 2.5
                && findMedianSortedArrays(new int[]{1, 3, 7, 9, 12}, new int[]{2, 4, 8, 10, 16}) == 7.5;

        return result;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("pass");
        } else {
            System.out.println("some failures");
        }
    }
}
