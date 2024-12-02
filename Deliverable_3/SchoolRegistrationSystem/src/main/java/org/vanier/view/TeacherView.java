package org.vanier.view;

import org.vanier.model.RegistrationSystem;
import org.vanier.view.teachersPanels.*;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

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

        // Add pages to the CardLayout panel with unique names
        mainPanel.add(teacherLoginPage.getTeacherLoginPagePanel(), "login");
        mainPanel.add(teacherMainMenuPage.getTeacherMainMenuPanel(), "mainMenu");
        mainPanel.add(teacherViewCourseTeachingPage.getTeacherViewCoursePanel(), "viewCourseTeaching"); // updated panel name
        mainPanel.add(teacherViewSchedulePage.getTeacherViewSchedulePanel(), "viewSchedule");
        mainPanel.add(teacherViewCourseDetailsPage.getTeacherCourseDetailsPanel(),"viewCourseDetails");

        // Add the mainPanel to the JFrame
        add(mainPanel);
    }
    // method to change language
    public void changeLanguage(ResourceBundle resourceBundle) {
        teacherLoginPage.changeLanguage(resourceBundle);
        teacherMainMenuPage.changeLanguage(resourceBundle);
        teacherViewCourseTeachingPage.changeLanguage(resourceBundle);
        teacherViewSchedulePage.changeLanguage(resourceBundle);
        teacherViewCourseDetailsPage.changeLanguage(resourceBundle);
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