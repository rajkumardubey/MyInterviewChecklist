package self.learning.interview.coding;

/**
 * Pangram Finder
 * <p>
 * The sentence "The quick brown fox jumps over the lazy dog" contains every single letter in the alphabet.
 * Such sentences are called pangrams.Write a function findMissingLetters, which takes a String `sentence`,
 * and returns all the letters it is missing.
 */

public class PanagramFinder {
    private static String findMissingLetters(final String sentence) {
        final int[] missingCharacterList = new int[26];

        int charValue;
        for (Character ch : sentence.toCharArray()) {
            charValue = Character.hashCode(Character.toLowerCase(ch));
            if (charValue >= 97 && charValue <= 123) missingCharacterList[charValue - 97] = 1;
        }

        final StringBuilder result = new StringBuilder();
        for (int counter = 0; counter < 26; counter++)
            if (missingCharacterList[counter] == 0) result.append(Character.toChars(97 + counter));


        return result.toString();
    }

    public static void main(String[] args) {
        boolean success = "".equals(findMissingLetters("The quick brown fox jumps over the lazy dog"));
        success = success && "abcdefghijklmnopqrstuvwxyz".equals(findMissingLetters(""));
        success = success && "abdefghijklnopqrstuwxyz".equals(findMissingLetters("cmv"));

        if (success) {
            System.out.println("Pass ");
        } else {
            System.out.println("Failed");
        }
    }
}
