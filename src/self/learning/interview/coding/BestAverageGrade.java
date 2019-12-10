package self.learning.interview.coding;

import java.util.*;

/*
 <b>Problem Statement</b>
    Given an array scores [][] = {{“jerry”,”65”},{“bob”,”91”}, {“jerry”,”23”}, {“Eric”,”83”}}.
    Find the student with highest average score
 */
public class BestAverageGrade {
    private static Integer bestAvgGrade(final String[][] scores) {
        final Map<String, Integer> averageScorer = new HashMap<>();

        Arrays.stream(scores)
                .forEach(strings -> averageScorer
                        .compute(strings[0], (k, v) -> getUpdatedAverage(strings[1], v)));

        return Collections
                .max(averageScorer.entrySet(), Comparator.comparingDouble(Map.Entry::getValue))
                .getValue();
    }

    private static int getUpdatedAverage(String score, Integer previousValue) {
        return previousValue == null ? getIntegerValue(score) : average(score, previousValue);
    }

    private static int average(final String one, final double two) {
        return (int) (getIntegerValue(one) + two) / 2;
    }

    private static Integer getIntegerValue(String score) {
        try {
            return Integer.valueOf(score);
        } catch (final NumberFormatException ex) {
            System.out.println("Wrong input, ignoring the value & considering it as 0.");
            return 0;
        }
    }

    public static boolean pass() {
        String[][] s1 = {{"Rohan", "84"}, {"Sachin", "102"}, {"Ishan", "55"}, {"Sachin", "18"}};
        return bestAvgGrade(s1) == 84;
    }

    public static void main(String[] args) {
        if (pass()) System.out.println("Pass");
        else System.out.println("Some Fail");
    }
}
