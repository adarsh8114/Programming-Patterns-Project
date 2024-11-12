package org.vanier.controller;

import org.vanier.model.AdminModel;
import org.vanier.model.CourseModel;
import org.vanier.model.StudentModel;

import java.util.List;

public class AdminManagementController {
    private final AdminModel adminModel = new AdminModel();

    public void handleAddCourse(CourseModel course) {
        adminModel.addCourse(course);
        System.out.println("Admin: Course added successfully.");
    }

    public void handleUpdateCourse(int courseId, CourseModel updatedCourse) {
        boolean success = adminModel.updateCourse(courseId, updatedCourse);
        if (success) {
            System.out.println("Admin: Course updated successfully.");
        } else {
            System.out.println("Admin: Failed to update course.");
        }
    }

    public boolean handleDeleteCourse(int courseId) {
        boolean success = adminModel.deleteCourse(courseId);
        if (success) {
            System.out.println("Admin: Course deleted successfully.");
        } else {
            System.out.println("Admin: Course not found.");
        }
        return success; // Return the result of the deletion attempt
    }

    public List<StudentModel> viewEnrollments(int courseId) {
        List<StudentModel> enrolledStudents = adminModel.getStudentEnrollments(courseId);
        System.out.println("Admin: Viewing enrollments for course ID " + courseId);
        for (StudentModel student : enrolledStudents) {
            System.out.println(" - " + student.getFirstName() + " " + student.getLastName() + " (Student ID: " + student.getId() + ")");
        }
        return enrolledStudents; // Return the list of enrolled students
    }

    public void generateReport() {
        String report = adminModel.generateEnrollmentReport();
        System.out.println(report);  // This could also be directed to a file or UI component.
    }
}