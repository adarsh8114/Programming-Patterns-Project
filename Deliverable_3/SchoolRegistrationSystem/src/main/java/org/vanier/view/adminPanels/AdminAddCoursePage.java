package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;

public class AdminAddCoursePage extends JPanel {
    private JTextField courseIdTextField;
    private JLabel addCourseMenuLabel;
    private JLabel courseIdLabel;
    private JTextField courseNumberField, courseSectionField, courseCapacityField, courseCreditsField, startTimeField, endTimeField, dayOfWeekField;
    private JButton courseAddButton;
    private JButton returnToPreviousPageButton;

    public AdminAddCoursePage() {
        setLayout(new GridLayout(9, 2, 10, 10)); // Arrange components in a grid layout

        // Initialize UI components
        addCourseMenuLabel = new JLabel("Add Course");
        courseIdLabel = new JLabel("Course ID:");
        courseIdTextField = new JTextField();
        courseNumberField = new JTextField();
        courseSectionField = new JTextField();
        courseCapacityField = new JTextField();
        courseCreditsField = new JTextField();
        startTimeField = new JTextField();
        endTimeField = new JTextField();
        dayOfWeekField = new JTextField();
        courseAddButton = new JButton("Add Course");
        returnToPreviousPageButton = new JButton("Back");

        // Add components to the panel
        add(addCourseMenuLabel);
        add(new JLabel()); // Empty cell for spacing
        add(courseIdLabel);
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
        add(courseAddButton);
        add(returnToPreviousPageButton);
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
}
