package org.vanier.view.adminPanels;

import org.vanier.controller.AdminManagementController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainMenuPage extends JFrame {
    private JLabel optionsLabel;
    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JLabel adminNameLabel;
    private JLabel typeOfUserLabel;
    private JButton addCourseButton;
    private JButton updateCourseButton;
    private JButton deleteCourseButton;
    private JButton generateReportsOnCourseButton;
    private JButton manageStudentEnrollmentsButton;
    private JButton viewStudentEnrollmentsButton;
    private JButton generateReportsOnStudentButton;
    private AdminManagementController controller;

    public AdminMainMenuPage(AdminManagementController controller) {
        this.controller = controller; // Store the controller instance

        setTitle("Admin Main Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize main panel first
        mainPanel = new JPanel();

        // Initialize components
        optionsLabel = new JLabel("Options:");
        welcomeLabel = new JLabel("Welcome, Admin!");
        adminNameLabel = new JLabel("Admin Name: [Name]");
        typeOfUserLabel = new JLabel("User Type: Administrator");

        addCourseButton = new JButton("Add Course");
        updateCourseButton = new JButton("Update Course");
        deleteCourseButton = new JButton("Delete Course");
        generateReportsOnCourseButton = new JButton("Generate Reports on Course");
        manageStudentEnrollmentsButton = new JButton("Manage Student Enrollments");
        viewStudentEnrollmentsButton = new JButton("View Student Enrollments");
        generateReportsOnStudentButton = new JButton("Generate Reports on Student");

        // Add components to main panel in order
        mainPanel.add(welcomeLabel);
        mainPanel.add(adminNameLabel);
        mainPanel.add(typeOfUserLabel);
        mainPanel.add(optionsLabel);
        mainPanel.add(addCourseButton);
        mainPanel.add(updateCourseButton);
        mainPanel.add(deleteCourseButton);
        mainPanel.add(generateReportsOnCourseButton);
        mainPanel.add(manageStudentEnrollmentsButton);
        mainPanel.add(viewStudentEnrollmentsButton);
        mainPanel.add(generateReportsOnStudentButton);

        // Set main panel as the content pane
        setContentPane(mainPanel);
        setSize(500, 300);
        setLocationRelativeTo(null);

        // Add action listeners
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminAddCoursePage(controller).setVisible(true);
            }
        });

        updateCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminUpdateCoursePage(controller).setVisible(true);
            }
        });

        deleteCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to delete:"));
                    boolean success = controller.handleDeleteCourse(courseId); // Call the updated method
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Course deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Course not found. Please check the Course ID.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Course ID. Please enter a numeric value.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error deleting course: " + ex.getMessage());
                }
            }
        });

        generateReportsOnCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleGenerateReport(); // Call the controller's method to generate a report
            }
        });

        setVisible(true);
    }
}