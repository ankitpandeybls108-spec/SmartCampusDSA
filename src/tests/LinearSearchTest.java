package tests;

import algorithms.LinearSearch;

public class LinearSearchTest {

    public static void main(String[] args) {

        int[] numbers = {
                10, 25, 31, 45, 60, 75
        };

        int target = 45;

        int index =
                LinearSearch.search(numbers, target);

        System.out.println(
                "Target: " + target
        );

        System.out.println(
                "Index: " + index
        );
    }
}