package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminViewStudentEnrollmentPage extends JPanel {
    private JTextField courseIdTextField;
    private JTextArea enrollmentTextArea;
    private JButton viewStudentEnrollmentButton;
    private JButton returnToPreviousPageButton;

    public AdminViewStudentEnrollmentPage() {
        // Set layout for the main panel
        setLayout(new BorderLayout());

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
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
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

    public void changeLanguage(ResourceBundle resourceBundle) {
        returnToPreviousPageButton.setText(resourceBundle.getString("returnToPreviousPageButton"));
        viewStudentEnrollmentButton.setText(resourceBundle.getString("viewStudentEnrollmentButton"));
    }
}
