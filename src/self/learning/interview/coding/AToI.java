package self.learning.interview.coding;

public class AToI {

    public static void main(String[] args) {
        System.out.println(myAtoi("    -88827   5655  U"));
    }

    public static int myAtoi(String str) {
        str = str.trim();
        final char[] charArray = str.toCharArray();

        int sign = 1;
        int startIndex = 0;
        if (charArray.length > 0) {
            if (charArray[0] == '-' || charArray[0] == '+') startIndex = 1;
            if (charArray[0] == '-') sign = -1;
        }

        int result = 0;
        int digit;
        char ch;
        while (startIndex < charArray.length) {
            ch = charArray[startIndex];

            if (ch == '+' || ch == '-' || ch == ' ') break;

            digit = (int) ch - 48;
            if (digit >= 0 && digit <= 9) {
                if (result > (Integer.MAX_VALUE - digit) / 10) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result = result * 10 + digit;
            } else break;


            startIndex++;
        }
        return result * sign;
    }
}
