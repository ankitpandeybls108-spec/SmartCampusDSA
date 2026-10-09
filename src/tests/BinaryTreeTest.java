package tests;

import datastructures.BinaryTree;

public class BinaryTreeTest {

    public static void main(String[] args) {

        BinaryTree<String> tree =
                new BinaryTree<>();

        tree.setRoot("Campus");

        System.out.println(
                "Is tree empty? " +
                tree.isEmpty()
        );

        System.out.println(
                "Root: " +
                tree.getRoot().data
        );

        System.out.println(
                "Node count: " +
                tree.countNodes()
        );

        System.out.println(
                "Height: " +
                tree.height()
        );

        System.out.println(
                "Contains Campus: " +
                tree.contains("Campus")
        );

        System.out.println(
                "Contains Library: " +
                tree.contains("Library")
        );
    }
}