package org.vanier.controller;

import org.vanier.model.AdminModel;
import org.vanier.model.CourseModel;
import org.vanier.model.StudentModel;
import org.vanier.view.AdminManagementView;
import org.vanier.view.adminPanels.AdminViewStudentEnrollmentPage;

import javax.swing.*;
import java.util.List;

/**
 * Controls the admin management view and handles actions for managing courses and generating reports.
 */
public class AdminManagementController {
    private final AdminManagementView adminManagementView;
    private final AdminModel adminModel = new AdminModel();

    public AdminManagementController(AdminManagementView adminManagementView) {
        this.adminManagementView = adminManagementView;
        setupMainAdminViewListeners();
    }

    private void setupMainAdminViewListeners() {
        adminManagementView.getViewEnrollmentsButton().addActionListener(e -> openViewStudentEnrollmentPage());
        adminManagementView.getAddCourseButton().addActionListener(e -> addCourse());
        adminManagementView.getUpdateCourseButton().addActionListener(e -> updateCourse());
        adminManagementView.getDeleteCourseButton().addActionListener(e -> deleteCourse());
        adminManagementView.getGenerateReportButton().addActionListener(e -> generateReport());
    }

    private void openViewStudentEnrollmentPage() {
        AdminViewStudentEnrollmentPage enrollmentPage = new AdminViewStudentEnrollmentPage();
        setupViewStudentEnrollmentListeners(enrollmentPage);

        JFrame enrollmentFrame = new JFrame("Student Enrollment");
        enrollmentFrame.setSize(600, 400);
        enrollmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        enrollmentFrame.add(enrollmentPage);
        enrollmentFrame.setVisible(true);
    }

    private void setupViewStudentEnrollmentListeners(AdminViewStudentEnrollmentPage enrollmentPage) {
        enrollmentPage.getViewStudentEnrollmentButton().addActionListener(e -> viewStudentEnrollments(enrollmentPage));
        enrollmentPage.getReturnToPreviousPageButton().addActionListener(e -> {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(enrollmentPage);
            if (parentFrame != null) {
                parentFrame.dispose();
            }
        });
    }

    private void viewStudentEnrollments(AdminViewStudentEnrollmentPage enrollmentPage) {
        JTextArea enrollmentTextArea = enrollmentPage.getEnrollmentTextArea();
        try {
            int courseId = Integer.parseInt(enrollmentPage.getCourseIdTextField().getText().trim());
            List<StudentModel> enrolledStudents = adminModel.getStudentEnrollments(courseId);

            if (enrolledStudents.isEmpty()) {
                enrollmentTextArea.setText("No students enrolled for Course ID: " + courseId);
            } else {
                enrollmentTextArea.setText("Enrolled Students for Course ID: " + courseId + "\n");
                for (StudentModel student : enrolledStudents) {
                    enrollmentTextArea.append(student.getFirstName() + " " + student.getLastName() + " (ID: " + student.getId() + ")\n");
                }
            }
        } catch (NumberFormatException ex) {
            enrollmentTextArea.setText("");
            JOptionPane.showMessageDialog(enrollmentPage, "Please enter a valid numeric Course ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addCourse() {
        try {
            String courseNumber = JOptionPane.showInputDialog("Enter Course Number:");
            int courseSection = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Section:"));
            int courseCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Capacity:"));
            int courseCredits = Integer.parseInt(JOptionPane.showInputDialog("Enter Course Credits:"));
            int startTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Start Time (e.g., 900 for 9:00 AM):"));
            int endTime = Integer.parseInt(JOptionPane.showInputDialog("Enter End Time (e.g., 1700 for 5:00 PM):"));
            String dayOfWeek = JOptionPane.showInputDialog("Enter Day of the Week:");

            CourseModel course = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
            adminModel.addCourse(course);
            JOptionPane.showMessageDialog(adminManagementView, "Course added: " + course.getCourseId(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(adminManagementView, "Invalid input. Please enter numeric values where required.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCourse() {
        try {
            int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to update:"));
            CourseModel existingCourse = adminModel.getCourseById(courseId);

            if (existingCourse == null) {
                JOptionPane.showMessageDialog(adminManagementView, "Course with ID " + courseId + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String courseNumber = JOptionPane.showInputDialog("Enter Updated Course Number:", existingCourse.getCourseNumber());
            int courseSection = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Section:", existingCourse.getCourseSection()));
            int courseCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Capacity:", existingCourse.getCourseCapacity()));
            int courseCredits = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Course Credits:", existingCourse.getCourseCredits()));
            int startTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated Start Time (e.g., 900 for 9:00 AM):", existingCourse.getStartTime()));
            int endTime = Integer.parseInt(JOptionPane.showInputDialog("Enter Updated End Time (e.g., 1700 for 5:00 PM):", existingCourse.getEndTime()));
            String dayOfWeek = JOptionPane.showInputDialog("Enter Updated Day of the Week:", existingCourse.getDayOfWeek());

            CourseModel updatedCourse = new CourseModel(courseNumber, courseSection, courseCapacity, courseCredits, startTime, endTime, dayOfWeek);
            boolean success = adminModel.updateCourse(courseId, updatedCourse);

            JOptionPane.showMessageDialog(adminManagementView, success ? "Course updated: " + updatedCourse.getCourseId() : "Course not found.",
                    success ? "Success" : "Error", success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(adminManagementView, "Invalid input. Please enter numeric values where required.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteCourse() {
        try {
            int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to delete:"));
            boolean success = adminModel.deleteCourse(courseId);

            JOptionPane.showMessageDialog(adminManagementView, success ? "Course deleted: " + courseId : "Course not found.",
                    success ? "Success" : "Error", success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(adminManagementView, "Invalid input. Please enter a numeric Course ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateReport() {
        StringBuilder report = new StringBuilder("Enrollment Report:\n");

        List<CourseModel> courses = adminModel.getAllCourses();
        for (CourseModel course : courses) {
            report.append("Course ID: ").append(course.getCourseId()).append(" - ").append(course.getCourseNumber()).append("\n");

            List<StudentModel> enrolledStudents = adminModel.getStudentEnrollments(course.getCourseId());
            if (enrolledStudents.isEmpty()) {
                report.append("   No students enrolled.\n");
            } else {
                report.append("   Enrolled Students:\n");
                for (StudentModel student : enrolledStudents) {
                    report.append("      - ").append(student.getFirstName()).append(" ").append(student.getLastName())
                            .append(" (ID: ").append(student.getId()).append(")\n");
                }
            }
            report.append("\n");
        }

        JOptionPane.showMessageDialog(adminManagementView, report.toString(), "Enrollment Report", JOptionPane.INFORMATION_MESSAGE);
    }
}