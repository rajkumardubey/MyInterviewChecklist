package self.learning.interview.coding;

import java.util.*;

public class TwoSum {
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        final Map<Integer, Integer> map = new HashMap<>();

        int temp;
        for (int index = 0; index < A.size(); index++) {
            temp = B - A.get(index);
            if (map.containsKey(temp))
                return new ArrayList<>(Arrays.asList(map.get(temp) + 1, index + 1));

            // Only put unique values
            if (!map.containsKey(A.get(index))) map.put(A.get(index), index);
        }
        return new ArrayList<>();
    }

    // Main to test the above function
    public static void main(String[] args) {
        System.out.println(new TwoSum().twoSum(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3), -1));
    }
}
