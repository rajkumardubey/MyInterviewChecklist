package self.learning.interview.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 <b>Problem Statement</b>
    implement BST
 */

public class BinarySearchTree {
    public static void main(String[] args) {
        final BST searchTree = new BST();

        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);

        System.out.println(Arrays.toString(searchTree.inOrderTraversal().toArray()));

        if (Arrays.asList(1, 2, 3, 5).equals(searchTree.inOrderTraversal())
                && !searchTree.contains(0)
                && searchTree.contains(1)
                && searchTree.contains(2)
                && searchTree.contains(3)
                && !searchTree.contains(4)
                && searchTree.contains(5)
                && !searchTree.contains(6)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

    }

    static class BST {

        private Node root;

        public BST() {
            //this.root = new Node();
        }

        public void put(int value) {
            // your code
            this.root = treeInsert(this.root, value);
        }

        private Node treeInsert(Node node, int value) {
            if (node == null) {
                node = new Node();
                node.val = value;
            } else if (value < node.val) node.left = treeInsert(node.left, value);
            else node.right = treeInsert(node.right, value);

            return node;
        }

        public boolean contains(int value) {
            // your code
            return doesContains(root, value);
        }

        private boolean doesContains(Node node, int value) {
            if (node == null) return false;
            else if (node.val == value) return true;
            else if (value < node.val) return doesContains(node.left, value);
            else return doesContains(node.right, value);
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null) return;
            inOrderTraversal(node.left, acc);
            acc.add(node.val);
            inOrderTraversal(node.right, acc);
        }

        private static class Node {
            Integer val;
            Node left;
            Node right;
        }
    }

}
