package self.learning.interview.coding;

public class SecondSmallestNumber {

    private static int secondSmallest(final int[] input) {
        if (input == null) return 0; // return value can be anything & must me provided by the interviewer

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (Integer num : input) {
            if (num < firstSmallest) firstSmallest = num;
            else if (num < secondSmallest) secondSmallest = num;
        }
        return secondSmallest == Integer.MAX_VALUE ? firstSmallest : secondSmallest;
    }

    public static void main(String[] args) {

        int[] a = {0};
        int[] b = {0, 1};
        int[] c = {3, 4, 5, 6, 1, 2};

        boolean result;
        result = secondSmallest(a) == 0;
        result &= secondSmallest(b) == 1;
        result &= secondSmallest(c) == 2;

        if (result) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

}
