package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminManageAndGenerateReportsPage extends JPanel {
    private JButton returnToPreviousPageButton;
    private JTextField studentIdTextField;
    private JButton manageButton;
    private JButton generateReportButton;
    private JLabel studentIdLabel;
    private JLabel courseIdLabel; // Add this if it's referenced in the .form file

    public AdminManageAndGenerateReportsPage(ResourceBundle resourceBundle) {
        // Set layout
        setLayout(new GridLayout(4, 2, 10, 10)); // Adjusted to include courseIdLabel if necessary

        // Initialize components with localized text
        returnToPreviousPageButton = new JButton(resourceBundle.getString("returnToPreviousPageButton"));
        studentIdLabel = new JLabel(resourceBundle.getString("studentIdLabel"));
        courseIdLabel = new JLabel(resourceBundle.getString("courseIdLabel")); // Initialize with localized text
        studentIdTextField = new JTextField(20);
        manageButton = new JButton(resourceBundle.getString("manageButton"));
        generateReportButton = new JButton(resourceBundle.getString("generateReportButton"));

        // Add components to the panel
        add(studentIdLabel);
        add(studentIdTextField);
        add(courseIdLabel); // Add to the layout if necessary
        add(new JLabel()); // Spacer
        add(manageButton);
        add(generateReportButton);
        add(new JLabel()); // Spacer
        add(returnToPreviousPageButton);
    }

    // Getters for the UI elements to be accessed by the controller
    public JButton getReturnToPreviousPageButton() {
        return returnToPreviousPageButton;
    }

    public JTextField getStudentIdTextField() {
        return studentIdTextField;
    }

    public JButton getManageButton() {
        return manageButton;
    }

    public JButton getGenerateReportButton() {
        return generateReportButton;
    }

    /**
     * Updates the UI text based on the provided language resource bundle.
     *
     * @param resourceBundle the ResourceBundle containing translated strings
     */
    public void changeLanguage(ResourceBundle resourceBundle) {
        returnToPreviousPageButton.setText(resourceBundle.getString("returnToPreviousPageButton"));
        studentIdLabel.setText(resourceBundle.getString("studentIdLabel"));
        courseIdLabel.setText(resourceBundle.getString("courseIdLabel")); // Update dynamically
        manageButton.setText(resourceBundle.getString("manageButton"));
        generateReportButton.setText(resourceBundle.getString("generateReportButton"));
    }
}