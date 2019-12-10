package self.learning.interview.coding;

import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaximumQuadruple {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int listSize = sc.nextInt();

        final int[] list = new int[listSize];
        IntStream.range(0, listSize).forEach(index -> list[index] = sc.nextInt());

        final int max = maxProdQuad(listSize, list);
        if (max == -1) System.out.println("No Maximum Product Quadruple");
        else System.out.println(max);
    }

    private static int maxProdQuad(final int size, final int[] list) {
        if (size <= 4) return -1;

        // Declare the variables
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int fourthMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int thirdMin = Integer.MAX_VALUE;
        int fourthMin = Integer.MAX_VALUE;


        for (int value : list) {
            if (value > firstMax) {
                fourthMax = thirdMax;
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = value;
            } else if (value > secondMax) {
                fourthMax = thirdMax;
                thirdMax = secondMax;
                secondMax = value;
            } else if (value > thirdMax) {
                fourthMax = thirdMax;
                thirdMax = value;
            } else if (value > fourthMax) {
                fourthMax = value;
            }

            if (value < firstMin) {
                fourthMin = thirdMin;
                thirdMin = secondMin;
                secondMin = firstMin;
                firstMin = value;
            } else if (value < secondMin) {
                fourthMin = thirdMin;
                thirdMin = secondMin;
                secondMin = value;
            } else if (value < thirdMin) {
                fourthMin = thirdMin;
                thirdMin = value;
            } else if (value < fourthMin) {
                fourthMin = value;
            }
        }

        System.out.println("First max: " + firstMax);
        System.out.println("Second max: " + secondMax);
        System.out.println("Third max: " + thirdMax);
        System.out.println("Fourth max: " + fourthMax);

        System.out.println("First min: " + firstMin);
        System.out.println("Second min: " + secondMin);
        System.out.println("Third min: " + thirdMin);
        System.out.println("Fourth min: " + fourthMin);

        int x = firstMax * secondMax * thirdMax * fourthMax;
        int y = firstMin * secondMin * thirdMin * fourthMin;
        int z = firstMin * secondMin * firstMax * secondMax;

        return Math.max(Math.max(x, y), z);
    }
}
