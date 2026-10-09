package datastructures;

public class AVLTree {

    private TreeNode<Integer> root;

    public AVLTree() {
        root = null;
    }

    public TreeNode<Integer> getRoot() {
        return root;
    }

    // =========================
    // HEIGHT
    // =========================

    private int height(TreeNode<Integer> node) {

        if (node == null) {
            return -1;
        }

        return 1 + Math.max(
                height(node.left),
                height(node.right)
        );
    }

    // =========================
    // BALANCE FACTOR
    // =========================

    private int getBalance(TreeNode<Integer> node) {

        if (node == null) {
            return 0;
        }

        return height(node.left)
                - height(node.right);
    }

    // =========================
    // RIGHT ROTATION
    // =========================

    private TreeNode<Integer> rightRotate(
            TreeNode<Integer> y) {

        TreeNode<Integer> x = y.left;

        TreeNode<Integer> temp = x.right;

        // Rotation
        x.right = y;
        y.left = temp;

        return x;
    }

    // =========================
    // LEFT ROTATION
    // =========================

    private TreeNode<Integer> leftRotate(
            TreeNode<Integer> x) {

        TreeNode<Integer> y = x.right;

        TreeNode<Integer> temp = y.left;

        // Rotation
        y.left = x;
        x.right = temp;

        return y;
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

        // Normal BST insertion
        if (node == null) {
            return new TreeNode<>(value);
        }

        if (value < node.data) {

            node.left =
                    insertRecursive(
                            node.left,
                            value
                    );

        } else if (value > node.data) {

            node.right =
                    insertRecursive(
                            node.right,
                            value
                    );

        } else {

            // Ignore duplicate
            return node;
        }

        // Check balance
        int balance = getBalance(node);

        // =========================
        // LL CASE
        // =========================

        if (balance > 1
                && value < node.left.data) {

            return rightRotate(node);
        }

        // =========================
        // RR CASE
        // =========================

        if (balance < -1
                && value > node.right.data) {

            return leftRotate(node);
        }

        // =========================
        // LR CASE
        // =========================

        if (balance > 1
                && value > node.left.data) {

            node.left =
                    leftRotate(node.left);

            return rightRotate(node);
        }

        // =========================
        // RL CASE
        // =========================

        if (balance < -1
                && value < node.right.data) {

            node.right =
                    rightRotate(node.right);

            return leftRotate(node);
        }

        return node;
    }

    // =========================
    // SEARCH
    // =========================

    public boolean search(int value) {

        TreeNode<Integer> current = root;

        while (current != null) {

            if (value == current.data) {
                return true;
            }

            if (value < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // =========================
    // MINIMUM
    // =========================

    public int findMin() {

        if (root == null) {
            throw new IllegalStateException(
                    "AVL tree is empty."
            );
        }

        TreeNode<Integer> current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    // =========================
    // MAXIMUM
    // =========================

    public int findMax() {

        if (root == null) {
            throw new IllegalStateException(
                    "AVL tree is empty."
            );
        }

        TreeNode<Integer> current = root;

        while (current.right != null) {
            current = current.right;
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
    // PREORDER
    // =========================

    public void preorder() {

        preorderRecursive(root);

        System.out.println();
    }

    private void preorderRecursive(
            TreeNode<Integer> node) {

        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");

        preorderRecursive(node.left);

        preorderRecursive(node.right);
    }

    // =========================
    // HEIGHT
    // =========================

    public int getHeight() {
        return height(root);
    }
}