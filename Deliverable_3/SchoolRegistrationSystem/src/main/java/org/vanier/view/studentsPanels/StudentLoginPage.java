package org.vanier.view.studentsPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class StudentLoginPage extends JFrame{
    private JPanel StudentLoginPanel;
    private JLabel WelcomeLabel;
    private JLabel StudentId;
    private JLabel PasswordLabel;
    private JTextField StudentIdTextField;
    private JTextField PasswordTextField;
    private JButton loginButton;
    private JLabel ErrorLabel;

    public JPanel getStudentLoginPanel() {
        return StudentLoginPanel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getStudentIdTextField() {
        return StudentIdTextField;
    }

    public JTextField getPasswordTextField() {
        return PasswordTextField;
    }

    public JLabel getErrorLabel() {
        return ErrorLabel;
    }

    /**
     * Updates the UI text based on the provided language resource bundle.
     *
     * @param resourceBundle the ResourceBundle containing translated strings
     */
    public void changeLanguage(ResourceBundle resourceBundle) {
        WelcomeLabel.setText(resourceBundle.getString("welcomeStudentLoginPage"));
        StudentId.setText(resourceBundle.getString("studentIdLabel"));
        PasswordLabel.setText(resourceBundle.getString("passwordLabel"));
        loginButton.setText(resourceBundle.getString("loginButton"));
    }
}
