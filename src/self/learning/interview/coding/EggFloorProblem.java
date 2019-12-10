package self.learning.interview.coding;

public class EggFloorProblem {

    public static void main(String[] args) {
        int egg = 2;
        int floor = 100;
        System.out.println("Minimum number of trials in worst case with " + egg
                + "  eggs and " + floor + " floors is " + eggBreak(egg, floor));
    }

    /**
     * When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.
     * <p>
     * 1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
     * 2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.
     * <p>
     * Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.
     *
     */
    private static int eggBreak(final int eggCount, final int floorCount) {
        /* A 2D table to save minimum number of trials needed for i eggs and j floors. */
        final int[][] eggFloor = new int[eggCount + 1][floorCount + 1];

        /* We need one trial for one floor */
        for (int row = 1; row <= eggCount; row++) eggFloor[row][1] = 1;

        /* We always need j trials for 1 egg and j floors */
        for (int column = 1; column <= floorCount; column++) eggFloor[1][column] = column;


        for (int row = 2; row <= eggCount; row++) {
            for (int column = 2; column <= floorCount; column++) {
                calculateTrialForGivenRowAndColumn(eggFloor, row, column);
            }
        }

        return eggFloor[eggCount][floorCount];
    }

    private static void calculateTrialForGivenRowAndColumn(final int[][] eggFloor,
                                                           final int row, final int column) {
        eggFloor[row][column] = Integer.MAX_VALUE;

        for (int x = 1; x <= column; x++) {
            int res = 1 + Math.max(eggFloor[row - 1][x - 1], eggFloor[row][column - x]);
            if (res < eggFloor[row][column]) eggFloor[row][column] = res;
        }
    }
}
