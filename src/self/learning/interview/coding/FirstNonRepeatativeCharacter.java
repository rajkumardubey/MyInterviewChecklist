package self.learning.interview.coding;

import java.util.Arrays;

/*
 <b>Problem Statement</b>
 * Finds the first character that does not repeat anywhere in the input string
 * Given "apple", the answer is "a"
 * Given "racecars", the answer is "e"
 */
public class FirstNonRepeatativeCharacter {

    public static int MAX_CHAR = 256;

    private static char findFirst(String input) {
        final int length = input.length();

        /* count[x] is going to store count of character 'x' in str. If x is not present, then it is going to store 0. */
        final int[] count = new int[MAX_CHAR];

        /* index[x] is going to store index of character 'x' in str.  If x is not  present or x is repeating, then it is going to store  a value */
        final int[] index = new int[MAX_CHAR];

        /* Initialize counts of all characters and indexes of non-repeating  characters. */
        for (int i = 0; i < MAX_CHAR; i++) index[i] = length;  // A value more than any index in str[]

        /* Traverse the input string */
        for (int i = 0; i < length; i++) {
            char x = input.charAt(i); // Find current character and increment its count
            ++count[x];

            /* If this is first occurrence, then set value in index as index of it. */
            if (count[x] == 1) index[x] = i;

            /* If character repeats, then remove it from index[] */
            if (count[x] == 2) index[x] = length;
        }

        Arrays.sort(index);

        // After sorting, if index[k-1] is value, then return it, else return -1.
        return input.charAt((index[0] != length) ? index[0] : 0);
    }

    public static void main(String[] args) {

        String[] inputs = {"apple", "racecars", "ababdc", "a"};
        char[] outputs = {'a', 'e', 'd', 'a'};

        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            result = result && findFirst(inputs[i]) == outputs[i];
            if (!result) System.out.println("Test failed for: " + inputs[i]);
            else System.out.println("Test passed for: " + inputs[i]);
        }
    }
}
