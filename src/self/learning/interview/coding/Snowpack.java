package self.learning.interview.coding;

public class Snowpack {

    /* Find the amount of snow that could be captured.*/
    private static Integer computeSnowpack(final Integer[] buildingHeight) {
        int result = 0;

        int leftMax = 0, rightMax = 0;

        // indices to traverse the array
        int low = 0, high = buildingHeight.length - 1;

        while (low <= high) {
            if (buildingHeight[low] < buildingHeight[high]) {
                if (buildingHeight[low] > leftMax) leftMax = buildingHeight[low];
                else result += leftMax - buildingHeight[low];
                low++;
            } else {
                if (buildingHeight[high] > rightMax) rightMax = buildingHeight[high];
                else result += rightMax - buildingHeight[high];
                high--;
            }
        }

        return result;
    }

    private static boolean doTestsPass() {
        boolean result = true;
        result &= computeSnowpack(new Integer[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}) == 13;

        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
