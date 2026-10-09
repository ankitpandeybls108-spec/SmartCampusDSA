package tests;

import algorithms.BinarySearch;

public class BinarySearchTest {

    public static void main(String[] args) {

        int[] numbers = {
                10, 20, 30, 40, 50, 60, 70
        };

        int target = 60;

        int index =
                BinarySearch.search(numbers, target);

        System.out.println(
                "Target: " + target
        );

        System.out.println(
                "Index: " + index
        );
    }
}