package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminAddCoursePage extends JPanel {
    private JTextField courseIdTextField;
    private JLabel addCourseMenuLabel;
    private JLabel courseIdLabel;
    private JLabel courseNumberLabel;
    private JLabel courseSectionLabel;
    private JLabel courseCapacityLabel;
    private JLabel courseCreditsLabel;
    private JLabel startTimeLabel;
    private JLabel endTimeLabel;
    private JLabel dayOfWeekLabel;
    private JTextField courseNumberField, courseSectionField, courseCapacityField, courseCreditsField, startTimeField, endTimeField, dayOfWeekField;
    private JButton courseAddButton;
    private JButton returnToPreviousPageButton;

    public AdminAddCoursePage(ResourceBundle resourceBundle, JPanel parentPanel) {
        setLayout(new GridLayout(9, 2, 10, 10)); // Arrange components in a grid layout

        // Initialize UI components with localized text
        JLabel addCourseMenuLabel = new JLabel(resourceBundle.getString("addCourseMenu"));
        add(addCourseMenuLabel);
        add(new JLabel()); // Empty cell for spacing

        JLabel courseIdLabel = new JLabel(resourceBundle.getString("courseIdLabel"));
        JTextField courseIdTextField = new JTextField();
        add(courseIdLabel);
        add(courseIdTextField);

        JButton returnToPreviousPageButton = new JButton(resourceBundle.getString("returnToPreviousPageButton"));
        returnToPreviousPageButton.addActionListener(e -> {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(parentPanel);
            if (topFrame != null) {
                topFrame.dispose();
            }
        });
        add(new JLabel()); // Spacer
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

    /**
     * Updates the UI text based on the provided language resource bundle.
     *
     * @param resourceBundle the ResourceBundle containing translated strings
     */
    public void changeLanguage(ResourceBundle resourceBundle) {
        addCourseMenuLabel.setText(resourceBundle.containsKey("addCourseMenu") ? resourceBundle.getString("addCourseMenu") : "Add Course");
        courseIdLabel.setText(resourceBundle.containsKey("courseIdLabel") ? resourceBundle.getString("courseIdLabel") : "Course ID");
        courseNumberLabel.setText(resourceBundle.containsKey("courseNumberLabel") ? resourceBundle.getString("courseNumberLabel") : "Course Number");
        courseSectionLabel.setText(resourceBundle.containsKey("courseSectionLabel") ? resourceBundle.getString("courseSectionLabel") : "Course Section");
        courseCapacityLabel.setText(resourceBundle.containsKey("courseCapacityLabel") ? resourceBundle.getString("courseCapacityLabel") : "Course Capacity");
        courseCreditsLabel.setText(resourceBundle.containsKey("courseCreditsLabel") ? resourceBundle.getString("courseCreditsLabel") : "Course Credits");
        startTimeLabel.setText(resourceBundle.containsKey("startTimeLabel") ? resourceBundle.getString("startTimeLabel") : "Start Time");
        endTimeLabel.setText(resourceBundle.containsKey("endTimeLabel") ? resourceBundle.getString("endTimeLabel") : "End Time");
        dayOfWeekLabel.setText(resourceBundle.containsKey("dayOfWeekLabel") ? resourceBundle.getString("dayOfWeekLabel") : "Day of Week");
        courseAddButton.setText(resourceBundle.containsKey("courseAddButton") ? resourceBundle.getString("courseAddButton") : "Add Course");
        returnToPreviousPageButton.setText(resourceBundle.containsKey("returnToPreviousPageButton") ? resourceBundle.getString("returnToPreviousPageButton") : "Back");
    }
}