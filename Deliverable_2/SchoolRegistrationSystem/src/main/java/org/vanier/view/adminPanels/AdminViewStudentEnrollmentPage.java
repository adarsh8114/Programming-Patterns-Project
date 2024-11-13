package org.vanier.view.adminPanels;

import org.vanier.controller.AdminManagementController;
import org.vanier.model.StudentModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminViewStudentEnrollmentPage extends JFrame {
    private JTextField courseIdTextField;
    private JTextArea enrollmentTextArea;
    private JButton viewStudentEnrollmentButton;
    private JButton returnToPreviousPageButton;
    private AdminManagementController controller;

    public AdminViewStudentEnrollmentPage(AdminManagementController controller) {
        this.controller = controller;

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

        // Set up action listeners
        viewStudentEnrollmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int courseId = Integer.parseInt(courseIdTextField.getText());
                    List<StudentModel> enrolledStudents = controller.handleViewEnrollments(courseId);

                    // Display students in the JTextArea
                    enrollmentTextArea.setText("Enrolled Students for Course ID: " + courseId + "\n");
                    for (StudentModel student : enrolledStudents) {
                        enrollmentTextArea.append(student.getFirstName() + " " + student.getLastName() + " (ID: " + student.getId() + ")\n");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Course ID.");
                }
            }
        });

        returnToPreviousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Set the main panel as the content pane
        setTitle("View Student Enrollment");
        setContentPane(viewEnrollmentPanel); // Set the main panel as content pane
        setSize(500, 400); // Adjusted size for better layout
        setLocationRelativeTo(null);
        setVisible(true);
    }
}