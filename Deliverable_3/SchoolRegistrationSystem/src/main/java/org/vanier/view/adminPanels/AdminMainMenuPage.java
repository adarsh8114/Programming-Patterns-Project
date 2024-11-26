package org.vanier.view.adminPanels;

import javax.swing.*;
import java.util.ResourceBundle;

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

    public AdminMainMenuPage() {
        setTitle("Admin Main Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel = new JPanel();
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

        setContentPane(mainPanel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
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

    public void changeLanguage(ResourceBundle resourceBundle){
        optionsLabel.setText(resourceBundle.getString("optionsLabel"));
        welcomeLabel.setText(resourceBundle.getString("welcomeLabel"));
        typeOfUserLabel.setText(resourceBundle.getString("typeOfUserLabel"));
        addCourseButton.setText(resourceBundle.getString("addCourseButton"));
        updateCourseButton.setText(resourceBundle.getString("updateCourseButton"));
        this.deleteCourseButton.setText(resourceBundle.getString("deleteCourseButton"));
        this.generateReportsOnCourseButton.setText(resourceBundle.getString("generateReportsOnCourseButton"));
        this.manageStudentEnrollmentsButton.setText(resourceBundle.getString("manageStudentEnrollmentsButton"));
        this.viewStudentEnrollmentsButton.setText(resourceBundle.getString("viewStudentEnrollmentsButton"));
        this.generateReportsOnStudentButton.setText(resourceBundle.getString("generateReportsOnStudentButton"));
    }
}