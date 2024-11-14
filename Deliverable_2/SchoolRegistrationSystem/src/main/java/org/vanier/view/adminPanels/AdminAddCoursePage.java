package org.vanier.view.adminPanels;

import javax.swing.*;

public class AdminAddCoursePage extends JFrame {
    private JTextField courseIdTextField;
    private JLabel addCourseMenuLabel;
    private JPanel addCourseMenu;
    private JLabel courseIdLabel;
    private JTextField courseNumberField, courseSectionField, courseCapacityField, courseCreditsField, startTimeField, endTimeField, dayOfWeekField;
    private JButton courseAddButton;
    private JButton returnToPreviousPageButton;

    public AdminAddCoursePage() {
        setTitle("Add Course");
        setContentPane(addCourseMenu);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Getters for UI elements that the controller will interact with
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

    public JButton getCourseAddButton() {
        return courseAddButton;
    }

    public JButton getReturnToPreviousPageButton() {
        return returnToPreviousPageButton;
    }

    public JPanel getAddCourseMenu() {
        return addCourseMenu;
    }
}