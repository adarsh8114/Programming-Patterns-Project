package org.vanier.view.teachersPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class TeacherViewCourseDetailsPage {
    private JLabel courseSelectedLabel;
    private JTable courseDetailTable;
    private JButton returnButton;
    private JPanel teacherCourseDetailsPanel;

    public JPanel getTeacherCourseDetailsPanel() {
        return teacherCourseDetailsPanel;
    }

    public JLabel getCourseSelectedLabel() {
        return courseSelectedLabel;
    }

    public JTable getCourseDetailTable() {
        return courseDetailTable;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        returnButton.setText(resourceBundle.getString("teacherViewDetailsReturnButton"));
        courseSelectedLabel.setText(resourceBundle.getString("teacherCourseDetailsErrorLabel"));

    }
}
