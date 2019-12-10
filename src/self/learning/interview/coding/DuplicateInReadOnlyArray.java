package self.learning.interview.coding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 <b>Problem Statement</b>
 Given a read only array of size ( n+1 ), find one of the multiple repeating elements in the array
 where the array contains integers only between 1 and n.
 Note: Read only array means that the contents of the array can’t be modified.
 */
public class DuplicateInReadOnlyArray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int repeatedNumber(final List<Integer> A) {
        int slow = A.get(0);
        int fast = A.get(A.get(0));

        while (slow != fast) {
            slow = A.get(slow);
            fast = A.get(A.get(fast));
        }

        fast = 0;
        while (slow != fast) {
            slow = A.get(slow);
            fast = A.get(fast);
        }
        if (slow == 0) return -1;

        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new DuplicateInReadOnlyArray().repeatedNumber(Arrays.asList(3, 4, 1, 4, 1)));
    }
}
