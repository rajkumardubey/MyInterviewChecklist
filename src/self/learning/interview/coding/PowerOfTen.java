package self.learning.interview.coding;

/**
 * Returns true if x is a power-of-10.
 */
public class PowerOfTen {
    private static boolean isPowerOf10(int inputNumber) {
        // your code goes here
        if (inputNumber == 0) return true;
        while (inputNumber > 1 && inputNumber % 10 == 0) inputNumber = inputNumber / 10;
        return inputNumber == 1;
    }

    private static boolean doTestsPass() {
        int[] isPowerList = {0, 10, 100};
        int[] isNotPowerList = {3, 3000};

        for (int i : isPowerList) {
            if (!isPowerOf10(i)) {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        for (int i : isNotPowerList) {
            if (isPowerOf10(i)) {
                System.out.println("Test failed for: " + i);
                return false;
            }
        }

        System.out.println("All tested passed");
        return true;
    }


    public static void main(String[] args) {
        doTestsPass();
    }

}
