package self.learning.interview.coding;

public class SquareRoot {

    /**
     * Recursive function that returns squareRoot root of a number with precision up to 3 decimal places
     */
    private static double squareRoot(final double number, final double start, final double end) {
        double mid = (start + end) / 2;
        double mul = mid * mid;

        if ((mul == number) || (Math.abs(mul - number) < 0.001)) return mid; // If mid itself is the squareRoot root
        else if (mul < number) return squareRoot(number, mid, end); // If mul is less than n, recur second half
        else return squareRoot(number, start, mid); // Else recur first half
    }

    /**
     * Function to find the squareRoot root of n
     */
    private static double squareRoot(final double input) {
        if (input <= 2) return squareRoot(input, 0, 2);

        double counter = 1;
        while (counter <= input / 2) {
            if (counter * counter == input) return counter;
                /* squareRoot root will lie in the interval counter-1 and counter */
            else if (counter * counter > input) return squareRoot(input, counter - 1, counter);
            counter++;
        }

        return 0;
    }

    public static void main(String[] args) {
        double[] inputs = {2, 4, 100};
        double[] expected_values = {1.41421, 2, 10};
        double threshold = 0.001;
        for (int i = 0; i < inputs.length; i++) {
            if (Math.abs(squareRoot(inputs[i]) - expected_values[i]) > threshold) {
                System.out.printf("Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]));
            }
        }
        System.out.println("All tests passed");
    }
}
