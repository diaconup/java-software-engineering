package isp.lab6.exercise1;

import java.util.ArrayList;

public class StudentGradeManagementSystem {
    private ArrayList<Student> students;
    public void SystemGradeManagementSystem(){
        this.students = new ArrayList<Student>();
    }
    public void addStudent(Student student) {
        this.students.add(student);
    }
    public void removeStudent(Student student) {
        this.students.remove(student);
    }
    public void updateStudent(Student student, String name, int id) {
        student.setName(name);
        student.setId(id);
    }
    public ArrayList<Student> getStudents() {
        return this.students;
    }
    public double calculateAverageGrade(Student student) {
        return student.calculateAverageGrade();
    }
    public void displayStudents() {
        System.out.println("List of students:");
        for (Student student : this.students) {
            System.out.println(student);
        }
    }
}
