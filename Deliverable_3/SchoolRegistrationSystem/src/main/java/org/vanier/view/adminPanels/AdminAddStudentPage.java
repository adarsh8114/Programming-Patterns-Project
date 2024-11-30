package org.vanier.view.adminPanels;

import org.vanier.model.RegistrationSystem;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminAddStudentPage extends JPanel{
    private JLabel addStudentMenuLabel;
    private JLabel firstNameLabel, lastNameLabel, phoneNumberLabel, emailAddressLabel, passwordLabel;
    private JTextField firstNameField, lastNameField, phoneNumberField, emailAddressField, passwordField;
    private JButton addStudentButton, returnToPreviousPageButton;

    public AdminAddStudentPage(ResourceBundle resourceBundle) {
        setLayout(new GridLayout(7, 2, 10, 10)); // Adjusted grid layout to fit all components

        // Initialize components with localized text
        addStudentMenuLabel = new JLabel(resourceBundle.getString("addStudentMenu"));
        add(addStudentMenuLabel);
        add(new JLabel());

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

        addStudentButton = new JButton(resourceBundle.getString("addStudentButton"));
        add(addStudentButton);

        returnToPreviousPageButton = new JButton(resourceBundle.getString("returnToPreviousPageButton"));
        add(returnToPreviousPageButton);
    }



    /**
     * Updates the UI text based on the provided language resource bundle.
     *
     * @param resourceBundle the ResourceBundle containing translated strings
     */
    public void changeLanguage(ResourceBundle resourceBundle) {
        addStudentMenuLabel.setText(resourceBundle.getString("addStudentMenu"));
        firstNameLabel.setText(resourceBundle.getString("firstNameLabel"));
        lastNameLabel.setText(resourceBundle.getString("lastNameLabel"));
        phoneNumberLabel.setText(resourceBundle.getString("phoneNumberLabel"));
        emailAddressLabel.setText(resourceBundle.getString("emailAddressLabel"));
        passwordLabel.setText(resourceBundle.getString("passwordLabel"));
        addStudentButton.setText(resourceBundle.getString("addStudentButton"));
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

    public JButton getAddStudentButton() {
        return addStudentButton;
    }

    public JButton getReturnToPreviousPageButton() {
        return returnToPreviousPageButton;
    }
}
