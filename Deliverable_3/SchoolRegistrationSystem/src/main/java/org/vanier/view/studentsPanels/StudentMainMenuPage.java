package org.vanier.view.studentsPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class StudentMainMenuPage extends JFrame{
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

    public void changeLanguage(ResourceBundle resourceBundle) {
        TitleLabel.setText(resourceBundle.getString("welcome"));
        InstructionLabel.setText(resourceBundle.getString("selectFollowingOptionsLabel"));
        RegisterButton.setText(resourceBundle.getString("registerForCourseButton"));
        DropButton.setText(resourceBundle.getString("dropCourseButton"));
        CourseScheduleButton.setText(resourceBundle.getString("viewCourseScheduleButton"));
    }
}
