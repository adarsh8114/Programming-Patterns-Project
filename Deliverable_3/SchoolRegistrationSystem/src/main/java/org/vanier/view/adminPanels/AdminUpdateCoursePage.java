package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminUpdateCoursePage extends JPanel {
    private JTextField courseIdTextField;
    private JTextField courseNumberField;
    private JTextField courseSectionField;
    private JTextField courseCapacityField;
    private JTextField courseCreditsField;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextField dayOfWeekField;
    private JButton updateCoursePage;
    private JButton returnToPreviousPageButton;

    private JLabel courseIdLabel;
    private JLabel courseNumberLabel;
    private JLabel courseSectionLabel;
    private JLabel courseCapacityLabel;
    private JLabel courseCreditsLabel;
    private JLabel startTimeLabel;
    private JLabel endTimeLabel;
    private JLabel dayOfWeekLabel;

    public AdminUpdateCoursePage(ResourceBundle resourceBundle) {
        // Set layout
        setLayout(new GridLayout(10, 2, 10, 10));

        // Initialize components with localized text
        courseIdLabel = new JLabel(resourceBundle.getString("courseIdLabel"));
        courseNumberLabel = new JLabel(resourceBundle.getString("courseNumberLabel"));
        courseSectionLabel = new JLabel(resourceBundle.getString("courseSectionLabel"));
        courseCapacityLabel = new JLabel(resourceBundle.getString("courseCapacityLabel"));
        courseCreditsLabel = new JLabel(resourceBundle.getString("courseCreditsLabel"));
        startTimeLabel = new JLabel(resourceBundle.getString("startTimeLabel"));
        endTimeLabel = new JLabel(resourceBundle.getString("endTimeLabel"));
        dayOfWeekLabel = new JLabel(resourceBundle.getString("dayOfWeekLabel"));

        courseIdTextField = new JTextField(20);
        courseNumberField = new JTextField(20);
        courseSectionField = new JTextField(20);
        courseCapacityField = new JTextField(20);
        courseCreditsField = new JTextField(20);
        startTimeField = new JTextField(20);
        endTimeField = new JTextField(20);
        dayOfWeekField = new JTextField(20);
        updateCoursePage = new JButton(resourceBundle.getString("updateCoursePage"));
        returnToPreviousPageButton = new JButton(resourceBundle.getString("returnToPreviousPageButton"));

        // Add components to the panel
        add(courseIdLabel);
        add(courseIdTextField);
        add(courseNumberLabel);
        add(courseNumberField);
        add(courseSectionLabel);
        add(courseSectionField);
        add(courseCapacityLabel);
        add(courseCapacityField);
        add(courseCreditsLabel);
        add(courseCreditsField);
        add(startTimeLabel);
        add(startTimeField);
        add(endTimeLabel);
        add(endTimeField);
        add(dayOfWeekLabel);
        add(dayOfWeekField);
        add(updateCoursePage);
        add(returnToPreviousPageButton);
    }

    // Getters for UI elements
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

    public JButton getUpdateCoursePage() {
        return updateCoursePage;
    }

    public JButton getReturnToPreviousPageButton() {
        return returnToPreviousPageButton;
    }

    /**
     * Updates the UI text based on the provided language resource bundle.
     *
     * @param resourceBundle the ResourceBundle containing translated strings
     */
    public void changeLanguage(ResourceBundle resourceBundle) {
        courseIdLabel.setText(resourceBundle.getString("courseIdLabel"));
        courseNumberLabel.setText(resourceBundle.getString("courseNumberLabel"));
        courseSectionLabel.setText(resourceBundle.getString("courseSectionLabel"));
        courseCapacityLabel.setText(resourceBundle.getString("courseCapacityLabel"));
        courseCreditsLabel.setText(resourceBundle.getString("courseCreditsLabel"));
        startTimeLabel.setText(resourceBundle.getString("startTimeLabel"));
        endTimeLabel.setText(resourceBundle.getString("endTimeLabel"));
        dayOfWeekLabel.setText(resourceBundle.getString("dayOfWeekLabel"));
        updateCoursePage.setText(resourceBundle.getString("updateCoursePage"));
        returnToPreviousPageButton.setText(resourceBundle.getString("returnToPreviousPageButton"));
    }
}