package org.vanier.view;

import org.vanier.model.RegistrationSystem;
import org.vanier.view.adminPanels.*;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminManagementView extends JFrame {
    private AdminAddCoursePage adminAddCoursePage;
    private AdminAddStudentPage adminAddStudentPage;
    private AdminLoginPage adminLoginPage;
    private AdminMainMenuPage adminMainMenuPage;
    private AdminManageAndGenerateReportsPage adminManageAndGenerateReportsPage;
    private AdminUpdateCoursePage adminUpdateCoursePage;
    private AdminViewStudentEnrollmentPage adminViewStudentEnrollmentPage;
    private AdminAddTeacherPage adminAddTeacherPage;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    // Buttons for the main menu
    private JButton addCourseButton;
    private JButton updateCourseButton;
    private JButton deleteCourseButton;
    private JButton generateReportButton;
    private JButton addStudentButton;
    private JButton addTeacherButton;
    private JButton viewEnrollmentsButton; // Added "View Enrollments" button

    public AdminManagementView() {
        setTitle("Admin Portal");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize CardLayout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Load ResourceBundle for localization
        ResourceBundle resourceBundle = RegistrationSystem.getInstance().getResourceBundle();

        // Initialize the main menu panel
        adminMainMenuPage = new AdminMainMenuPage(resourceBundle);

        // Initialize other pages
        adminAddCoursePage = new AdminAddCoursePage(resourceBundle, mainPanel);
        adminAddStudentPage = new AdminAddStudentPage(resourceBundle);
        adminAddTeacherPage = new AdminAddTeacherPage(resourceBundle);
        adminManageAndGenerateReportsPage = new AdminManageAndGenerateReportsPage(resourceBundle);
        adminUpdateCoursePage = new AdminUpdateCoursePage(resourceBundle);
        adminViewStudentEnrollmentPage = new AdminViewStudentEnrollmentPage();

        // Add pages to main panel
        mainPanel.add(adminMainMenuPage, "AdminMainMenuPage");
        mainPanel.add(adminAddCoursePage, "AdminAddCoursePage");
        mainPanel.add(adminAddStudentPage, "AdminAddStudentPage");
        mainPanel.add(adminAddTeacherPage, "AdminAddTeacherPage");
        mainPanel.add(adminManageAndGenerateReportsPage, "AdminManageAndGenerateReportsPage");
        mainPanel.add(adminUpdateCoursePage, "AdminUpdateCoursePage");
        mainPanel.add(adminViewStudentEnrollmentPage, "AdminViewStudentEnrollmentPage");

        // Extract buttons from adminMainMenuPage
        addCourseButton = adminMainMenuPage.getAddCourseButton();
        updateCourseButton = adminMainMenuPage.getUpdateCourseButton();
        deleteCourseButton = adminMainMenuPage.getDeleteCourseButton();
        generateReportButton = adminMainMenuPage.getGenerateReportsOnCourseButton();
        addStudentButton = adminMainMenuPage.getCreateStudentButton();
        addTeacherButton = adminMainMenuPage.getAddTeacherButton();
        viewEnrollmentsButton = new JButton(resourceBundle.getString("viewEnrollmentsButton")); // Add the "View Enrollments" button

        // Add main panel to the frame
        add(mainPanel);

        // Show the main menu initially
        cardLayout.show(mainPanel, "AdminMainMenuPage");
    }

    public JButton getAddCourseButton() {
        return addCourseButton;
    }

    public JButton getUpdateCourseButton() {
        return updateCourseButton;
    }

    public JButton getDeleteCourseButton() {
        return deleteCourseButton;
    }

    public JButton getGenerateReportButton() {
        return generateReportButton;
    }

    public JButton getAddStudentButton() {
        return addStudentButton;
    }

    public JButton getAddTeacherButton() {
        return addTeacherButton;
    }

    public JButton getViewEnrollmentsButton() { // Add getter for "View Enrollments" button
        return viewEnrollmentsButton;
    }

    public void navigateTo(String pageName) {
        cardLayout.show(mainPanel, pageName);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}