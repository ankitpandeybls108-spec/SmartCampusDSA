package tests;

import datastructures.BinarySearchTree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("=== BST Test ===");

        // Insert values
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder after insertion:");
        bst.inorder();

        System.out.println("Size: " + bst.size());

        System.out.println("Search 60: "
                + bst.search(60));

        System.out.println("Search 100: "
                + bst.search(100));

        System.out.println("Minimum: "
                + bst.findMin());

        System.out.println("Maximum: "
                + bst.findMax());

        // Delete leaf
        bst.delete(20);

        System.out.println(
                "After deleting 20:"
        );
        bst.inorder();

        // Delete node with one child
        bst.insert(25);
        bst.delete(30);

        System.out.println(
                "After deleting 30:"
        );
        bst.inorder();

        // Delete node with two children
        bst.delete(70);

        System.out.println(
                "After deleting 70:"
        );
        bst.inorder();
    }
}