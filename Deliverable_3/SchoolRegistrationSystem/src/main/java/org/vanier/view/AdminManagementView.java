package org.vanier.view;

import org.vanier.model.RegistrationSystem;
import org.vanier.view.adminPanels.*;

import javax.swing.*;
import java.awt.*;

public class AdminManagementView extends JFrame {
    private static AdminAddCoursePage adminAddCoursePage;
    private static AdminAddStudentPage adminAddStudentPage;
    private static AdminLoginPage adminLoginPage;
    private static AdminMainMenuPage adminMainMenuPage;
    private static AdminManageAndGenerateReportsPage adminManageAndGenerateReportsPage;
    private static AdminUpdateCoursePage adminUpdateCoursePage;
    private static AdminViewStudentEnrollmentPage adminViewStudentEnrollmentPage;
    private static AdminAddTeacherPage adminAddTeacherPage;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JPanel adminMainMenuPanel;
    private JButton addCourseButton;
    private JButton updateCourseButton;
    private JButton deleteCourseButton;
    private JButton viewEnrollmentsButton;
    private JButton generateReportButton;
    private JButton addStudentButton;
    private JButton addTeacherButton;

    public AdminManagementView() {
        setTitle("Admin Portal");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize static fields
        initializePages();

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        adminMainMenuPanel = new JPanel();
        addCourseButton = new JButton("Add Course");
        updateCourseButton = new JButton("Update Course");
        deleteCourseButton = new JButton("Delete Course");
        viewEnrollmentsButton = new JButton("View Enrollments");
        generateReportButton = new JButton("Generate Report");
        addStudentButton = new JButton("Create Student");
        addTeacherButton = new JButton("Add Teacher");

        adminMainMenuPanel.add(addCourseButton);
        adminMainMenuPanel.add(updateCourseButton);
        adminMainMenuPanel.add(deleteCourseButton);
        adminMainMenuPanel.add(viewEnrollmentsButton);
        adminMainMenuPanel.add(generateReportButton);
        adminMainMenuPanel.add(addStudentButton);
        adminMainMenuPanel.add(addTeacherButton);

        // Apply language changes after initializing
        applyLanguageChanges();

        mainPanel.add(adminMainMenuPanel, "adminMainMenu");
        add(mainPanel);
    }

    private void initializePages() {
        // Initialize all static fields
        adminAddCoursePage = new AdminAddCoursePage();
        adminLoginPage = new AdminLoginPage();
        adminMainMenuPage = new AdminMainMenuPage();
        adminManageAndGenerateReportsPage = new AdminManageAndGenerateReportsPage();
        adminUpdateCoursePage = new AdminUpdateCoursePage();
        adminViewStudentEnrollmentPage = new AdminViewStudentEnrollmentPage();
        adminAddStudentPage = new AdminAddStudentPage();
        adminAddTeacherPage = new AdminAddTeacherPage();
    }

    private void applyLanguageChanges() {
        try {
            adminAddCoursePage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
            adminLoginPage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
            adminMainMenuPage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
            adminManageAndGenerateReportsPage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
            adminUpdateCoursePage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
            adminViewStudentEnrollmentPage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
        } catch (NullPointerException e) {
            System.err.println("Error applying language changes: " + e.getMessage());
        }
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

    public JButton getViewEnrollmentsButton() {
        return viewEnrollmentsButton;
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

    @Override
    public void dispose() {
        super.dispose();
    }
}