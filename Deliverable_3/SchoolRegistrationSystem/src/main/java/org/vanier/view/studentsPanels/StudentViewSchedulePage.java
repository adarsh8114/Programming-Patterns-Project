package org.vanier.view.studentsPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class StudentViewSchedulePage extends JFrame{
    private JPanel StudentViewSchedulePanel;
    private JLabel TitleLabel;
    private JButton ReturnButton;
    private JTextArea RegisteredCoursesTextArea;

    public JPanel getStudentViewSchedulePanel() {
        return StudentViewSchedulePanel;
    }

    public JButton getReturnButton() {
        return ReturnButton;
    }

    public JTextArea getRegisteredCoursesTextArea() {
        return RegisteredCoursesTextArea;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        TitleLabel.setText(resourceBundle.getString("viewCourseScheduleMenuTitle"));
        ReturnButton.setText(resourceBundle.getString("returnToPreviousPageButtonText"));
    }
}
