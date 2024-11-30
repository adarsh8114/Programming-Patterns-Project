package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminCourseDeletePage extends JPanel {
    private JLabel deleteCourseLabel;
    private JLabel courseIdLabel;
    private JTextField courseIdTextField;
    private JButton deleteButton;
    private JButton returnButton;

    public AdminCourseDeletePage(ResourceBundle resourceBundle) {
        // Set layout
        setLayout(new GridLayout(3, 2, 10, 10));

        // Initialize components with localized text
        deleteCourseLabel = new JLabel(resourceBundle.getString("deleteCourseLabel"));
        courseIdLabel = new JLabel(resourceBundle.getString("courseIdLabel"));
        courseIdTextField = new JTextField();
        deleteButton = new JButton(resourceBundle.getString("deleteButton"));
        returnButton = new JButton(resourceBundle.getString("returnButton"));

        // Add components to the panel
        add(courseIdLabel);
        add(courseIdTextField);
        add(deleteButton);
        add(returnButton);
        add(new JLabel()); // Spacer
        add(deleteCourseLabel);
    }

    // Getters for UI elements
    public JTextField getCourseIdTextField() {
        return courseIdTextField;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    /**
     * Updates the UI text based on the provided language resource bundle.
     *
     * @param resourceBundle the ResourceBundle containing translated strings
     */
    public void changeLanguage(ResourceBundle resourceBundle) {
        deleteCourseLabel.setText(resourceBundle.getString("deleteCourseLabel"));
        courseIdLabel.setText(resourceBundle.getString("courseIdLabel"));
        deleteButton.setText(resourceBundle.getString("deleteButton"));
        returnButton.setText(resourceBundle.getString("returnButton"));
    }
}