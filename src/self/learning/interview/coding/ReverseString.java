package self.learning.interview.coding;

/**
 * Example: reverseStr(str) where str is "abcd" returns "dcba".
 */
public class ReverseString {
    private static String reverseStr(final String input) {
        final char[] letterArray = input.toCharArray();
        final int length = letterArray.length;

        char temp;
        for (int index = 0; index < length / 2; index++) {
            temp = letterArray[index];
            letterArray[index] = letterArray[length - index - 1];
            letterArray[length - index - 1] = temp;
        }

        return new String(letterArray);
    }

    public static void main(String[] args) {

        boolean result = reverseStr("abcd").equals("dcba") && reverseStr("").equals("");

        if (result) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }

    }

}
