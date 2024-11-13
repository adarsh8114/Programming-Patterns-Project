package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;

public class AdminViewStudentEnrollmentPage extends JFrame {
    private JTextField courseIdTextField;
    private JTextArea enrollmentTextArea;
    private JButton viewStudentEnrollmentButton;
    private JButton returnToPreviousPageButton;

    public AdminViewStudentEnrollmentPage() {
        // Initialize the main panel
        JPanel viewEnrollmentPanel = new JPanel();
        viewEnrollmentPanel.setLayout(new BorderLayout());

        // Initialize components
        courseIdTextField = new JTextField(10);
        viewStudentEnrollmentButton = new JButton("View Enrollments");
        returnToPreviousPageButton = new JButton("Back");
        enrollmentTextArea = new JTextArea(15, 30);
        enrollmentTextArea.setEditable(false);

        // Top panel for input and button
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Course ID:"));
        topPanel.add(courseIdTextField);
        topPanel.add(viewStudentEnrollmentButton);

        // Center panel with scrollable text area
        JScrollPane scrollPane = new JScrollPane(enrollmentTextArea);

        // Bottom panel for back button
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(returnToPreviousPageButton);

        // Add sub-panels to the main panel
        viewEnrollmentPanel.add(topPanel, BorderLayout.NORTH);
        viewEnrollmentPanel.add(scrollPane, BorderLayout.CENTER);
        viewEnrollmentPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Set the main panel as the content pane
        setTitle("View Student Enrollment");
        setContentPane(viewEnrollmentPanel);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Getters for UI components to be accessed by the controller
    public JTextField getCourseIdTextField() {
        return courseIdTextField;
    }

    public JTextArea getEnrollmentTextArea() {
        return enrollmentTextArea;
    }

    public JButton getViewStudentEnrollmentButton() {
        return viewStudentEnrollmentButton;
    }

    public JButton getReturnToPreviousPageButton() {
        return returnToPreviousPageButton;
    }
}
