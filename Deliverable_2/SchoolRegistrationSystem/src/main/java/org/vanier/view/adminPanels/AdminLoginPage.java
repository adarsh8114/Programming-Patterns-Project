package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.vanier.controller.AdminManagementController;

public class AdminLoginPage extends JFrame {
    private JLabel adminWelcomeLabel;
    private JLabel adminIdLabel;
    private JLabel passwordLabel;
    private JButton loginLabel; // This should be renamed to "loginButton" for clarity
    private JTextField adminIdTextField;
    private JPasswordField passwordField;
    JFrame adminView = new JFrame();


    public AdminLoginPage() {
        // Initialize components (assuming these are set up correctly elsewhere in your code)
        loginLabel = new JButton("Login");

        loginLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of AdminManagementController
                AdminManagementController controller = new AdminManagementController(adminView);

                // Pass the controller to AdminMainMenuPage
                AdminMainMenuPage adminMainMenuPage = new AdminMainMenuPage(controller);
                adminMainMenuPage.setVisible(true);

                // Optionally, close the login page after successful login
                dispose();
            }
        });

        // Set up the frame layout and properties
        setTitle("Admin Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}