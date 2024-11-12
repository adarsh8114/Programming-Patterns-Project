package org.vanier.view;

import org.vanier.controller.AdminManagementController;
import org.vanier.factory.CourseFactory;
import org.vanier.model.CourseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminManagementView extends JFrame {
    private JButton addCourseButton;
    private JButton updateCourseButton;
    private JButton deleteCourseButton;
    private AdminManagementController controller;

    public AdminManagementView(AdminManagementController controller) {
        this.controller = controller;

        // Initialize buttons
        addCourseButton = new JButton("Add Course");
        updateCourseButton = new JButton("Update Course");
        deleteCourseButton = new JButton("Delete Course");

        // Set up button listeners
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Collect course details from input fields for adding a course
                String courseType = JOptionPane.showInputDialog("Enter Course Type (inPersonCourse/onlineCourse):").trim().toLowerCase();

                // Validate the course type input
                while (!courseType.equalsIgnoreCase("inPersonCourse") && !courseType.equalsIgnoreCase("onlineCourse")) {
                    courseType = JOptionPane.showInputDialog("Invalid input. Please enter either 'inPersonCourse' or 'onlineCourse':").trim().toLowerCase();
                }

                String courseNumber = JOptionPane.showInputDialog("Enter Course Number:");
                int courseSection = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Section:"));
                int courseCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Capacity:"));
                int courseCredits = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Credits:"));
                int startTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Start Time (e.g., 900 for 9:00 AM):"));
                int endTime = Integer.parseInt(JOptionPane.showInputDialog("Enter End Time (e.g., 1700 for 5:00 PM):"));
                String dayOfWeek = JOptionPane.showInputDialog("Enter Day of the Week:");
                String location = JOptionPane.showInputDialog("Enter Location:");

                // Use the CourseFactory to create the course
                CourseModel newCourse = CourseFactory.createCourse(courseType, courseNumber, courseSection, courseCapacity,
                        courseCredits, startTime, endTime, dayOfWeek, location);

                // Handle adding the course using the controller
                controller.handleAddCourse(newCourse);
            }
        });


        updateCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the course ID to update
                int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to update:"));

                // Collect course details from input fields for updating a course
                String courseNumber = JOptionPane.showInputDialog("Enter Updated Course Number:");
                int courseSection = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Section:"));
                int courseCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Capacity:"));
                int courseCredits = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Credits:"));
                int startTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Start Time (e.g., 900 for 9:00 AM):"));
                int endTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated End Time (e.g., 1700 for 5:00 PM):"));
                String dayOfWeek = JOptionPane.showInputDialog("Enter Updated Day of the Week:");

                CourseModel updatedCourse = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits,
                        startTime, endTime, dayOfWeek);
                controller.handleUpdateCourse(courseId, updatedCourse);
            }
        });

        deleteCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the course ID to delete
                int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to delete:"));
                controller.handleDeleteCourse(courseId);
            }
        });

        // Layout setup
        JPanel panel = new JPanel();
        panel.add(addCourseButton);
        panel.add(updateCourseButton);
        panel.add(deleteCourseButton);
        add(panel);

        setTitle("Admin Management");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}