package org.vanier.view;

import javax.swing.*;
import java.awt.*;

public class AdminManagementView extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JPanel adminMainMenuPanel;

    public AdminManagementView() throws HeadlessException {
        setTitle("Admin Portal");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize the main menu panel for admin with buttons
        adminMainMenuPanel = new JPanel();
        JButton addCourseButton = new JButton("Add Course");
        JButton updateCourseButton = new JButton("Update Course");
        JButton deleteCourseButton = new JButton("Delete Course");
        JButton viewEnrollmentsButton = new JButton("View Enrollments");
        JButton generateReportButton = new JButton("Generate Report");

        // Add buttons to the panel
        adminMainMenuPanel.add(addCourseButton);
        adminMainMenuPanel.add(updateCourseButton);
        adminMainMenuPanel.add(deleteCourseButton);
        adminMainMenuPanel.add(viewEnrollmentsButton);
        adminMainMenuPanel.add(generateReportButton);

        // Add main menu panel to card layout
        mainPanel.add(adminMainMenuPanel, "adminMainMenu");

        // Add the main panel to the frame
        add(mainPanel);
    }

    public JPanel getAdminMainMenuPanel() {
        return adminMainMenuPanel;
    }

    public JButton getAddCourseButton() {
        return (JButton) adminMainMenuPanel.getComponent(0);
    }

    public JButton getUpdateCourseButton() {
        return (JButton) adminMainMenuPanel.getComponent(1);
    }

    public JButton getDeleteCourseButton() {
        return (JButton) adminMainMenuPanel.getComponent(2);
    }

    public JButton getViewEnrollmentsButton() {
        return (JButton) adminMainMenuPanel.getComponent(3);
    }

    public JButton getGenerateReportButton() {
        return (JButton) adminMainMenuPanel.getComponent(4);
    }

    public void showAdminMainMenuPanel() {
        cardLayout.show(mainPanel, "adminMainMenu");
    }
}