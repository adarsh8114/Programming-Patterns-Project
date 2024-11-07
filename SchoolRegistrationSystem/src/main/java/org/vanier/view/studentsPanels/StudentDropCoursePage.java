package org.vanier.view.studentsPanels;

import javax.swing.*;

public class StudentDropCoursePage {
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
}
