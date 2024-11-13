package org.vanier.controller;

import org.vanier.model.AdminModel;
import org.vanier.model.CourseModel;
import org.vanier.model.StudentModel;
import org.vanier.view.AdminManagementView;
import org.vanier.RegistrationSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminManagementController {
    private AdminModel adminModel;
    private AdminManagementView view;

    public AdminManagementController(AdminManagementView view) {
        this.adminModel = new AdminModel();
        this.view = view;
        setupListeners();
    }

    private void setupListeners() {
        view.getAddCourseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseNumber = JOptionPane.showInputDialog("Enter Course Number:");
                int courseSection = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Section:"));
                int courseCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Capacity:"));
                int courseCredits = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Credits:"));
                int startTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Start Time (e.g., 900 for 9:00 AM):"));
                int endTime = Integer.parseInt(JOptionPane.showInputDialog("Enter End Time (e.g., 1700 for 5:00 PM):"));
                String dayOfWeek = JOptionPane.showInputDialog("Enter Day of the Week:");

                CourseModel newCourse = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
                handleAddCourse(newCourse);
            }
        });

        view.getUpdateCourseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to update:"));
                    String courseNumber = JOptionPane.showInputDialog("Enter Updated Course Number:");
                    int courseSection = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Section:"));
                    int courseCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Capacity:"));
                    int courseCredits = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Credits:"));
                    int startTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Start Time:"));
                    int endTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated End Time:"));
                    String dayOfWeek = JOptionPane.showInputDialog("Enter Updated Day of the Week:");

                    CourseModel updatedCourse = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
                    handleUpdateCourse(courseId, updatedCourse);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Invalid input. Enter numeric values where required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getDeleteCourseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to delete:"));
                    handleDeleteCourse(courseId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Invalid input. Enter a numeric course ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getViewEnrollmentsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to view enrollments:"));
                    handleViewEnrollments(courseId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Invalid course ID. Enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getGenerateReportButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGenerateReport();
            }
        });
    }

    public void handleAddCourse(CourseModel model) {
        adminModel.addCourse(model);
        JOptionPane.showMessageDialog(view, "Course added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void handleUpdateCourse(int courseId, CourseModel updatedCourse) {
        boolean success = adminModel.updateCourse(courseId, updatedCourse);
        JOptionPane.showMessageDialog(view, success ? "Course updated successfully." : "Failed to update course.", success ? "Success" : "Error", success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }

    public boolean handleDeleteCourse(int courseId) {
        boolean success = adminModel.deleteCourse(courseId); // Assuming adminModel has a deleteCourse method
        return success;
    }

    public List<StudentModel> handleViewEnrollments(int courseId) {
        return RegistrationSystem.getInstance().getEnrolledStudentsByCourseId(courseId);
    }

    public void handleGenerateReport() {
        String report = adminModel.generateEnrollmentReport(); // Assuming this returns a report as a string
        JOptionPane.showMessageDialog(null, report, "Enrollment Report", JOptionPane.INFORMATION_MESSAGE);
    }
}