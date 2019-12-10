package self.learning.interview.coding;

/*
 <b>Problem Statement</b>
 Given an integer x, find square root of it. If x is not a perfect square, then return floor(√x).
*/
public class FloorSquareRoot {
    public static int sqrt(int a) {
        if (a == 0 || a == 1) return a;

        /* Do Binary Search for floor(sqrt(a)) */
        long start = 1, end = a / 2, ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (mid * mid == a) return (int) mid; // If a is a perfect square

            /* Since we need floor, we update answer
               when mid*mid is smaller than a, and move closer to sqrt(a) */
            if (mid * mid < a) {
                start = mid + 1;
                ans = mid;
            } else end = mid - 1;  // If mid*mid is greater than a
        }
        return (int) ans;
    }

    // Driver Method
    public static void main(String[] args) {
        int x = 930675566;
        System.out.println(sqrt(x));
    }
}
