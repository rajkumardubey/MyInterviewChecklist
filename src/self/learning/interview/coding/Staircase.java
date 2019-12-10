package self.learning.interview.coding;

public class Staircase {
    private static int countSteps(Integer n) {
        return countWays(n+1, 3);
    }

    private static Integer countWays(final int n, final int m) {
        if (n == 0 || n == 1) return 1;

        final int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < n; i++) {
            result[i] = 0;
            for (int j = 1; j <= m && j <= i; j++)
                result[i] += result[i - j];
        }
        return result[n - 1];
    }


    private static boolean doTestsPass() {
        return countSteps(3) == 4
                && countSteps(4) == 7;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }

        for (Integer n = 1; n <= 5; n++) {
            Integer numberOfCombinations = countSteps(n);
            System.out.println(n + " steps => " + numberOfCombinations);
        }
    }
}
