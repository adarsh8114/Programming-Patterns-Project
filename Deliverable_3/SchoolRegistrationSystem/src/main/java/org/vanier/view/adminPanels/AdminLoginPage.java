package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminLoginPage extends JPanel {
    private JLabel adminWelcomeLabel;
    private JLabel adminIdLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JTextField adminIdTextField;
    private JPasswordField passwordField;

    public AdminLoginPage() {
        // Set layout
        setLayout(new GridLayout(4, 2, 10, 10)); // Grid layout with gaps

        // Initialize components
        adminWelcomeLabel = new JLabel("Welcome Admin", SwingConstants.CENTER);
        adminIdLabel = new JLabel("Admin ID:");
        passwordLabel = new JLabel("Password:");
        adminIdTextField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Add components to the panel
        add(adminWelcomeLabel);
        add(new JLabel()); // Empty label for spacing
        add(adminIdLabel);
        add(adminIdTextField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Empty label for spacing
        add(loginButton);
    }

    // Getters for the UI elements
    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getAdminIdTextField() {
        return adminIdTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        adminWelcomeLabel.setText(resourceBundle.getString("adminWelcomeLabel"));
        adminIdLabel.setText(resourceBundle.getString("adminIdLabel"));
        passwordLabel.setText(resourceBundle.getString("passwordLabel"));
        loginButton.setText(resourceBundle.getString("loginButton"));
    }
}
