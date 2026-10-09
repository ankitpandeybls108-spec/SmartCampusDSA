package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

    private TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(T data) {
        root = new TreeNode<>(data);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode<T> node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean contains(T target) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode<T> current = queue.poll();

            if (current.data.equals(target)) {
                return true;
            }

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return false;
    }

    // =========================
    // PREORDER
    // Root -> Left -> Right
    // =========================

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(TreeNode<T> node) {

        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");

        preorder(node.left);

        preorder(node.right);
    }

    // =========================
    // INORDER
    // Left -> Root -> Right
    // =========================

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode<T> node) {

        if (node == null) {
            return;
        }

        inorder(node.left);

        System.out.print(node.data + " ");

        inorder(node.right);
    }

    // =========================
    // POSTORDER
    // Left -> Right -> Root
    // =========================

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(TreeNode<T> node) {

        if (node == null) {
            return;
        }

        postorder(node.left);

        postorder(node.right);

        System.out.print(node.data + " ");
    }

    // =========================
    // LEVEL ORDER
    // BFS
    // =========================

    public void levelOrder() {

        if (root == null) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode<T> current = queue.poll();

            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        System.out.println();
    }
}