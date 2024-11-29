package org.vanier.view.teachersPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class TeacherMainMenuPage {
    private JLabel welcomeLabel;
    private JLabel nameLabel;
    private JLabel teacherLabel;
    private JLabel selectionLabel;
    private JButton courseDetailsButton;
    private JButton viewScheduleButton;
    private JButton logOutButton;
    private JPanel teacherMainMenuPanel;


    public JButton getCourseDetailsButton() {
        return courseDetailsButton;
    }

    public JButton getViewScheduleButton() {
        return viewScheduleButton;
    }

    public JButton getLogOutButton() {
        return logOutButton;
    }

    public JPanel getTeacherMainMenuPanel() {
        return teacherMainMenuPanel;
    }

    public JLabel getWelcomeLabel() {
        return welcomeLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getTeacherLabel() {
        return teacherLabel;
    }

    public JLabel getSelectionLabel() {
        return selectionLabel;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        welcomeLabel.setText(resourceBundle.getString("teacherWelcomeLabel"));
        teacherLabel.setText(resourceBundle.getString("teacherTeacherLabel"));
        courseDetailsButton.setText(resourceBundle.getString("teacherCourseDetailsButton"));
        viewScheduleButton.setText(resourceBundle.getString("teacherViewScheduleButton"));
        logOutButton.setText(resourceBundle.getString("teacherLogOutButton"));
        selectionLabel.setText(resourceBundle.getString("teacherSelectionLabel"));
    }
}
