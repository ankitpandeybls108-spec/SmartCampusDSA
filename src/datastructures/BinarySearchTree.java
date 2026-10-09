package datastructures;

public class BinarySearchTree {

    private TreeNode<Integer> root;

    public BinarySearchTree() {
        root = null;
    }

    public TreeNode<Integer> getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // =========================
    // INSERT
    // =========================

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode<Integer> insertRecursive(
            TreeNode<Integer> node,
            int value) {

        // Empty position found
        if (node == null) {
            return new TreeNode<>(value);
        }

        if (value < node.data) {

            node.left = insertRecursive(node.left, value);

        } else if (value > node.data) {

            node.right = insertRecursive(node.right, value);

        }

        // Duplicate values are ignored
        return node;
    }

    // =========================
    // SEARCH
    // =========================

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(
            TreeNode<Integer> node,
            int value) {

        if (node == null) {
            return false;
        }

        if (value == node.data) {
            return true;
        }

        if (value < node.data) {
            return searchRecursive(node.left, value);
        }

        return searchRecursive(node.right, value);
    }

    // =========================
    // FIND MINIMUM
    // =========================

    public int findMin() {

        if (root == null) {
            throw new IllegalStateException(
                    "BST is empty."
            );
        }

        TreeNode<Integer> current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    // =========================
    // FIND MAXIMUM
    // =========================

    public int findMax() {

        if (root == null) {
            throw new IllegalStateException(
                    "BST is empty."
            );
        }

        TreeNode<Integer> current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    // =========================
    // DELETE
    // =========================

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode<Integer> deleteRecursive(
            TreeNode<Integer> node,
            int value) {

        if (node == null) {
            return null;
        }

        if (value < node.data) {

            node.left = deleteRecursive(node.left, value);

        } else if (value > node.data) {

            node.right = deleteRecursive(node.right, value);

        } else {

            // Case 1: No child
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (node.left == null) {
                return node.right;
            }

            // Case 3: Only left child
            if (node.right == null) {
                return node.left;
            }

            // Case 4: Two children
            int successorValue = findMin(node.right);

            node.data = successorValue;

            node.right =
                    deleteRecursive(
                            node.right,
                            successorValue
                    );
        }

        return node;
    }

    private int findMin(TreeNode<Integer> node) {

        TreeNode<Integer> current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    // =========================
    // INORDER
    // =========================

    public void inorder() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(
            TreeNode<Integer> node) {

        if (node == null) {
            return;
        }

        inorderRecursive(node.left);

        System.out.print(node.data + " ");

        inorderRecursive(node.right);
    }

    // =========================
    // COUNT
    // =========================

    public int size() {
        return countNodes(root);
    }

    private int countNodes(TreeNode<Integer> node) {

        if (node == null) {
            return 0;
        }

        return 1
                + countNodes(node.left)
                + countNodes(node.right);
    }
}