package tests;

import datastructures.AVLTree;

public class AVLTreeTest {

    public static void main(String[] args) {

        testLL();

        testRR();

        testLR();

        testRL();
    }

    private static void testLL() {

        AVLTree avl = new AVLTree();

        avl.insert(30);
        avl.insert(20);
        avl.insert(10);

        System.out.println("\nLL CASE");
        printTree(avl);
    }

    private static void testRR() {

        AVLTree avl = new AVLTree();

        avl.insert(10);
        avl.insert(20);
        avl.insert(30);

        System.out.println("\nRR CASE");
        printTree(avl);
    }

    private static void testLR() {

        AVLTree avl = new AVLTree();

        avl.insert(30);
        avl.insert(10);
        avl.insert(20);

        System.out.println("\nLR CASE");
        printTree(avl);
    }

    private static void testRL() {

        AVLTree avl = new AVLTree();

        avl.insert(10);
        avl.insert(30);
        avl.insert(20);

        System.out.println("\nRL CASE");
        printTree(avl);
    }

    private static void printTree(AVLTree avl) {

        System.out.print("Inorder: ");
        avl.inorder();

        System.out.print("Preorder: ");
        avl.preorder();

        System.out.println(
                "Root: " +
                avl.getRoot().data
        );

        System.out.println(
                "Height: " +
                avl.getHeight()
        );
    }
}