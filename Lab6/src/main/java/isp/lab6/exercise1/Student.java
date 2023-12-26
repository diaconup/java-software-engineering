package isp.lab6.exercise1;

import java.util.HashMap;
public class Student{
    //attributes
    private String name;
    private int id;
    HashMap<String, Integer> grades;

    //constructor
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new HashMap<>();
    }

    //methods
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addGrade(String subject, int grade) {
        this.grades.put(subject, grade);
    }
    public void removeGrade(String subject) {
        this.grades.remove(subject);
    }
    public double calculateAverageGrade() {
        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double)sum / grades.size();
    }
    @Override
    public String toString() {
        return "Student " + this.id + ": " + this.name;
    }
    public String getGradeReport() {
        StringBuilder report = new StringBuilder();
        report.append("Grade report for " + this.name + ":\n");
        for (String subject : this.grades.keySet()) {
            report.append(subject + ": " + this.grades.get(subject) + "\n");
        }
        report.append("Average grade: " + this.calculateAverageGrade());
        return report.toString();
    }
}
