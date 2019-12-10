package self.learning.interview.coding;

public class RunLength {

    public static String rle(final String input) {
        // Your code goes here
        final StringBuilder result = new StringBuilder();

        Character previous = null;
        int count = 0;
        for (Character ch : input.toCharArray()) {
            if (ch.equals(previous)) count++;
            else {
                if (previous != null) result.append(previous).append(count);
                previous = ch;
                count = 1;
            }
        }
        if (previous != null) result.append(previous).append(count);

        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(rle("aaabbbbbbyyyyy"));

        if ("".equals(rle("")) &&
                "a1".equals(rle("a")) &&
                "a3".equals(rle("aaa"))) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}
