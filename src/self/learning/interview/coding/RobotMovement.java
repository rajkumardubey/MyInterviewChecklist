package self.learning.interview.coding;

import java.util.Arrays;

public class RobotMovement {

    // your code
    private static Integer[] walk(String path) {
        int r = 0, c = 0;
        for (Character ch : path.toUpperCase().toCharArray()) {
            switch (ch) {
                case 'U':
                    c++;
                    break;

                case 'D':
                    c--;
                    break;

                case 'L':
                    r--;
                    break;

                case 'R':
                    r++;
                    break;
            }

            // System.out.println(String.format("ch: %s, r: %s, c: %s", ch, r, c));
        }

        return new Integer[]{r, c};
    }

    public static boolean isEqual(Integer[] a, Integer[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean pass() {
        boolean res = true;

        {
            String test = "UUU";
            Integer[] result = walk(test);
            System.out.println(Arrays.toString(result));
            res &= isEqual(result, new Integer[]{0, 3});
        }

        {
            String test = "ULDR";
            Integer[] result = walk(test);
            System.out.println(Arrays.toString(result));
            res &= isEqual(result, new Integer[]{0, 0});
        }

        {
            String test = "ULLLDUDUUR";
            Integer[] result = walk(test);
            System.out.println(Arrays.toString(result));
            res &= isEqual(result, new Integer[]{-2, 2});
        }

        {
            String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
            Integer[] result = walk(test);
            System.out.println(Arrays.toString(result));
            res &= isEqual(result, new Integer[]{1, 1});
        }

        return res;
    }

    public static void main(String[] args) {
        if (pass()) {
            System.out.println("{Pass");
        } else {
            System.out.println("Test failures");
        }
    }

}
