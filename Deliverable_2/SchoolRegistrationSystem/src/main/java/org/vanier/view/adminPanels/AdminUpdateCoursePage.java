package org.vanier.view.adminPanels;

import org.vanier.controller.AdminManagementController;
import org.vanier.model.CourseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminUpdateCoursePage extends JFrame {
    private JPanel updateCoursePage;
    private JButton returnToPreviousPageButton;
    private JTextField courseIdTextField, courseNumberField, courseSectionField, courseCapacityField, courseCreditsField, startTimeField, endTimeField, dayOfWeekField;
    private JButton updateButton;
    private AdminManagementController controller;

    // Constructor that accepts AdminManagementController
    public AdminUpdateCoursePage(AdminManagementController controller) {
        this.controller = controller; // Store the controller instance

        // Set up action listeners
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int courseId = Integer.parseInt(courseIdTextField.getText());
                String courseNumber = courseNumberField.getText();
                int courseSection = Integer.parseInt(courseSectionField.getText());
                int courseCapacity = Integer.parseInt(courseCapacityField.getText());
                int courseCredits = Integer.parseInt(courseCreditsField.getText());
                int startTime = Integer.parseInt(startTimeField.getText());
                int endTime = Integer.parseInt(endTimeField.getText());
                String dayOfWeek = dayOfWeekField.getText();

                CourseModel updatedCourse = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
                controller.handleUpdateCourse(courseId, updatedCourse);
            }
        });

        returnToPreviousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setTitle("Update Course");
        setContentPane(updateCoursePage);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}