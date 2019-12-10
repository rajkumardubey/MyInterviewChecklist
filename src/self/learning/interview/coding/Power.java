package self.learning.interview.coding;

/**
 * Given base and integer exponent, compute value of base raised to the powerRecursive of exponent.
 */
public class Power {


    private static double powerRecursive(final double base, final int exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;

        if (exp % 2 == 0) return powerRecursive(base * base, exp / 2);
        else return base * powerRecursive(base * base, exp / 2);
    }

    private static double power(double base, int exp) {
        int result = 1;

        while (exp > 0) {
            if (exp % 2 != 0) result *= base;

            exp = exp / 2;
            base = base * base;
        }

        return result;
    }


    private static boolean doTestPass() {
        double result = power(2, 2);
        double result1 = powerRecursive(8, 7);
        return result == 4 && result1 == Math.pow(8, 7);
    }

    public static void main(String[] args) {
        if (doTestPass()) {
            System.out.println("Pass");
        } else {
            System.out.println("There are failures");
        }
    }
}
