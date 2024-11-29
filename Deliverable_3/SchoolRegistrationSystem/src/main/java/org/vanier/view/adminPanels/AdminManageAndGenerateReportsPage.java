package org.vanier.view.adminPanels;

import javax.swing.*;
import java.awt.*;

public class AdminManageAndGenerateReportsPage extends JPanel {
    private JButton returnToPreviousPageButton;
    private JTextField studentIdTextField;
    private JButton manageButton;
    private JButton generateReportButton;

    public AdminManageAndGenerateReportsPage() {
        // Set layout
        setLayout(new GridLayout(3, 2, 10, 10)); // Grid layout with rows and spacing

        // Initialize components
        returnToPreviousPageButton = new JButton("Return");
        studentIdTextField = new JTextField(20);
        manageButton = new JButton("Manage");
        generateReportButton = new JButton("Generate Report");

        // Add components to the panel
        add(new JLabel("Student ID:"));
        add(studentIdTextField);
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
}
