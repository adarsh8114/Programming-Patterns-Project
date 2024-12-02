package org.vanier.view.teachersPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class TeacherViewSchedulePage {
    private JLabel viewCourseLabel;
    private JTextArea teacherScheduleTextArea;
    private JButton returnButton;
    private JPanel teacherViewSchedulePanel;

    public JTextArea getTeacherScheduleTextArea() {
        return teacherScheduleTextArea;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public JPanel getTeacherViewSchedulePanel() {
        return teacherViewSchedulePanel;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        viewCourseLabel.setText(resourceBundle.getString("teacherViewCourseLabel"));
        returnButton.setText(resourceBundle.getString("teacherViewScheduleReturnButton"));
        teacherScheduleTextArea.setText(resourceBundle.getString("teacherScheduleErrorLabel"));
    }
}
