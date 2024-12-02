package org.vanier.view.teachersPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class TeacherViewCourseTeachingPage {
    private JLabel courseNumberLabel;
    private JButton returnButton;
    private JPanel teacherViewCoursePanel;
    private JList coursesList;
    private JButton viewDetailsButton;
    private JLabel errorLabel;

    public JButton getReturnButton() {
        return returnButton;
    }

    public JPanel getTeacherViewCoursePanel() {
        return teacherViewCoursePanel;
    }

    public JList getCoursesList() {
        return coursesList;
    }

    public JButton getViewDetailsButton() {
        return viewDetailsButton;
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        courseNumberLabel.setText(resourceBundle.getString("teacherCourseNumberLabel"));
        returnButton.setText(resourceBundle.getString("teacherViewCoursePageReturnButton"));
        viewDetailsButton.setText(resourceBundle.getString("teacherViewDetailsButton"));
    }
}
