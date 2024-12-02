package org.vanier.controller;

import org.junit.Test;
import org.vanier.model.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdminManagementControllerTest {
    @Test
    public void testAddStudent() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        AdminModel adminModel = new AdminModel();

        // Prepare the student
        StudentModel student = new StudentModel("Jane", "Doe", "123-456-7890", "jane.doe@example.com", "password");
        student.setId(1);

        // Add student through AdminModel
        adminModel.addStudent(student);

        // Verify student exists in RegistrationSystem
        assertTrue(registrationSystem.getStudentList().contains(student));
    }

    @Test
    public void testAddTeacher() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        AdminModel adminModel = new AdminModel();

        // Prepare the teacher
        TeacherModel teacher = new TeacherModel(
                "John", "Smith", "987-654-3210", "john.smith@example.com", "password123", new ArrayList<>()
        );
        teacher.setId(1);

        // Add teacher through AdminModel
        adminModel.addTeacher(teacher);

        // Verify teacher exists in RegistrationSystem
        assertTrue(registrationSystem.getTeacherList().contains(teacher));
    }

    @Test
    public void testAddCourse() {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        AdminModel adminModel = new AdminModel();

        // Prepare the course
        CourseModel course = new CourseModel(
                "CS101", 1, 50, 3, 900, 1200, "Monday"
        );
        course.setCourseId(1);

        // Add course through AdminModel
        adminModel.addCourse(course);

        // Verify course exists in RegistrationSystem
        assertTrue(registrationSystem.getCourseList().contains(course));
    }
}