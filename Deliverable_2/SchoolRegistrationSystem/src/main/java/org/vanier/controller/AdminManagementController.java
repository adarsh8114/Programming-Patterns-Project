package org.vanier.controller;

import org.vanier.RegistrationSystem;
import org.vanier.model.AdminModel;
import org.vanier.model.CourseModel;
import org.vanier.model.StudentModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminManagementController {
    private AdminModel adminModel;
    private JFrame view;

    /**
     * Constructor for AdminManagementController.
     * Initializes the adminModel and view, and sets up listeners for UI actions.
     *
     * @param view The JFrame that represents the user interface view.
     */
    public AdminManagementController(JFrame view) {
        this.adminModel = new AdminModel();
        this.view = view;
        setupListeners();
    }

    /**
     * Sets up action listeners for the buttons in the view.
     * Each listener corresponds to a specific action (add, update, delete course, view enrollments, generate report).
     */
    private void setupListeners() {
        JButton addCourseButton = ((JButton) view.getContentPane().getComponent(0));
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Collect the course details
                String courseNumber = JOptionPane.showInputDialog(view, "Enter Course Number:");
                int courseSection = Integer.parseInt(JOptionPane.showInputDialog(view, "Enter Course Section:"));
                int courseCapacity = Integer.parseInt(JOptionPane.showInputDialog(view, "Enter Course Capacity:"));
                int courseCredits = Integer.parseInt(JOptionPane.showInputDialog(view, "Enter Course Credits:"));
                int startTime = Integer.parseInt(JOptionPane.showInputDialog(view, "Enter Start Time (e.g., 900 for 9:00 AM):"));
                int endTime = Integer.parseInt(JOptionPane.showInputDialog(view, "Enter End Time (e.g., 1700 for 5:00 PM):"));
                String dayOfWeek = JOptionPane.showInputDialog(view, "Enter Day of the Week:");

                // Create a new CourseModel object
                CourseModel newCourse = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
                handleAddCourse(newCourse);
            }
        });

        JButton updateCourseButton = ((JButton) view.getContentPane().getComponent(1));
        updateCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to update:"));

                    String courseNumber = JOptionPane.showInputDialog("Enter Updated Course Number:");
                    int courseSection = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Section:"));
                    int courseCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Capacity:"));
                    int courseCredits = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Credits:"));
                    int startTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Start Time (e.g., 900 for 9:00 AM):"));
                    int endTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated End Time (e.g., 1700 for 5:00 PM):"));
                    String dayOfWeek = JOptionPane.showInputDialog("Enter Updated Day of the Week:");

                    CourseModel updatedCourse = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits,
                            startTime, endTime, dayOfWeek);

                    boolean success = handleUpdateCourse(courseId, updatedCourse);

                    if (success) {
                        JOptionPane.showMessageDialog(null, "Course updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update course.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values where required.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton deleteCourseButton = ((JButton) view.getContentPane().getComponent(2));
        deleteCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int courseId = Integer.parseInt(JOptionPane.showInputDialog(view, "Enter Course ID to delete:"));
                    handleDeleteCourse(courseId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Invalid input. Please enter a numeric course ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton viewEnrollmentsButton = ((JButton) view.getContentPane().getComponent(3));
        viewEnrollmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to view enrollments:"));
                    handleViewEnrollments(courseId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid course ID. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton generateReportButton = ((JButton) view.getContentPane().getComponent(4));
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGenerateReport();
            }
        });
    }

    /**
     * Handles adding a new course to the registration system.
     *
     * @param model The CourseModel object containing details of the course to be added.
     */
    public void handleAddCourse(CourseModel model) {
        adminModel.addCourse(model);
        JOptionPane.showMessageDialog(view, "Course added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles updating an existing course in the registration system.
     *
     * @param courseId      The ID of the course to update.
     * @param updatedCourse The CourseModel object with updated details.
     * @return true if the course was updated successfully, false otherwise.
     */
    public boolean handleUpdateCourse(int courseId, CourseModel updatedCourse) {
        return adminModel.updateCourse(courseId, updatedCourse);
    }

    /**
     * Handles deleting a course from the registration system.
     *
     * @param courseId The ID of the course to delete.
     * @return true if the course was deleted successfully, false if the course was not found.
     */
    public boolean handleDeleteCourse(int courseId) {
        boolean success = adminModel.deleteCourse(courseId);

        if (success) {
            JOptionPane.showMessageDialog(view, "Course deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view, "Course not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return success;
    }

    /**
     * Retrieves and displays the list of students enrolled in a specific course.
     *
     * @param courseId The ID of the course to view enrollments for.
     */
    public List<StudentModel> handleViewEnrollments(int courseId) {
        return RegistrationSystem.getInstance().getEnrolledStudentsByCourseId(courseId);
    }

    /**
     * Generates an enrollment report for all courses and displays it.
     */
    public void handleGenerateReport() {
        String report = adminModel.generateEnrollmentReport();
        JOptionPane.showMessageDialog(view, report, "Enrollment Report", JOptionPane.INFORMATION_MESSAGE);
    }
}

