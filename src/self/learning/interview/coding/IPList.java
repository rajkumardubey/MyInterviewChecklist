package self.learning.interview.coding;

import java.util.*;

public class IPList {
    /**
     * Given a log file, return IP address(es) which accesses the site most often.
     */
    private static String findTopIpAddress(final String[] lines) {
        final Map<String, Integer> count = new HashMap<>();

        Arrays.stream(lines)
                .map(line -> line.split(" - ")[0])
                .forEach(ip -> count.merge(ip, 1, Integer::sum));

        return Collections
                .max(count.entrySet(), Comparator.comparingInt(Map.Entry::getValue))
                .getKey();
    }


    public static void main(String[] args) {

        String[] lines = new String[]{
                "10.0.0.1 - log entry 1 11",
                "10.0.0.1 - log entry 2 213",
                "10.0.0.2 - log entry 1 11",
                "10.0.0.2 - log entry 2 213",
                "10.0.0.2 - log entry 133132"};
        String result = findTopIpAddress(lines);

        if (result.equals("10.0.0.2")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }

    }

}
