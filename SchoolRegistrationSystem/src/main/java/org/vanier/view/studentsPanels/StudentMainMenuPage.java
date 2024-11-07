package org.vanier.view.studentsPanels;

import javax.swing.*;

public class StudentMainMenuPage {
    private JPanel StudentMainMenuPanel;
    private JLabel TitleLabel;
    private JLabel StudentNameLabel;
    private JLabel InstructionLabel;
    private JButton RegisterButton;
    private JButton DropButton;
    private JButton CourseScheduleButton;
    private JLabel StudentStatusLabe;

    public JPanel getStudentMainMenuPanel() {
        return StudentMainMenuPanel;
    }


    public JButton getRegisterButton() {
        return RegisterButton;
    }

    public JButton getDropButton() {
        return DropButton;
    }

    public JButton getCourseScheduleButton() {
        return CourseScheduleButton;
    }

    public JLabel getStudentStatusLabe() {
        return StudentStatusLabe;
    }

    public JLabel getStudentNameLabel() {
        return StudentNameLabel;
    }
}
