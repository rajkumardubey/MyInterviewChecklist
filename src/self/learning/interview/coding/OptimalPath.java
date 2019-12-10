package self.learning.interview.coding;
/*
 ** Instructions to candidate.
 **  1) You are an avid rock collector who lives in southern California. Some rare
 **     and desirable rocks just became available in New York, so you are planning
 **     a cross-country road trip. There are several other rare rocks that you could
 **     pick up along the way.
 **
 **     You have been given a grid filled with numbers, representing the number of
 **     rare rocks available in various cities across the country.  Your objective
 **     is to find the optimal path from So_Cal to New_York that would allow you to
 **     accumulate the most rocks along the way.
 **
 **     Note: You can only travel either north (up) or east (right).
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement optimalPath() correctly.
 **  4) Here is an example:
 **                                                           ^
 **                 {{0,0,0,0,5}, New_York (finish)           N
 **                  {0,1,1,1,0},                         < W   E >
 **   So_Cal (start) {2,0,0,0,0}}                             S
 **                                                           v
 **   The total for this example would be 10 (2+0+1+1+1+0+5).
 */

// Optimal path from (r,0) (0,c)

public class OptimalPath {
    private static Integer optimalPath(final Integer[][] grid) {
        System.out.println("Matrix is : ");
        printMatrix(grid);

        final int ROW_NUM = grid.length;
        final int COLUMN_NUM = grid[0].length;

        if (COLUMN_NUM == 0) return 0;

        final Integer[][] result = new Integer[ROW_NUM][COLUMN_NUM];

        result[ROW_NUM - 1][0] = grid[ROW_NUM - 1][0];
        for (int r = ROW_NUM - 2; r >= 0; r--)
            result[r][0] = result[r + 1][0] + grid[r][0];

        for (int c = 1; c < COLUMN_NUM; c++)
            result[ROW_NUM - 1][c] = result[ROW_NUM - 1][c - 1] + grid[ROW_NUM - 1][c];

        for (int r = ROW_NUM - 2; r >= 0; r--) {
            for (int c = 1; c < COLUMN_NUM; c++) {
                result[r][c] = grid[r][c] + Math.max(result[r + 1][c], result[r][c - 1]);
            }
        }

        System.out.println("Result is : ");
        printMatrix(result);

        return result[0][COLUMN_NUM - 1];
    }

    private static void printMatrix(final Integer[][] mat) {
        for (Integer[] integers : mat) {
            for (Integer integer : integers) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    private static boolean doTestsPass() {
        boolean result = true;
        // Base test case
        result &= optimalPath(new Integer[][]{{0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}}) == 10;
        // Random numbers
        result &= optimalPath(new Integer[][]{{1, 3, 2, 0, 2, 1, 8},
                {3, 4, 1, 2, 0, 1, 1},
                {1, 1, 1, 2, 3, 2, 1},
                {1, 0, 1, 1, 4, 2, 1}}) == 25;
        // All 0's
        result &= optimalPath(new Integer[][]{{0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}}) == 0;
        // Many optimal paths
        result &= optimalPath(new Integer[][]{{1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1}}) == 8;
        // Empty grid
        result &= optimalPath(new Integer[][]{{}}) == 0;
        // Single row
        result &= optimalPath(new Integer[][]{{2, 9, 0, 0, 1}}) == 12;

        return result;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
