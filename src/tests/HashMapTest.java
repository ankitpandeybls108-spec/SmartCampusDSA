package tests;

import datastructures.HashMap;

public class HashMapTest {

    public static void main(String[] args) {

        HashMap<String, String> map =
                new HashMap<>(10);

        map.put("LAB-101", "Computer Lab");
        map.put("LIB-201", "Central Library");
        map.put("HOST-101", "Student Hostel");
        map.put("AUD-301", "Auditorium");

        System.out.println(
                "LAB-101: " +
                map.get("LAB-101")
        );

        System.out.println(
                "LIB-201: " +
                map.get("LIB-201")
        );

        System.out.println(
                "Contains HOST-101: " +
                map.containsKey("HOST-101")
        );

        System.out.println(
                "Size: " +
                map.size()
        );

        System.out.println(
                "\nRemoving LIB-201..."
        );

        System.out.println(
                "Removed: " +
                map.remove("LIB-201")
        );

        System.out.println(
                "Contains LIB-201: " +
                map.containsKey("LIB-201")
        );
    }
}