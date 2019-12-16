package self.learning.interview.coding;

public class LexicographicalMinimumString {
    public static void main(String[] args) {
        String[] testStrings = {"ABCD", "ACACAB", "CABABC", "ABABCABA", "AAA", "GEEKSQUIZ", "CAPABCQ"};
        for (String s : testStrings) {
            System.out.println("\n\n=========================");
            System.out.println("Input: " + s);
            System.out.println(s + ": " + lexMin(s));
        }
    }


    static String lexMin(final String input) {
        final int length = input.length();

        final String tempString = input + input;

        int offset = 0;
        int result = 0;

        for (int counter = 1; counter < length * 2; counter++) {
            /* New lexicographical minimum found. Reset all parameters here. */
            if (tempString.charAt(counter) < tempString.charAt(result)) {
                result = counter;
                offset = 0;
            } else if (tempString.charAt(counter) == tempString.charAt(result + offset)) {
                /* Keep moving the offset till this new string matches the previous result */
                offset++;
            } else if (tempString.charAt(counter) < tempString.charAt(result + offset)) {
                /* In the new match, some character is found which is lower than the character at same offset in the previous result.
                 * So new result becomes the lexicographical minimum, discard  the previous result in favor of the new result. */
                result = counter - offset;
                offset = 0;
                counter = result;
            } else {
                /* In the new match, some character is found which is higher than the character at same offset in the previous result.
                 * So new result cannot be the lexicographical minimum, discard it. */
                offset = 0;
            }
        }

        return tempString.substring(result, result + length);
    }

/*
    static String getSpace(int answer) {
        String s = "";
        while (answer-- > 0)
            s += " ";
        return s;
    }
                // Debug prints
            System.out.println("-------------------------");
            System.out.println("i=" + i + ", answer=" + answer + ", offset=" + offset);
            System.out.println(getSpace(i) + "i");
            System.out.println(str2);
            System.out.println(getSpace(answer) + str2.substring(answer, answer + str.length()));
            if (offset > 0)
                System.out.println(getSpace(i - offset + 1) + str2.substring(i - offset + 1, i + 1));
            System.out.println();

*/
}
