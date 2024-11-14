package org.vanier.view;

import org.vanier.controller.AdminManagementController;
import org.vanier.controller.StudentRegistrationController;
import org.vanier.controller.TeacherController;
import org.vanier.view.AdminManagementView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JPanel panelMain;
    private JButton teacherJButton;
    private JButton adminJButton;
    private JButton studentJButton;
    private JLabel welcomeLabel;

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

        this.setContentPane(panelMain);
        this.setTitle("Main Form");
        this.setSize(400, 200);
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
                // Create the main admin view
                AdminManagementView adminView = new AdminManagementView();

                // Initialize the admin controller with the view
                AdminManagementController controller = new AdminManagementController(adminView);

                // Display the admin view
                adminView.setVisible(true);
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