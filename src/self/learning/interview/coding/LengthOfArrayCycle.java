package self.learning.interview.coding;

/*
 * <b>Problem Statement</b>
 * You have an integer array.
 * Starting from arr[startIndex], follow each element to the index it points to.
 * Continue to do this until you find a cycle.
 * Return the length of the cycle. If no cycle is found return -1
 */
public class LengthOfArrayCycle {
    private static int countLengthOfCycle(int[] arr, int startIndex) {
        //your code goes here

        final boolean[] visited = new boolean[arr.length];
        int count = 0;
        int visitNow = startIndex;
        while (true) {
            try {
                if (visited[visitNow]) return count;

                visited[visitNow] = true;
                visitNow = arr[visitNow];
                count++;
            } catch (final ArrayIndexOutOfBoundsException ex) {
                return -1;
            }
        }
    }

    public static void main(String[] args) {

        boolean testsPassed;

        testsPassed = countLengthOfCycle(new int[]{1, 0}, 0) == 2;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;

        if (testsPassed) {
            System.out.println("Test passed.");
            //return true;
        } else {
            System.out.println("Test failed.");
            //return false;
        }


    }
}
