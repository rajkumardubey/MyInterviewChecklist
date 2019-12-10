package self.learning.interview.coding;

import java.util.*;
import java.util.stream.Collectors;

public class SubarrayWithGivenSum {
    // Function to find sub-arrays with given sum in an array
    public static void printAllSubarrays(final int[] inputArray, final int givenSum) {
        /* create a map for storing end index of all sub-arrays with sum of elements so far */
        final Map<Integer, List<Integer>> summationStorage = new HashMap<>();

        /* To handle the case when the sub-array with given sum start from 0th index */
        insert(summationStorage, 0, -1);

        int sumSoFar = 0;
        int subArrayStart = 0;
        int subArrayEnd = inputArray.length;

        // traverse the given array
        for (int index = 0; index < inputArray.length; index++) {
            sumSoFar += inputArray[index]; // sum of elements so far

            // check if there exists at-least one sub-array with given sum
            if (summationStorage.containsKey(sumSoFar - givenSum)) {
                List<Integer> list = summationStorage.get(sumSoFar - givenSum);
                for (Integer value : list) {
                    // printSubarray(inputArray, value + 1, index);

                    /* to get the sub-array with least size */
                    if (index - (value + 1) < (subArrayEnd - subArrayStart)) {
                        subArrayStart = value + 1;
                        subArrayEnd = index;
                    }
                }
            }
            insert(summationStorage, sumSoFar, index); // insert (sumSoFar, currentIndex) pair into the map
        }

        System.out.println("Result : (" + subArrayStart + ", " + subArrayEnd + ")");
    }

    // Utility function to insert <key, value> pair into the Multimap
    private static <K, V> void insert(final Map<K, List<V>> hashMap,
                                      final K key, final V value) {
        // if the key is seen for the first time, initialize the list
        if (!hashMap.containsKey(key)) hashMap.put(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }

    // Utility function to print a subarray A[i, j]
    public static void printSubarray(final int[] inputArray,
                                     final int start, final int end) {
        System.out.println(Arrays
                .stream(inputArray, start, end + 1)
                .boxed()
                .collect(Collectors.toList()));
    }


    // main function
    public static void main(String[] args) {
        int[] A = {3, 4, -7, 1, 3, 3, 1, -4, 7};
        int sum = 7;

        printAllSubarrays(A, sum);
    }
}