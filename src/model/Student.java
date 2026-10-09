package model;

public class Student {

    private int studentId;
    private String name;
    private String department;
    private String email;

    public Student(int studentId, String name, String department, String email) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    @Override
public boolean equals(Object obj) {

    if (this == obj) {
        return true;
    }

    if (!(obj instanceof Student)) {
        return false;
    }

    Student other = (Student) obj;

    return this.studentId == other.studentId;
}

@Override
public int hashCode() {
    return Integer.hashCode(studentId);
}
}