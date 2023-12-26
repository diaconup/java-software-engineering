package isp.lab6.exercise1;

import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestExercise1 {
    @Test
    public void testAdd(){
        StudentGradeManagementSystem sgms = new StudentGradeManagementSystem();
        sgms.SystemGradeManagementSystem();
        Student student1 = new Student("Paul", 1);
        Student student2 = new Student("Radu", 2);

        sgms.addStudent(student1);
        sgms.addStudent(student2);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(student1);
        expectedStudents.add(student2);

        assertEquals(expectedStudents, sgms.getStudents());
    }

    @Test
    public void testRemove(){
        StudentGradeManagementSystem sgms = new StudentGradeManagementSystem();
        Student student1 = new Student("Paul", 1);
        Student student2 = new Student("Radu", 2);
        sgms.SystemGradeManagementSystem();
        sgms.addStudent(student1);
        sgms.addStudent(student2);

        sgms.removeStudent(student1);

        ArrayList<Student> expectedStudents = new ArrayList<Student>();
        expectedStudents.add(student2);

        assertEquals(expectedStudents, sgms.getStudents());
    }

    @Test
    public void testUpdate(){
        StudentGradeManagementSystem system = new StudentGradeManagementSystem();
        system.SystemGradeManagementSystem();
        Student student1 = new Student("Paul", 123);
        system.addStudent(student1);
        system.updateStudent(student1, "Paul", 456);
        assert(student1.getName().equals("Paul"));
        assert(student1.getId() == 456);
    }

    @Test
    public void testAverage(){
        StudentGradeManagementSystem system = new StudentGradeManagementSystem();
        system.SystemGradeManagementSystem();
        Student student1 = new Student("Paul", 123);
        student1.addGrade("Math", 80);
        student1.addGrade("English", 90);
        assert(system.calculateAverageGrade(student1) == 85);
    }
}
