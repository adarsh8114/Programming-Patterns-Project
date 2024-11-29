package org.vanier.view.adminPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class AdminUpdateCoursePage extends JFrame {
    private JPanel updateCoursePage;
    private JButton returnToPreviousPageButton;
    private JTextField courseIdTextField, courseNumberField, courseSectionField, courseCapacityField, courseCreditsField, startTimeField, endTimeField, dayOfWeekField;
    private JButton updateButton;
    private JLabel courseIdLabel;

    public AdminUpdateCoursePage() {
        setTitle("Update Course");
        setContentPane(updateCoursePage);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // Getters for UI components that the controller needs to access
    public JTextField getCourseIdTextField() {
        return courseIdTextField;
    }

    public JTextField getCourseNumberField() {
        return courseNumberField;
    }

    public JTextField getCourseSectionField() {
        return courseSectionField;
    }

    public JTextField getCourseCapacityField() {
        return courseCapacityField;
    }

    public JTextField getCourseCreditsField() {
        return courseCreditsField;
    }

    public JTextField getStartTimeField() {
        return startTimeField;
    }

    public JTextField getEndTimeField() {
        return endTimeField;
    }

    public JTextField getDayOfWeekField() {
        return dayOfWeekField;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getReturnToPreviousPageButton() {
        return returnToPreviousPageButton;
    }

    public void changeLanguage(ResourceBundle resourceBundle){
        returnToPreviousPageButton.setText(resourceBundle.getString("returnToPreviousPageButton"));
        updateButton.setText(resourceBundle.getString("updateButton"));
        courseIdLabel.setText(resourceBundle.getString("courseIdLabel"));
    }
}