package self.learning.interview.coding;

public class SubsequenceWithGivenSum {

    private static boolean subsetSum(final int[] input, final int expectedSum) {

        final boolean[][] dynamic2D = new boolean[input.length + 1][expectedSum + 1];

        /* achieving 0 as expected sum is always possible */
        for (int index = 0; index <= input.length; index++) {
            dynamic2D[index][0] = true;
        }

        for (int row = 1; row <= input.length; row++) {
            for (int column = 1; column <= expectedSum; column++) {
                dynamic2D[row][column] = dynamic2D[row - 1][column];

                if (column >= input[row - 1]) {
                    dynamic2D[row][column] = dynamic2D[row][column] || dynamic2D[row - 1][column - input[row - 1]];
                }
            }
        }
        return dynamic2D[input.length][expectedSum];

    }

    public static void main(String[] args) {
        final int[] inputArray = {1, 3, 5, 5, 2, 1, 1, 6};
        System.out.println(subsetSum(inputArray, 11));

        System.out.println(subsetSum(inputArray, 2000));
    }
}
