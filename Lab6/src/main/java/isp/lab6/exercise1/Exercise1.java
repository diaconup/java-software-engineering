package isp.lab6.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        StudentGradeManagementSystem system = new StudentGradeManagementSystem();
        system.SystemGradeManagementSystem();

        Student Paul = new Student("Paul", 1);
        Student Radu = new Student("Radu", 2);


        system.addStudent(Paul);
        system.addStudent(Radu);


        system.displayStudents();

        system.updateStudent(Radu, "Radu", 2);


        Paul.addGrade("Math", 85);
        Paul.addGrade("Science", 92);
        Radu.addGrade("Math", 91);
        Radu.addGrade("Science", 88);


        System.out.println(Paul.getGradeReport());

        Paul.removeGrade("Science");

        System.out.println("Radu's average grade: " + system.calculateAverageGrade(Radu));

        system.removeStudent(Radu);

        system.displayStudents();
    }
}
