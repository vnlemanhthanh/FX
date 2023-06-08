/*******************************************************************************
 * Copyright (c) 2022.
 ******************************************************************************/

package nonlinear;

public class BST {
    private Node root;

    private class Node {
        private int key;           // sorted by key
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(int key, Node left, Node right, int size) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.size = size;
        }
    }
}
