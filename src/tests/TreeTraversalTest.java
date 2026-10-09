package tests;

import datastructures.BinaryTree;
import datastructures.TreeNode;

public class TreeTraversalTest {

    public static void main(String[] args) {

        BinaryTree<String> tree = new BinaryTree<>();

        // Create root
        tree.setRoot("A");

        TreeNode<String> root = tree.getRoot();

        // Level 1
        root.left = new TreeNode<>("B");
        root.right = new TreeNode<>("C");

        // Level 2
        root.left.left = new TreeNode<>("D");
        root.left.right = new TreeNode<>("E");

        root.right.left = new TreeNode<>("F");
        root.right.right = new TreeNode<>("G");

        System.out.println("Binary Tree Traversals");
        System.out.println("======================");

        System.out.print("Preorder:   ");
        tree.preorder();

        System.out.print("Inorder:    ");
        tree.inorder();

        System.out.print("Postorder:  ");
        tree.postorder();

        System.out.print("Level Order:");
        System.out.print(" ");
        tree.levelOrder();
    }
}