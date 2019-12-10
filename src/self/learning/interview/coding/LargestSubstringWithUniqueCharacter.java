package self.learning.interview.coding;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LargestSubstringWithUniqueCharacter {
    private static String largestSubstringWithUniqueCharacter(final String input) {
        if (input == null || input.length() < 1) return "";

        final char[] letters = input.toCharArray();
        int left = 0, right = 0, max = 0;
        final Set<Character> substring = new LinkedHashSet<>();

        while (right < letters.length) {
            if (substring.add(letters[right])) {
                right++;
                max = Math.max(max, right - left);
            } else {
                substring.remove(letters[left++]);
            }
        }

        return substring.stream().map(String::valueOf).collect(Collectors.joining());
    }



    public static void main(String[] args) {
        final String test1 = "aaabcbdeafapoiuytrewq";
        final String largestSubstring1 = largestSubstringWithUniqueCharacter(test1);
        System.out.println(largestSubstring1);


        final String test2 = "jsadhvcvhvhdwytqwihvaxhvagsvZBSk";
        final String largestSubstring2 = largestSubstringWithUniqueCharacter(test2);
        System.out.println(largestSubstring2);
    }

}
