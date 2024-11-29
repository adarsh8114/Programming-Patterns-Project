package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;

public class AdminUpdateCoursePage extends JPanel {
    private JTextField courseIdTextField;
    private JTextField courseNumberField;
    private JTextField courseSectionField;
    private JTextField courseCapacityField;
    private JTextField courseCreditsField;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextField dayOfWeekField;
    private JButton updateButton;
    private JButton returnToPreviousPageButton;

    public AdminUpdateCoursePage() {
        // Set layout
        setLayout(new GridLayout(10, 2, 10, 10)); // Grid layout with spacing

        // Initialize components
        courseIdTextField = new JTextField(20);
        courseNumberField = new JTextField(20);
        courseSectionField = new JTextField(20);
        courseCapacityField = new JTextField(20);
        courseCreditsField = new JTextField(20);
        startTimeField = new JTextField(20);
        endTimeField = new JTextField(20);
        dayOfWeekField = new JTextField(20);
        updateButton = new JButton("Update Course");
        returnToPreviousPageButton = new JButton("Return");

        // Add components to the panel
        add(new JLabel("Course ID:"));
        add(courseIdTextField);
        add(new JLabel("Course Number:"));
        add(courseNumberField);
        add(new JLabel("Course Section:"));
        add(courseSectionField);
        add(new JLabel("Course Capacity:"));
        add(courseCapacityField);
        add(new JLabel("Course Credits:"));
        add(courseCreditsField);
        add(new JLabel("Start Time:"));
        add(startTimeField);
        add(new JLabel("End Time:"));
        add(endTimeField);
        add(new JLabel("Day of Week:"));
        add(dayOfWeekField);
        add(updateButton);
        add(returnToPreviousPageButton);
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
}
