
package datastructures;

import model.Student;

public class StudentArray {

    private Student[] students;
    private int size;

    public StudentArray(int capacity) {
        students = new Student[capacity];
        size = 0;
    }

    // Insert student
    public void add(Student student) {

        if (size == students.length) {
            System.out.println("Array is full.");
            return;
        }

        students[size] = student;
        size++;

        System.out.println("Student added successfully.");
    }

    // Display all students
    public void display() {

        if (size == 0) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }

    // Search by student ID
    public Student searchById(int studentId) {

        for (int i = 0; i < size; i++) {

            if (students[i].getStudentId() == studentId) {
                return students[i];
            }
        }

        return null;
    }

    // Delete by student ID
    public boolean deleteById(int studentId) {

        for (int i = 0; i < size; i++) {

            if (students[i].getStudentId() == studentId) {

                // Shift elements left
                for (int j = i; j < size - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[size - 1] = null;
                size--;

                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }
}