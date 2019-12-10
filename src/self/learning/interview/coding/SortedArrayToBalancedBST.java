package self.learning.interview.coding;

import java.util.Arrays;
import java.util.List;

public class SortedArrayToBalancedBST {
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return fromSortedArrayRecursively(a, 0, a.size() - 1);
    }

    private TreeNode fromSortedArrayRecursively(final List<Integer> sortedArray,
                                                       final int start, final int end) {
        /* base case */
        if (start > end) return null;

        int middle = (start + end) / 2;

        final TreeNode node = new TreeNode(sortedArray.get(middle));
        node.left = fromSortedArrayRecursively(sortedArray, start, middle - 1);
        node.right = fromSortedArrayRecursively(sortedArray, middle + 1, end);

        return node;
    }

    public static void main(String[] args) {
        final  SortedArrayToBalancedBST s = new SortedArrayToBalancedBST();

        final TreeNode bst = s.sortedArrayToBST(Arrays.asList(10, 20, 30, 40, 50));

        bst.inorder(bst);
    }



    static class TreeNode {
        private int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }

        void inorder(final TreeNode root) {
            if (root == null) return;

            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
}


