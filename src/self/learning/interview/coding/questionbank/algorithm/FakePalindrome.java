package self.learning.interview.coding.questionbank.algorithm;

import java.util.ArrayList;
import java.util.List;

public class FakePalindrome {
    /*
     * function to check whether characters of a string can form a palindrome
     */
    static boolean canFormPalindrome(String str) {

        // Create a list
        List<Character> list = new ArrayList<>();

        // For each character in input strings,
        // remove character if list contains
        // else add character to list
        for (int i = 0; i < str.length(); i++) {
            if (list.contains(str.charAt(i)))
                list.remove((Character) str.charAt(i));
            else
                list.add(str.charAt(i));
        }

        // if character length is even list is expected to be empty
        // or if character length is odd list size is expected to be 1
        // if string length is odd
        return str.length() % 2 == 0 && list.isEmpty() // if string length is even
                || (str.length() % 2 == 1 && list.size() == 1);

    }

    // Driver program
    public static void main(String args[]) {
        if (canFormPalindrome("geeksforgeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");

        if (canFormPalindrome("geeksogeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
