package services;

import datastructures.StudentArray;
import model.Student;

public class StudentManager {

    private StudentArray students;

    public StudentManager(int capacity) {
        students = new StudentArray(capacity);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudent(int studentId) {
        return students.searchById(studentId);
    }

    public boolean removeStudent(int studentId) {
        return students.deleteById(studentId);
    }

    public int totalStudents() {
        return students.size();
    }

    public void displayStudents() {
        students.display();
    }
}