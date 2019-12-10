package self.learning.interview.coding;

import java.util.*;

public class SlidingWindowMaximum {
    // Time Complexity: O(n*k)
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        final ArrayList<Integer> result = new ArrayList<>();
        for (int counter = 0; counter <= A.size() - B; counter++) {
            int max = A.get(counter);
            for (int j = 0; j < B; j++) max = Math.max(A.get(counter + j), max);
            result.add(max);
        }
        return result;
    }

    // Time Complexity: O(n)
    public ArrayList<Integer> slidingMaximum2(final List<Integer> A, int B) {
        final ArrayList<Integer> result = new ArrayList<>();

        if (B > A.size()) {
            result.add(1);
            return result;
        }

        final Deque<Integer> deque = new LinkedList<>();
        /* Step 1: handle first k elements in sliding window */
        for (int i = 0; i < B; i++) {
            /* remove all the elements which are smaller than the current elements */
            while (!deque.isEmpty() && A.get(deque.peekLast()) <= A.get(i)) deque.removeLast();

            deque.addLast(i); // add new element at the end
        }

        /* Step 2: handle rest of the element, one at a time A[k] to A[n-1] */
        for (int counter = B; counter < A.size(); counter++) {

            /* Before we do anything, get the first element from deque since its a maximum among previous k elements */
            result.add(A.get(deque.peekFirst()));

            /* Now remove the elements which are out for next window (next k elements) */
            while (!deque.isEmpty() && deque.peekFirst() <= counter - B) deque.removeFirst();

            /* Add the next element in the window = index counter
               Remove all the elements which are smaller than the next element = index counter */
            while (!deque.isEmpty() && A.get(deque.peekLast()) <= A.get(counter)) deque.removeLast();

            deque.addLast(counter); //add new element at the end
        }

        result.add(A.get(deque.peekFirst())); //to get the last max element

        return result;
    }

    public static void main(String[] args) {
        final SlidingWindowMaximum s = new SlidingWindowMaximum();
        ArrayList<Integer> integers = s.slidingMaximum2(Arrays.asList(656), 1);
        integers.forEach(num -> System.out.print(num + "  "));
    }
}
