package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminAddTeacherPage extends JPanel {
    private JLabel addTeacherMenuLabel;
    private JLabel firstNameLabel, lastNameLabel, phoneNumberLabel, emailAddressLabel, passwordLabel;
    private JTextField firstNameField, lastNameField, phoneNumberField, emailAddressField, passwordField;
    private JButton addTeacherButton, returnToPreviousPageButton;

    public AdminAddTeacherPage() {
        setLayout(new GridLayout(7, 2, 10, 10));

        addTeacherMenuLabel = new JLabel("Add Teacher");
        add(addTeacherMenuLabel);
        add(new JLabel());

        firstNameLabel = new JLabel("First Name:");
        add(firstNameLabel);
        firstNameField = new JTextField();
        add(firstNameField);

        lastNameLabel = new JLabel("Last Name:");
        add(lastNameLabel);
        lastNameField = new JTextField();
        add(lastNameField);

        phoneNumberLabel = new JLabel("Phone Number:");
        add(phoneNumberLabel);
        phoneNumberField = new JTextField();
        add(phoneNumberField);

        emailAddressLabel = new JLabel("Email Address:");
        add(emailAddressLabel);
        emailAddressField = new JTextField();
        add(emailAddressField);

        passwordLabel = new JLabel("Password:");
        add(passwordLabel);
        passwordField = new JTextField();
        add(passwordField);

        addTeacherButton = new JButton("Add Teacher");
        add(addTeacherButton);

        returnToPreviousPageButton = new JButton("Back");
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
