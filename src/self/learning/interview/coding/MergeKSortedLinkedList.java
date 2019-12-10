package self.learning.interview.coding;

import java.util.ArrayList;

public class MergeKSortedLinkedList {

    /* The main function that takes an array of lists arr[0..last] and generates the sorted output */
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        int last = a.size() - 1;

        // repeat until only one list is left
        while (last != 0) {
            int i = 0, j = last;

            while (i < j) { // (i, j) forms a pair
                /* merge List i with List j and store merged list in List i */
                a.set(i, SortedMerge(a.get(i), a.get(j)));

                // consider next pair
                i++;
                j--;

                // If all pairs are merged, update last
                if (i >= j) last = j;
            }
        }

        return a.get(0);
    }

    /*
     * Takes two lists sorted in increasing order, and merge their nodes together to make one big sorted list.
     * Bel function takes O(Log n) extra space for recursive calls
     */
    private ListNode SortedMerge(ListNode headA, ListNode headB) {

        /* a dummy first ListNode to hang the result on */
        final ListNode dummyNode = new ListNode(0);

        /* tail points to the last result ListNode */
        ListNode tail = dummyNode;

        while (true) {
            /* if either list runs out, use the other list */
            if (headA == null) {
                tail.next = headB;
                break;
            }
            if (headB == null) {
                tail.next = headA;
                break;
            }

            /*
             * Compare the data of the two lists whichever lists' data is smaller,
             * append it into tail and advance the head to the next ListNode
             */
            if (headA.val <= headB.val) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }

            /* Advance the tail */
            tail = tail.next;
        }
        return dummyNode.next;
    }

    /* Function to print nodes in a given linked list */
    private void printList(ListNode ListNode) {
        while (ListNode != null) {
            System.out.print(ListNode.val + " ");
            ListNode = ListNode.next;
        }
    }

    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        final ArrayList<ListNode> linkedLists = new ArrayList<>();
        ListNode[] arr = new ListNode[k];

        linkedLists.add(new ListNode(1));
        linkedLists.get(0).next = new ListNode(3);
        linkedLists.get(0).next.next = new ListNode(5);
        linkedLists.get(0).next.next.next = new ListNode(7);

        linkedLists.add(new ListNode(2));
        linkedLists.get(1).next = new ListNode(4);
        linkedLists.get(1).next.next = new ListNode(6);
        linkedLists.get(1).next.next.next = new ListNode(8);

        linkedLists.add(new ListNode(9));
        linkedLists.get(1).next = new ListNode(9);
        linkedLists.get(1).next.next = new ListNode(10);
        linkedLists.get(1).next.next.next = new ListNode(11);

        // Merge all lists
        final MergeKSortedLinkedList m = new MergeKSortedLinkedList();
        ListNode head = m.mergeKLists(linkedLists);
        m.printList(head);
    }

    /* Definition for singly-linked list.*/
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
