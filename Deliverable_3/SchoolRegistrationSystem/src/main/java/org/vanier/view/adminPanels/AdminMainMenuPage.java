package org.vanier.view.adminPanels;

import org.vanier.model.RegistrationSystem;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class AdminMainMenuPage extends JPanel {
    private JLabel optionsLabel;
    private JLabel welcomeLabel;
    private JLabel adminNameLabel;
    private JLabel typeOfUserLabel;
    private JButton addCourseButton;
    private JButton updateCourseButton;
    private JButton deleteCourseButton;
    private JButton generateReportsOnCourseButton;
    private JButton addTeacherButton;
    private JButton createStudentButton;

    public AdminMainMenuPage(ResourceBundle resourceBundle) {
        // Set layout
        setLayout(new GridLayout(7, 1, 10, 10)); // Simplify layout for a clean UI

        // Initialize components with localized text
        welcomeLabel = new JLabel(resourceBundle.getString("welcomeLabel"), SwingConstants.CENTER);
        addCourseButton = new JButton(resourceBundle.getString("addCourseButton"));
        updateCourseButton = new JButton(resourceBundle.getString("updateCourseButton"));
        deleteCourseButton = new JButton(resourceBundle.getString("deleteCourseButton"));
        generateReportsOnCourseButton = new JButton(resourceBundle.getString("generateReportsOnCourseButton"));
        addTeacherButton = new JButton(resourceBundle.getString("addTeacherButton"));
        createStudentButton = new JButton(resourceBundle.getString("createStudentButton"));

        // Add components to the panel
        add(welcomeLabel);
        add(addTeacherButton);
        add(createStudentButton);
        add(addCourseButton);
        add(updateCourseButton);
        add(deleteCourseButton);
        add(generateReportsOnCourseButton);

        // Add action listeners for buttons (No localization needed for actions)
        addCourseButton.addActionListener(e -> {
            JFrame addCourseFrame = new JFrame(resourceBundle.getString("addCourseMenuTitle"));
            addCourseFrame.setContentPane(new AdminAddCoursePage(resourceBundle, this)); // Pass the current JPanel
            addCourseFrame.setSize(700, 500);
            addCourseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addCourseFrame.setVisible(true);
        });

        updateCourseButton.addActionListener(e -> {
            JFrame updateCourseFrame = new JFrame(resourceBundle.getString("updateCourseTitle"));
            updateCourseFrame.setContentPane(new AdminUpdateCoursePage(resourceBundle));
            updateCourseFrame.setSize(700, 500);
            updateCourseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            updateCourseFrame.setVisible(true);
        });

        deleteCourseButton.addActionListener(e -> {
            JFrame deleteCourseFrame = new JFrame(resourceBundle.getString("deleteCourseTitle"));
            deleteCourseFrame.setContentPane(new AdminCourseDeletePage(resourceBundle));
            deleteCourseFrame.setSize(700, 500);
            deleteCourseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            deleteCourseFrame.setVisible(true);
        });

        generateReportsOnCourseButton.addActionListener(e -> {
            JFrame generateReportsFrame = new JFrame(resourceBundle.getString("generateReportsTitle"));
            generateReportsFrame.setContentPane(new AdminManageAndGenerateReportsPage(resourceBundle));
            generateReportsFrame.setSize(700, 500);
            generateReportsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            generateReportsFrame.setVisible(true);
        });

        addTeacherButton.addActionListener(e -> {
            JFrame addTeacherFrame = new JFrame(resourceBundle.getString("addTeacherTitle"));
            addTeacherFrame.setContentPane(new AdminAddTeacherPage(resourceBundle));
            addTeacherFrame.setSize(700, 500);
            addTeacherFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addTeacherFrame.setVisible(true);
        });

        createStudentButton.addActionListener(e -> {
            JFrame createStudentFrame = new JFrame(resourceBundle.getString("createStudentTitle"));
            createStudentFrame.setContentPane(new AdminAddStudentPage(resourceBundle));
            createStudentFrame.setSize(700, 500);
            createStudentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            createStudentFrame.setVisible(true);
        });
    }

    // Getters for UI elements to be accessed in the controller
    public JButton getAddCourseButton() {
        return addCourseButton;
    }

    public JButton getUpdateCourseButton() {
        return updateCourseButton;
    }

    public JButton getDeleteCourseButton() {
        return deleteCourseButton;
    }

    public JButton getGenerateReportsOnCourseButton() {
        return generateReportsOnCourseButton;
    }

    public JButton getCreateStudentButton() {
        return createStudentButton;
    }

    public JButton getAddTeacherButton() {
        return addTeacherButton;
    }

    public void changeLanguage(ResourceBundle resourceBundle) {
        optionsLabel.setText(resourceBundle.getString("optionsLabel"));
        welcomeLabel.setText(resourceBundle.getString("welcomeLabel"));
        typeOfUserLabel.setText(resourceBundle.getString("typeOfUserLabel"));
        addCourseButton.setText(resourceBundle.getString("addCourseButton"));
        updateCourseButton.setText(resourceBundle.getString("updateCourseButton"));
        deleteCourseButton.setText(resourceBundle.getString("deleteCourseButton"));
        generateReportsOnCourseButton.setText(resourceBundle.getString("generateReportsOnCourseButton"));
    }
}