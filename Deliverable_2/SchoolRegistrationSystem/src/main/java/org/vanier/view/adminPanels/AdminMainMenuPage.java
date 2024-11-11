package org.vanier.view.adminPanels;

import javax.swing.*;

public class AdminMainMenuPage extends JFrame {
    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JLabel adminNameLabel;
    private JLabel typeOfUserLabel;
    private JButton addCourseButton;
    private JButton updateCourseButton;
    private JButton deleteCourseButton;
    private JLabel optionsLabel;
    private JButton generateReportsOnCourseButton;
    private JButton manageStudentEnrollmentsButton;
    private JButton viewStudentEnrollmentsButton;
    private JButton generateReportsOnStudentButton;

    public AdminMainMenuPage() {
        // Set up the frame properties
        setTitle("Admin Main Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize main panel and components
        mainPanel = new JPanel();
        welcomeLabel = new JLabel("Welcome, Admin!");
        adminNameLabel = new JLabel("Admin Name: [Name]");
        typeOfUserLabel = new JLabel("User Type: Administrator");
        optionsLabel = new JLabel("Options:");

        addCourseButton = new JButton("Add Course");
        updateCourseButton = new JButton("Update Course");
        deleteCourseButton = new JButton("Delete Course");
        generateReportsOnCourseButton = new JButton("Generate Reports on Course");
        manageStudentEnrollmentsButton = new JButton("Manage Student Enrollments");
        viewStudentEnrollmentsButton = new JButton("View Student Enrollments");
        generateReportsOnStudentButton = new JButton("Generate Reports on Student");

        // Add components to the panel
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

        // Set the panel as the content pane of the frame
        setContentPane(mainPanel);

        // Set a default size directly without calling pack()
        setSize(500, 300); // Adjust the width and height as needed

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);
    }
}
