package self.learning.interview.coding;

/*
 <b>Problem Statement</b>
    Implement a binary search without knowing the size of an array.
 */
public class BinarySearchWithIndexOutOfBoundException {
    private static int myBinarySearch(final int[] array, final int itemToBeSearched) {
        int counter = 1;
        int begin = 0;
        int end = 1;
        int temp;
        boolean done = false;

        while (!done) {
            try {
                /* item to be searched is not there in the array at all
                & is greater then the largest element of the array */
                if (end < begin) {
                    done = true;
                    break;
                }

                if (itemToBeSearched == array[end]) return end; // item found
                else if (itemToBeSearched > array[end]) { // increment end exponentially
                    temp = begin;
                    begin = end;
                    end = temp + (int) Math.pow(2, counter);
                    counter++;
                } else { //found the upper bounds
                    done = true;
                    break;
                }
            } catch (final ArrayIndexOutOfBoundsException ex) {
                end = (end - begin) / 2;
                counter = 0;
            }
        }

        return done ? binarySearch(array, begin, end, itemToBeSearched) : -1;
    }

    private static int binarySearch(final int[] array, final int low, final int high, final int itemToBeSearched) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (array[mid] == itemToBeSearched)
                return mid;
            if (array[mid] > itemToBeSearched)
                return binarySearch(array, low, mid - 1, itemToBeSearched);
            return binarySearch(array, mid + 1, high, itemToBeSearched);
        }
        return -1;
    }

    public static void main(String[] args) {
        final int[] input = {1, 2, 5, 7, 9, 12};

        final int itemToBeSearched1 = 8;
        final int searchedIndex1 = myBinarySearch(input, itemToBeSearched1);
        System.out.println(searchedIndex1 == -1 ? "Item Not Found" : "Item[" + itemToBeSearched1 + "] found at " + (searchedIndex1 + 1));


        final int itemToBeSearched2 = 7;
        final int searchedIndex2 = myBinarySearch(input, itemToBeSearched2);
        System.out.println(searchedIndex2 == -1 ? "Item Not Found" : "Item[=" + itemToBeSearched2 + "] found at " + (searchedIndex2 + 1));

        final int itemToBeSearched3 = 15;
        final int searchedIndex3 = myBinarySearch(input, itemToBeSearched3);
        System.out.println(searchedIndex3 == -1 ? "Item Not Found" : "Item[=" + itemToBeSearched3 + "] found at " + (searchedIndex3 + 1));

        final int itemToBeSearched4 = 0;
        final int searchedIndex4 = myBinarySearch(input, itemToBeSearched4);
        System.out.println(searchedIndex4 == -1 ? "Item Not Found" : "Item[=" + itemToBeSearched4 + "] found at " + (searchedIndex4 + 1));
    }


}