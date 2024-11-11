package org.vanier.view.studentsPanels;

import javax.swing.*;

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
}
