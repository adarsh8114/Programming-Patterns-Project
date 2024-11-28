package org.vanier.view;

import org.vanier.model.RegistrationSystem;
import org.vanier.view.teachersPanels.*;

import javax.swing.*;
import java.awt.*;

public class TeacherView extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private TeacherLoginPage teacherLoginPage;
    private TeacherMainMenuPage teacherMainMenuPage;
    private TeacherViewCourseTeachingPage teacherViewCourseTeachingPage;
    private TeacherViewSchedulePage teacherViewSchedulePage;
    private TeacherViewCourseDetailsPage teacherViewCourseDetailsPage;

    public TeacherView() throws HeadlessException {
        setTitle("Teacher Portal");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Initialize CardLayout and JPanel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize all the teacher pages
        teacherLoginPage = new TeacherLoginPage();
        teacherMainMenuPage = new TeacherMainMenuPage();
        teacherViewCourseTeachingPage = new TeacherViewCourseTeachingPage();
        teacherViewSchedulePage = new TeacherViewSchedulePage();
        teacherViewCourseDetailsPage = new TeacherViewCourseDetailsPage();

        teacherLoginPage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
        teacherMainMenuPage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
        teacherViewCourseTeachingPage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());
        teacherViewSchedulePage.changeLanguage(RegistrationSystem.getInstance().getResourceBundle());

        // Add pages to the CardLayout panel with unique names
        mainPanel.add(teacherLoginPage.getTeacherLoginPagePanel(), "login");
        mainPanel.add(teacherMainMenuPage.getTeacherMainMenuPanel(), "mainMenu");
        mainPanel.add(teacherViewCourseTeachingPage.getTeacherViewCoursePanel(), "viewCourseTeaching"); // updated panel name
        mainPanel.add(teacherViewSchedulePage.getTeacherViewSchedulePanel(), "viewSchedule");
        mainPanel.add(teacherViewCourseDetailsPage.getTeacherCourseDetailsPanel(),"viewCourseDetails");

        // Add the mainPanel to the JFrame
        add(mainPanel);
    }

    // Method to show a specific panel by name
    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    // Convenience methods to show specific panels
    public void showLoginPanel() {
        cardLayout.show(mainPanel, "login");
    }

    public void showMainMenuPanel() {
        cardLayout.show(mainPanel, "mainMenu");
    }

    public void showViewCourseTeachingPanel() {
        cardLayout.show(mainPanel, "viewCourseTeaching"); // updated panel name
    }

    public void showViewSchedulePanel() {
        cardLayout.show(mainPanel, "viewSchedule");
    }

    public void showViewCourseDetailsPanel() {cardLayout.show(mainPanel, "viewCourseDetails");}

    // Getters for the individual pages, in case they are needed
    public TeacherLoginPage getTeacherLoginPage() {
        return teacherLoginPage;
    }

    public TeacherMainMenuPage getTeacherMainMenuPage() {
        return teacherMainMenuPage;
    }

    public TeacherViewCourseTeachingPage getTeacherViewCourseTeachingPage() {
        return teacherViewCourseTeachingPage;
    }

    public TeacherViewSchedulePage getTeacherViewSchedulePage() {
        return teacherViewSchedulePage;
    }

    public TeacherViewCourseDetailsPage getTeacherViewCourseDetailsPage() {
        return teacherViewCourseDetailsPage;
    }
}