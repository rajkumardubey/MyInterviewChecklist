package self.learning.interview.coding;

import java.util.*;

public class GroupAnagram {
    private static final String input = "cat dog tac sat tas god dog";

    private static void setOfAnagrams(final String inputString) {
        //your code goes here
        final Map<String, List<String>> output = new HashMap<>();
        final String[] wordArray = inputString.split(" ");

        Arrays.stream(inputString.split(" "))
                .forEach(word -> output
                        .compute(sortByLetters(word), (k, v) -> v == null ? addNewList(word) : addNewWord(v, word)));

        output.forEach((k, v) -> v.forEach(item -> System.out.print(item + " ")));
    }

    private static List<String> addNewWord(final List<String> list, final String word) {
        list.add(word);
        return list;
    }

    private static List<String> addNewList(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);
        return words;
    }

    private static String sortByLetters(String word) {
        final char[] WordLetters = word.toCharArray();
        Arrays.sort(WordLetters);
        return new String(WordLetters);
    }

    public static void main(String[] args) {
        String input = "cat dog tac sat tas god dog";
        setOfAnagrams(input);
    }
}
