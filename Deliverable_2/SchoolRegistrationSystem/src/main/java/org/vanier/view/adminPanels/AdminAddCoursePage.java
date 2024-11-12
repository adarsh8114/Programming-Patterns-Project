package org.vanier.view.adminPanels;

import org.vanier.controller.AdminManagementController;
import org.vanier.model.CourseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddCoursePage extends JFrame {
    private JTextField courseIdTextField;
    private JLabel addCourseMenuLabel;
    private JPanel addCourseMenu;
    private JLabel courseIdLabel;
    private JTextField courseNumberField, courseSectionField, courseCapacityField, courseCreditsField, startTimeField, endTimeField, dayOfWeekField;
    private JButton courseAddButton;
    private JButton returnToPreviousPageButton;
    private AdminManagementController controller;

    public AdminAddCoursePage(AdminManagementController controller) {
        this.controller = controller;

        courseAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                courseIdTextField = new JTextField(10);
                addCourseMenu.add(courseIdTextField); // Assuming addCourseMenu is the panel where it should be added
                String courseNumber = courseNumberField.getText();
                int courseSection = Integer.parseInt(courseSectionField.getText());
                int courseCapacity = Integer.parseInt(courseCapacityField.getText());
                int courseCredits = Integer.parseInt(courseCreditsField.getText());
                int startTime = Integer.parseInt(startTimeField.getText());
                int endTime = Integer.parseInt(endTimeField.getText());
                String dayOfWeek = dayOfWeekField.getText();

                CourseModel newCourse = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
                controller.handleAddCourse(newCourse);
            }
        });

        returnToPreviousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setTitle("Add Course");
        setContentPane(addCourseMenu);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}