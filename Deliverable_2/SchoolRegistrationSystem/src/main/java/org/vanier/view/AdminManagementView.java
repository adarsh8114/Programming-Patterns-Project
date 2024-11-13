package org.vanier.view;

import org.vanier.controller.AdminManagementController;
import org.vanier.factory.CourseFactory;
import org.vanier.model.CourseModel;
import org.vanier.model.StudentModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminManagementView extends JFrame {
    private JButton addCourseButton;
    private JButton updateCourseButton;
    private JButton deleteCourseButton;
    private JButton viewEnrollmentsButton;
    private JButton generateReportButton;
    private AdminManagementController controller;

    /**
     * Constructs the AdminManagementView with the given controller.
     * Initializes UI components and sets up action listeners for course management operations.
     *
     * @param controller The AdminManagementController that handles business logic and database interaction.
     */
    public AdminManagementView(AdminManagementController controller) {
        this.controller = controller; // Initialize the controller here

        // Initialize buttons
        addCourseButton = new JButton("Add Course");
        updateCourseButton = new JButton("Update Course");
        deleteCourseButton = new JButton("Delete Course");
        viewEnrollmentsButton = new JButton("View Enrollments");
        generateReportButton = new JButton("Generate Report");

        // Set up button listeners

        /**
         * Listener for adding a new course.
         * Opens input dialogs to collect course details and calls the controller's add course method.
         */
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code for adding a course using controller
            }
        });

        /**
         * Listener for updating an existing course.
         * Prompts the user to enter the course ID and updated details, then calls the controller's update method.
         */
        updateCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code for updating a course using controller
            }
        });

        /**
         * Listener for deleting a course.
         * Prompts the user to enter the course ID and calls the controller's delete method.
         */
        deleteCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code for deleting a course using controller
            }
        });

        /**
         * Listener for viewing enrollments of a course.
         * Prompts the user to enter the course ID, retrieves enrollments from the controller, and displays them.
         */
        viewEnrollmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the course ID to view enrollments
                    int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to view enrollments:"));
                    controller.handleViewEnrollments(courseId); // Ensure this calls the public method in the controller
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid course ID. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
         * Listener for generating an enrollment report.
         * Calls the controller's method to generate the report and display it.
         */
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleGenerateReport(); // Display handled in the method
            }
        });

        // Layout setup
        JPanel panel = new JPanel();
        panel.add(addCourseButton);
        panel.add(updateCourseButton);
        panel.add(deleteCourseButton);
        panel.add(viewEnrollmentsButton);
        panel.add(generateReportButton);
        add(panel);

        setTitle("Admin Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

