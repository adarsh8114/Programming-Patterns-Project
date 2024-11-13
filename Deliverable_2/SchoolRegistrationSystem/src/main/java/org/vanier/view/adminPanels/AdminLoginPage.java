package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.vanier.controller.AdminManagementController;
import org.vanier.view.AdminManagementView;

public class AdminLoginPage extends JFrame {
    private JLabel adminWelcomeLabel;
    private JLabel adminIdLabel;
    private JLabel passwordLabel;
    private JButton loginButton; // Renamed for clarity
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

        // Add components to layout (assuming a simple layout for demonstration)
        JPanel panel = new JPanel();
        panel.add(adminWelcomeLabel);
        panel.add(adminIdLabel);
        panel.add(adminIdTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);

        // Set up login button action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of AdminManagementView
                AdminManagementView adminView = new AdminManagementView();

                // Create an instance of AdminManagementController, passing in the view
                AdminManagementController controller = new AdminManagementController(adminView);

                // Show the main menu view
                adminView.setVisible(true);

                // Optionally, close the login page after successful login
                dispose();
            }
        });

        // Set up the frame layout and properties
        setTitle("Admin Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}