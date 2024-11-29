package org.vanier.view.adminPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class AdminLoginPage extends JFrame {
    private JLabel adminWelcomeLabel;
    private JLabel adminIdLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JTextField adminIdTextField;
    private JPasswordField passwordField;

    public AdminLoginPage() {
        // Initialize components
        adminWelcomeLabel = new JLabel("Welcome Admin");
        adminIdLabel = new JLabel("Admin ID:");
        passwordLabel = new JLabel("Password:");
        adminIdTextField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Layout setup
        JPanel panel = new JPanel();
        panel.add(adminWelcomeLabel);
        panel.add(adminIdLabel);
        panel.add(adminIdTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);

        // Frame properties
        setTitle("Admin Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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

    public void changeLanguage(ResourceBundle resourceBundle){
        adminWelcomeLabel.setText(resourceBundle.getString("adminWelcomeLabel"));
        adminIdLabel.setText(resourceBundle.getString("adminIdLabel"));
        passwordLabel.setText(resourceBundle.getString("passwordLabel"));
        loginButton.setText(resourceBundle.getString("loginButton"));
    }

}