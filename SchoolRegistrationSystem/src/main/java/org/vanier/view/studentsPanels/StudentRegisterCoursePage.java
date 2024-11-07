package org.vanier.view.studentsPanels;

import javax.swing.*;

public class StudentRegisterCoursePage {
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
}
