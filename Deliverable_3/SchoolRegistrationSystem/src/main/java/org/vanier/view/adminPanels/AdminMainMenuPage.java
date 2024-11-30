package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminMainMenuPage extends JPanel {
    private JLabel optionsLabel;
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

    public AdminMainMenuPage() {
        // Set layout
        setLayout(new GridLayout(10, 1, 10, 10)); // Grid layout with spacing between components

        // Initialize components
        welcomeLabel = new JLabel("Welcome, Admin!", SwingConstants.CENTER);
        adminNameLabel = new JLabel("Admin Name: [Name]", SwingConstants.CENTER);
        typeOfUserLabel = new JLabel("User Type: Administrator", SwingConstants.CENTER);
        optionsLabel = new JLabel("Options:", SwingConstants.CENTER);

        addCourseButton = new JButton("Add Course");
        updateCourseButton = new JButton("Update Course");
        deleteCourseButton = new JButton("Delete Course");
        generateReportsOnCourseButton = new JButton("Generate Reports on Course");
        manageStudentEnrollmentsButton = new JButton("Manage Student Enrollments");
        viewStudentEnrollmentsButton = new JButton("View Student Enrollments");
        generateReportsOnStudentButton = new JButton("Generate Reports on Student");

        // Add components to the panel
        add(welcomeLabel);
        add(adminNameLabel);
        add(typeOfUserLabel);
        add(optionsLabel);
        add(addCourseButton);
        add(updateCourseButton);
        add(deleteCourseButton);
        add(generateReportsOnCourseButton);
        add(manageStudentEnrollmentsButton);
        add(viewStudentEnrollmentsButton);
        add(generateReportsOnStudentButton);
    }

    // Getters for UI elements to be accessed in the controller
    public JButton getAddCourseButton() {
        return addCourseButton;
    }

    public JButton getUpdateCourseButton() {
        return updateCourseButton;
    }

    public JButton getDeleteCourseButton() {
        return deleteCourseButton;
    }

    public JButton getGenerateReportsOnCourseButton() {
        return generateReportsOnCourseButton;
    }

    public JButton getManageStudentEnrollmentsButton() {
        return manageStudentEnrollmentsButton;
    }

    public JButton getViewStudentEnrollmentsButton() {
        return viewStudentEnrollmentsButton;
    }

    public JButton getGenerateReportsOnStudentButton() {
        return generateReportsOnStudentButton;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        optionsLabel.setText(resourceBundle.getString("optionsLabel"));
        welcomeLabel.setText(resourceBundle.getString("welcomeLabel"));
        typeOfUserLabel.setText(resourceBundle.getString("typeOfUserLabel"));
        addCourseButton.setText(resourceBundle.getString("addCourseButton"));
        updateCourseButton.setText(resourceBundle.getString("updateCourseButton"));
        deleteCourseButton.setText(resourceBundle.getString("deleteCourseButton"));
        generateReportsOnCourseButton.setText(resourceBundle.getString("generateReportsOnCourseButton"));
        manageStudentEnrollmentsButton.setText(resourceBundle.getString("manageStudentEnrollmentsButton"));
        viewStudentEnrollmentsButton.setText(resourceBundle.getString("viewStudentEnrollmentsButton"));
        generateReportsOnStudentButton.setText(resourceBundle.getString("generateReportsOnStudentButton"));
    }
}