package org.vanier.view;

import org.vanier.view.adminPanels.AddCoursePanel;
import org.vanier.view.adminPanels.UpdateCoursePanel;
import org.vanier.view.adminPanels.DeleteCoursePanel;
import org.vanier.view.adminPanels.ViewEnrollmentsPanel;
import org.vanier.view.adminPanels.GenerateReportPanel;

import javax.swing.*;
import java.awt.*;

public class AdminManagementView extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JPanel adminMainMenuPanel;
    private AddCoursePanel addCoursePanel;
    private UpdateCoursePanel updateCoursePanel;
    private DeleteCoursePanel deleteCoursePanel;
    private ViewEnrollmentsPanel viewEnrollmentsPanel;
    private GenerateReportPanel generateReportPanel;

    public AdminManagementView() throws HeadlessException {
        setTitle("Admin Portal");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize the main menu panel for admin
        adminMainMenuPanel = new JPanel();
        JButton addCourseButton = new JButton("Add Course");
        JButton updateCourseButton = new JButton("Update Course");
        JButton deleteCourseButton = new JButton("Delete Course");
        JButton viewEnrollmentsButton = new JButton("View Enrollments");
        JButton generateReportButton = new JButton("Generate Report");

        // Add buttons to the main menu panel
        adminMainMenuPanel.add(addCourseButton);
        adminMainMenuPanel.add(updateCourseButton);
        adminMainMenuPanel.add(deleteCourseButton);
        adminMainMenuPanel.add(viewEnrollmentsButton);
        adminMainMenuPanel.add(generateReportButton);

        // Initialize task-specific panels
        addCoursePanel = new AddCoursePanel();
        updateCoursePanel = new UpdateCoursePanel();
        deleteCoursePanel = new DeleteCoursePanel();
        viewEnrollmentsPanel = new ViewEnrollmentsPanel();
        generateReportPanel = new GenerateReportPanel();

        // Add panels to the CardLayout with unique names
        mainPanel.add(adminMainMenuPanel, "adminMainMenu");
        mainPanel.add(addCoursePanel, "addCourse");
        mainPanel.add(updateCoursePanel, "updateCourse");
        mainPanel.add(deleteCoursePanel, "deleteCourse");
        mainPanel.add(viewEnrollmentsPanel, "viewEnrollments");
        mainPanel.add(generateReportPanel, "generateReport");

        // Add the main panel to the frame
        add(mainPanel);

        // Add action listeners to buttons for panel navigation
        addCourseButton.addActionListener(e -> showPanel("addCourse"));
        updateCourseButton.addActionListener(e -> showPanel("updateCourse"));
        deleteCourseButton.addActionListener(e -> showPanel("deleteCourse"));
        viewEnrollmentsButton.addActionListener(e -> showPanel("viewEnrollments"));
        generateReportButton.addActionListener(e -> showPanel("generateReport"));
    }

    // Method to show a specific panel by name
    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    // Method to return to the main menu
    public void showAdminMainMenuPanel() {
        cardLayout.show(mainPanel, "adminMainMenu");
    }

    // Getters for the individual panels
    public AddCoursePanel getAddCoursePanel() {
        return addCoursePanel;
    }

    public UpdateCoursePanel getUpdateCoursePanel() {
        return updateCoursePanel;
    }

    public DeleteCoursePanel getDeleteCoursePanel() {
        return deleteCoursePanel;
    }

    public ViewEnrollmentsPanel getViewEnrollmentsPanel() {
        return viewEnrollmentsPanel;
    }

    public GenerateReportPanel getGenerateReportPanel() {
        return generateReportPanel;
    }
}