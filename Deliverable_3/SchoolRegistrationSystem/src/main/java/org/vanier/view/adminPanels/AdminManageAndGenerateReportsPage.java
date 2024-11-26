package org.vanier.view.adminPanels;

import javax.swing.*;
import java.util.ResourceBundle;

public class AdminManageAndGenerateReportsPage extends JFrame {
    private JButton returnToPreviousPageButton;
    private JTextField studentIdTextField;
    private JButton manageButton;
    private JButton generateReportButton;

    public AdminManageAndGenerateReportsPage() {
        setTitle("Manage and Generate Reports");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        returnToPreviousPageButton = new JButton("Return");
        studentIdTextField = new JTextField(20);
        manageButton = new JButton("Manage");
        generateReportButton = new JButton("Generate Report");

        // Layout setup
        JPanel panel = new JPanel();
        panel.add(new JLabel("Student ID:"));
        panel.add(studentIdTextField);
        panel.add(manageButton);
        panel.add(generateReportButton);
        panel.add(returnToPreviousPageButton);

        setContentPane(panel);
        setVisible(true);
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

    public void changeLanguage(ResourceBundle resourceBundle){
        returnToPreviousPageButton.setText(resourceBundle.getString("returnToPreviousPageButton"));
        manageButton.setText(resourceBundle.getString("manageButton"));
        generateReportButton.setText(resourceBundle.getString("generateReportButton"));
    }
}