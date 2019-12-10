package self.learning.interview.coding;

public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode A) {
        if (A == null) return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(A.left);
            int rDepth = maxDepth(A.right);

            /* use the larger one */
            return lDepth > rDepth ? (lDepth + 1) : (rDepth + 1);
        }
    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(new MaxDepthBinaryTree().maxDepth(root));
    }

    static class TreeNode {
        private int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }
}

