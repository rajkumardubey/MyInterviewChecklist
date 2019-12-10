package self.learning.interview.coding;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null || B == C) return A;

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = A;
        int pos = 1;

        // Go "B-1" places
        ListNode start = fakeHead;
        ListNode current = A;
        while (pos < B) {
            start = current;
            current = current.next;
            pos++;
        }

        //reverse (C-B) positions
        ListNode previous = null;
        ListNode tail = current;
        ListNode next;
        while (pos <= C) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            pos++;
        }
        start.next = previous;
        tail.next = current;
        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        listNode.next = new ListNode(20);
        listNode.next.next = new ListNode(30);
        listNode.next.next.next = new ListNode(40);
        listNode.next.next.next.next = new ListNode(50);
        listNode.next.next.next.next.next = new ListNode(60);
        listNode.next.next.next.next.next.next = new ListNode(70);
        listNode.next.next.next.next.next.next.next = new ListNode(80);
        listNode.next.next.next.next.next.next.next.next = new ListNode(90);
        listNode.next.next.next.next.next.next.next.next.next = new ListNode(100);

        ReverseLinkedList2 r = new ReverseLinkedList2();

        r.printList(listNode);
        ListNode result = r.reverseBetween(listNode, 3, 7);
        r.printList(result);
    }

    private void printList(ListNode result) {
        ListNode temp = result;

        System.out.println("List now: ");
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print(" null\n\n");
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
