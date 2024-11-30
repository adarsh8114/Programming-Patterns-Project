package org.vanier.view.studentsPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class StudentRegisterCoursePage extends JFrame{
    private JPanel StudentRegisterCoursePanel;
    private JLabel TitleLabel;
    private JButton ReturnButton;
    private JTextArea AvailibleCoursesTextArea;
    private JLabel CourseIdLabel;
    private JTextField CourseIdTextField;
    private JButton RegisterForCourseButton;
    private JLabel ErrorLabel;

    public JPanel getStudentRegisterCoursePanel() {
        return StudentRegisterCoursePanel;
    }

    public JButton getReturnButton() {
        return ReturnButton;
    }

    public JTextArea getAvailibleCoursesTextArea() {
        return AvailibleCoursesTextArea;
    }

    public JButton getRegisterForCourseButton() {
        return RegisterForCourseButton;
    }

    public JTextField getCourseIdTextField() {
        return CourseIdTextField;
    }

    public JLabel getErrorLabel() {
        return ErrorLabel;
    }

    /**
     * Updates the UI text based on the provided language resource bundle.
     *
     * @param resourceBundle the ResourceBundle containing translated strings
     */
    public void changeLanguage(ResourceBundle resourceBundle) {
        TitleLabel.setText(resourceBundle.getString("registerForCourseMenuTitle"));
        CourseIdLabel.setText(resourceBundle.getString("courseIdLabel"));
        RegisterForCourseButton.setText(resourceBundle.getString("registerButton"));
        ReturnButton.setText(resourceBundle.getString("returnToPreviousPageButtonText"));
    }
}
