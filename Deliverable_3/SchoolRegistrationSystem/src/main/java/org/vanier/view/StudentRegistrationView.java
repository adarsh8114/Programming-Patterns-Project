package org.vanier.view;


import org.vanier.model.RegistrationSystem;
import org.vanier.view.studentsPanels.*;

import javax.swing.*;
import java.awt.*;

public class StudentRegistrationView extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private StudentLoginPage studentLoginPage;
    private StudentMainMenuPage studentMainMenuPage;

    private StudentRegisterCoursePage studentRegisterCoursePage;

    private StudentViewSchedulePage studentViewSchedulePage;

    private StudentDropCoursePage studentDropCoursePage;

    public StudentRegistrationView() throws HeadlessException {
        setTitle("Student Portal");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        studentLoginPage = new StudentLoginPage();
        studentMainMenuPage = new StudentMainMenuPage();
        studentRegisterCoursePage = new StudentRegisterCoursePage();
        studentViewSchedulePage = new StudentViewSchedulePage();
        studentDropCoursePage = new StudentDropCoursePage();

        studentLoginPage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
        studentMainMenuPage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
        studentRegisterCoursePage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
        studentViewSchedulePage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
        studentDropCoursePage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());

        mainPanel.add(studentLoginPage.getStudentLoginPanel(), "login");
        mainPanel.add(studentMainMenuPage.getStudentMainMenuPanel(), "mainMenu");
        mainPanel.add(studentRegisterCoursePage.getStudentRegisterCoursePanel(), "registerCourse");
        mainPanel.add(studentViewSchedulePage.getStudentViewSchedulePanel(), "viewSchedule");
        mainPanel.add(studentDropCoursePage.getStudentDropCoursePanel(), "dropCourse");

        add(mainPanel);
        showLoginPanel();
    }

    /**
     * makes the login menu panel visible
     */
    public void showLoginPanel() {
        cardLayout.show(mainPanel, "login");
    }

    /**
     * makes the main menu panel visible
     */
    public void showMainMenuPanel() {
        cardLayout.show(mainPanel, "mainMenu");
    }

    /**
     * makes the register menu panel visible
     */
    public void showRegisterCoursePanel() {
        cardLayout.show(mainPanel, "registerCourse");
    }

    /**
     * makes the course schedule panel visible
     */
    public void showViewSchedulePanel() {
        cardLayout.show(mainPanel, "viewSchedule");
    }

    /**
     * makes the drop course panel visible
     */
    public void showDropCoursePanel() {
        cardLayout.show(mainPanel, "dropCourse");
    }

    public StudentLoginPage getStudentLoginPage() {
        return studentLoginPage;
    }

    public StudentMainMenuPage getStudentMainMenuPage() {
        return studentMainMenuPage;
    }

    public StudentRegisterCoursePage getStudentRegisterCoursePage() {
        return studentRegisterCoursePage;
    }

    public StudentViewSchedulePage getStudentViewSchedulePage() {
        return studentViewSchedulePage;
    }

    public StudentDropCoursePage getStudentDropCoursePage() {
        return studentDropCoursePage;
    }
}
