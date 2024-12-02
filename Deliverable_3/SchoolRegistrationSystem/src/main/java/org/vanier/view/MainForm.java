package org.vanier.view;

import org.vanier.controller.AdminManagementController;
import org.vanier.controller.StudentRegistrationController;
import org.vanier.controller.TeacherController;
import org.vanier.model.RegistrationSystem;
import org.vanier.view.adminPanels.AdminMainMenuPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainForm extends JFrame {
    private JPanel panelMain;
    private JButton teacherJButton;
    private JButton adminJButton;
    private JButton studentJButton;
    private JLabel welcomeLabel;

    private JRadioButton englishRadioButton;
    private JRadioButton frenchRadioButton;
    private ButtonGroup languageButtonGroup;

    public MainForm() {
        panelMain = new JPanel();
        welcomeLabel = new JLabel("Welcome to the School Management System. Please select an option:");
        teacherJButton = new JButton("Teacher");
        adminJButton = new JButton("Admin");
        studentJButton = new JButton("Student");

        panelMain.add(welcomeLabel);
        panelMain.add(teacherJButton);
        panelMain.add(adminJButton);
        panelMain.add(studentJButton);

        englishRadioButton = new JRadioButton("English");
        frenchRadioButton = new JRadioButton("Français");

        languageButtonGroup = new ButtonGroup();
        languageButtonGroup.add(englishRadioButton);
        languageButtonGroup.add(frenchRadioButton);

        englishRadioButton.setSelected(true);
        panelMain.add(englishRadioButton);
        panelMain.add(frenchRadioButton);

        englishRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationSystem.getInstance().setLocale(Locale.of("en","CA"));
                welcomeLabel.setText(RegistrationSystem.getInstance().getResourceBundle().getString("welcomeLabel"));
                teacherJButton.setText(RegistrationSystem.getInstance().getResourceBundle().getString("teacherButton"));
                adminJButton.setText(RegistrationSystem.getInstance().getResourceBundle().getString("adminButton"));
                studentJButton.setText(RegistrationSystem.getInstance().getResourceBundle().getString("studentButton"));
            }
        });

        frenchRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationSystem.getInstance().setLocale(Locale.of("fr","CA"));
                welcomeLabel.setText(RegistrationSystem.getInstance().getResourceBundle().getString("welcomeLabel"));
                teacherJButton.setText(RegistrationSystem.getInstance().getResourceBundle().getString("teacherButton"));
                adminJButton.setText(RegistrationSystem.getInstance().getResourceBundle().getString("adminButton"));
                studentJButton.setText(RegistrationSystem.getInstance().getResourceBundle().getString("studentButton"));
            }
        });

        this.setContentPane(panelMain);
        this.setTitle("Main Form");
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        teacherJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TeacherController();
            }
        });

        adminJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the current ResourceBundle for localization
                ResourceBundle resourceBundle = RegistrationSystem.getInstance().getResourceBundle();

                // Open the AdminMainMenuPage with the ResourceBundle
                JFrame adminFrame = new JFrame(resourceBundle.getString("adminMainMenuTitle"));
                adminFrame.setContentPane(new AdminMainMenuPage(resourceBundle));
                adminFrame.setSize(700, 500); // Adjust size as necessary
                adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                adminFrame.setVisible(true);
            }
        });

        studentJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentRegistrationController();
            }
        });
    }
}