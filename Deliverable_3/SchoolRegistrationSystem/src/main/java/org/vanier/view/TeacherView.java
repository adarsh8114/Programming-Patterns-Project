package org.vanier.view;

import org.vanier.view.teachersPanels.TeacherLoginPage;
import org.vanier.view.teachersPanels.TeacherMainMenuPage;
import org.vanier.view.teachersPanels.TeacherViewCourseDetailsPage;
import org.vanier.view.teachersPanels.TeacherViewSchedulePage;

import javax.swing.*;
import java.awt.*;

public class TeacherView extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private TeacherLoginPage teacherLoginPage;
    private TeacherMainMenuPage teacherMainMenuPage;
    private TeacherViewCourseDetailsPage teacherViewCourseDetailsPage;
    private TeacherViewSchedulePage teacherViewSchedulePage;

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
        teacherViewCourseDetailsPage = new TeacherViewCourseDetailsPage();
        teacherViewSchedulePage = new TeacherViewSchedulePage();

        // Add pages to the CardLayout panel with unique names
        mainPanel.add(teacherLoginPage.getTeacherLoginPagePanel(), "login");
        mainPanel.add(teacherMainMenuPage.getTeacherMainMenuPanel(), "mainMenu");
        mainPanel.add(teacherViewCourseDetailsPage.getTeacherViewCoursePanel(), "viewCourseDetails"); // updated panel name
        mainPanel.add(teacherViewSchedulePage.getTeacherViewSchedulePanel(), "viewSchedule");

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

    public void showViewCourseDetailsPanel() {
        cardLayout.show(mainPanel, "viewCourseDetails"); // updated panel name
    }

    public void showViewSchedulePanel() {
        cardLayout.show(mainPanel, "viewSchedule");
    }

    // Getters for the individual pages, in case they are needed
    public TeacherLoginPage getTeacherLoginPage() {
        return teacherLoginPage;
    }

    public TeacherMainMenuPage getTeacherMainMenuPage() {
        return teacherMainMenuPage;
    }

    public TeacherViewCourseDetailsPage getTeacherViewCourseDetailsPage() {
        return teacherViewCourseDetailsPage;
    }

    public TeacherViewSchedulePage getTeacherViewSchedulePage() {
        return teacherViewSchedulePage;
    }
}