package org.vanier.view.studentsPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class StudentDropCoursePage extends JFrame{
    private JLabel TitleLabel;
    private JPanel StudentDropCoursePanel;
    private JLabel InstructionLabel;
    private JTextField CourseIdTextField;
    private JButton DropCourseButton;
    private JButton ReturnButton;
    private JTextArea RegisteredCourses;
    private JLabel ErrorLabel;

    public JPanel getStudentDropCoursePanel() {
        return StudentDropCoursePanel;
    }

    public JButton getReturnButton() {
        return ReturnButton;
    }

    public JTextArea getRegisteredCourses() {
        return RegisteredCourses;
    }

    public JButton getDropCourseButton() {
        return DropCourseButton;
    }

    public JTextField getCourseIdTextField() {
        return CourseIdTextField;
    }

    public JLabel getErrorLabel() {
        return ErrorLabel;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        TitleLabel.setText(resourceBundle.getString("dropCourseMenuTitle"));
        InstructionLabel.setText(resourceBundle.getString("courseIdLabel"));
        DropCourseButton.setText(resourceBundle.getString("dropCourseButton"));
        ReturnButton.setText(resourceBundle.getString("returnToPreviousPageButtonText"));
    }
}
