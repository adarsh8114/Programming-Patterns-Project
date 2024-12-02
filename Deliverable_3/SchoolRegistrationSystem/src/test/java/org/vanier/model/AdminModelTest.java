package org.vanier.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdminModelTest {

    @Test
    public void testAddStudent() {
        AdminModel adminModel = new AdminModel();
        StudentModel student = new StudentModel("Jane", "Doe", "1234567890", "jane.doe@example.com", "password");

        adminModel.addStudent(student);
        assertTrue(RegistrationSystem.getInstance().getStudentList().contains(student));
    }

    @Test
    public void testAddTeacher() {
        AdminModel adminModel = new AdminModel();

        // Create a teacher with an empty list of courses
        TeacherModel teacher = new TeacherModel(
                "John", // firstName
                "Smith", // lastName
                "9876543210", // phoneNumber
                "john.smith@example.com", // emailAddress
                "password123", // password
                new ArrayList<>() // Empty list of coursesTeaching
        );

        // Add the teacher to the admin model
        adminModel.addTeacher(teacher);

        // Verify that the teacher has been added to the registration system
        assertTrue(RegistrationSystem.getInstance().getTeacherList().contains(teacher));
    }

    @Test
    public void testAddCourse() {
        AdminModel adminModel = new AdminModel();
        CourseModel course = new CourseModel("CS101", 1, 100, 3, 900, 1100, "Monday");

        adminModel.addCourse(course);
        assertTrue(RegistrationSystem.getInstance().getCourseList().contains(course));
    }

    @Test
    public void testUpdateCourse() {
        AdminModel adminModel = new AdminModel();
        CourseModel oldCourse = new CourseModel("CS101", 1, 100, 3, 900, 1100, "Monday");
        oldCourse.setCourseId(1);
        adminModel.addCourse(oldCourse);

        CourseModel updatedCourse = new CourseModel("CS102", 2, 150, 4, 1300, 1500, "Wednesday");
        boolean isUpdated = adminModel.updateCourse(1, updatedCourse);

        assertTrue(isUpdated);
        assertEquals(updatedCourse, adminModel.getCourseById(1));
    }

    @Test
    public void testDeleteCourse() {
        AdminModel adminModel = new AdminModel();
        CourseModel course = new CourseModel("CS101", 1, 100, 3, 900, 1100, "Monday");
        course.setCourseId(1);
        adminModel.addCourse(course);

        boolean isDeleted = adminModel.deleteCourse(1);
        assertTrue(isDeleted);
        assertNull(adminModel.getCourseById(1));
    }
}