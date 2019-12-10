package self.learning.interview.coding;

/*
 <b>Problem Statement</b>
    Count number of failed attempt in binary search.
 */

public class BinarySearchAttemptCount {

    public static void main(String[] args) {
        final int[] input = {1, 2, 5, 7, 9, 12};

        final int itemToBeSearched1 = 8;
        final int arraySize = input.length;
        final int searchedIndex1 = myBinarySearch(input, arraySize, itemToBeSearched1);
        System.out.println(searchedIndex1 == -1 ? "Item Not Found" : "Item[" + itemToBeSearched1 + "] found at " + (searchedIndex1 + 1));


        final int itemToBeSearched2 = 7;
        final int searchedIndex2 = myBinarySearch(input, arraySize, itemToBeSearched2);
        System.out.println(searchedIndex2 == -1 ? "Item Not Found" : "Item[=" + itemToBeSearched2 + "] found at " + (searchedIndex2 + 1));

        final int itemToBeSearched3 = 15;
        final int searchedIndex3 = myBinarySearch(input, arraySize, itemToBeSearched3);
        System.out.println(searchedIndex3 == -1 ? "Item Not Found" : "Item[=" + itemToBeSearched3 + "] found at " + (searchedIndex3 + 1));

        final int itemToBeSearched4 = 0;
        final int searchedIndex4 = myBinarySearch(input, arraySize, itemToBeSearched4);
        System.out.println(searchedIndex4 == -1 ? "Item Not Found" : "Item[=" + itemToBeSearched4 + "] found at " + (searchedIndex4 + 1));
    }

    private static int myBinarySearch(final int[] input, final int end, final int itemToBeSearched) {
        int front = 0;
        int rear = end;
        int foundAt = -1;

        int notFoundCounter = 0;
        while (front < rear && foundAt == -1) {
            int mid = (front + rear) / 2;
            if (itemToBeSearched == input[mid]) foundAt = mid;
            else {
                if (itemToBeSearched < input[mid])
                    rear = mid;
                else
                    front = mid + 1;

                notFoundCounter++;
            }
        }
        System.out.println("Number of unsuccessful attempts made to search : " + notFoundCounter);

        return foundAt;
    }
}
