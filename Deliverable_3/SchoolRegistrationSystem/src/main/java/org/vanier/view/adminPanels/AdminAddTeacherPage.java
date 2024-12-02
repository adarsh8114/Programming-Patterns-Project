package org.vanier.view.adminPanels;

import org.vanier.controller.DatabaseController;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminAddTeacherPage extends JPanel {
    private JLabel addTeacherMenuLabel;
    private JLabel firstNameLabel, lastNameLabel, phoneNumberLabel, emailAddressLabel, passwordLabel;
    private JTextField firstNameField, lastNameField, phoneNumberField, emailAddressField, passwordField;
    private JButton addTeacherButton, returnToPreviousPageButton;

    public AdminAddTeacherPage(ResourceBundle resourceBundle) {
        setLayout(new GridLayout(7, 2, 10, 10));

        // Initialize components with localized text
        addTeacherMenuLabel = new JLabel(resourceBundle.getString("addTeacherMenu"));
        add(addTeacherMenuLabel);
        add(new JLabel()); // Empty cell for spacing

        firstNameLabel = new JLabel(resourceBundle.getString("firstNameLabel"));
        add(firstNameLabel);
        firstNameField = new JTextField();
        add(firstNameField);

        lastNameLabel = new JLabel(resourceBundle.getString("lastNameLabel"));
        add(lastNameLabel);
        lastNameField = new JTextField();
        add(lastNameField);

        phoneNumberLabel = new JLabel(resourceBundle.getString("phoneNumberLabel"));
        add(phoneNumberLabel);
        phoneNumberField = new JTextField();
        add(phoneNumberField);

        emailAddressLabel = new JLabel(resourceBundle.getString("emailAddressLabel"));
        add(emailAddressLabel);
        emailAddressField = new JTextField();
        add(emailAddressField);

        passwordLabel = new JLabel(resourceBundle.getString("passwordLabel"));
        add(passwordLabel);
        passwordField = new JTextField();
        add(passwordField);

        addTeacherButton = new JButton(resourceBundle.getString("addTeacherButton"));
        addTeacherButton.addActionListener(e -> {
            try {
                // Fetch user input
                int teacherId = 0; // Set default or generate if required
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phoneNumber = phoneNumberField.getText();
                String email = emailAddressField.getText();
                String password = passwordField.getText();

                // Validate inputs (simple example)
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Call DatabaseController to add the teacher
                DatabaseController.addTeacher(teacherId, firstName, lastName, phoneNumber, email, password);

                // Show success message
                JOptionPane.showMessageDialog(this, "Teacher added successfully!");
            } catch (Exception ex) {
                // Show error message
                JOptionPane.showMessageDialog(this, "Error adding teacher: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(addTeacherButton);

        returnToPreviousPageButton = new JButton(resourceBundle.getString("returnToPreviousPageButton"));
        returnToPreviousPageButton.addActionListener(e -> {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (topFrame != null) {
                topFrame.dispose();
            }
        });
        add(returnToPreviousPageButton);
    }

    /**
     * Updates the UI text based on the provided language resource bundle.
     *
     * @param resourceBundle the ResourceBundle containing translated strings
     */
    public void changeLanguage(ResourceBundle resourceBundle) {
        addTeacherMenuLabel.setText(resourceBundle.getString("addTeacherMenu"));
        firstNameLabel.setText(resourceBundle.getString("firstNameLabel"));
        lastNameLabel.setText(resourceBundle.getString("lastNameLabel"));
        phoneNumberLabel.setText(resourceBundle.getString("phoneNumberLabel"));
        emailAddressLabel.setText(resourceBundle.getString("emailAddressLabel"));
        passwordLabel.setText(resourceBundle.getString("passwordLabel"));
        addTeacherButton.setText(resourceBundle.getString("addTeacherButton"));
        returnToPreviousPageButton.setText(resourceBundle.getString("returnToPreviousPageButton"));
    }

    // Getters for UI elements
    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JTextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public JTextField getEmailAddressField() {
        return emailAddressField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JButton getAddTeacherButton() {
        return addTeacherButton;
    }

    public JButton getReturnToPreviousPageButton() {
        return returnToPreviousPageButton;
    }
}