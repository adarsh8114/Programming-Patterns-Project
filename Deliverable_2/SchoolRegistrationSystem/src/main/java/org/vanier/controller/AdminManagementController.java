package org.vanier.controller;

import org.vanier.model.AdminModel;
import org.vanier.model.CourseModel;
import org.vanier.model.StudentModel;
import org.vanier.view.AdminManagementView;
import org.vanier.view.adminPanels.AdminViewStudentEnrollmentPage;

import javax.swing.*;
import java.util.List;

/**
 * The AdminManagementController class controls the admin management view and handles
 * actions for managing courses and generating reports. It facilitates communication
 * between the AdminManagementView and AdminModel.
 */
public class AdminManagementController {
    private final AdminManagementView adminView;
    private final AdminModel adminModel = new AdminModel();

    /**
     * Constructs an AdminManagementController with a specified AdminManagementView.
     *
     * @param adminView The view for admin management operations.
     */
    public AdminManagementController(AdminManagementView adminView) {
        this.adminView = adminView;
        setupMainAdminViewListeners();
    }

    /**
     * Sets up action listeners for main admin view buttons.
     */
    private void setupMainAdminViewListeners() {
        adminView.getViewEnrollmentsButton().addActionListener(e -> openViewStudentEnrollmentPage());
        adminView.getAddCourseButton().addActionListener(e -> addCourse());
        adminView.getUpdateCourseButton().addActionListener(e -> updateCourse());
        adminView.getDeleteCourseButton().addActionListener(e -> deleteCourse());
        adminView.getGenerateReportButton().addActionListener(e -> generateReport());
    }

    /**
     * Opens the View Student Enrollment page and sets up listeners for its buttons.
     */
    private void openViewStudentEnrollmentPage() {
        AdminViewStudentEnrollmentPage enrollmentPage = new AdminViewStudentEnrollmentPage();
        setupViewStudentEnrollmentListeners(enrollmentPage);
        enrollmentPage.setVisible(true);
    }

    /**
     * Sets up listeners for actions within the student enrollment page.
     *
     * @param enrollmentPage The page for viewing student enrollments.
     */
    private void setupViewStudentEnrollmentListeners(AdminViewStudentEnrollmentPage enrollmentPage) {
        enrollmentPage.getViewStudentEnrollmentButton().addActionListener(e -> viewStudentEnrollments(enrollmentPage));
        enrollmentPage.getReturnToPreviousPageButton().addActionListener(e -> enrollmentPage.dispose());
    }

    /**
     * Retrieves and displays the list of students enrolled in a specific course.
     *
     * @param enrollmentPage The page for viewing student enrollments.
     */
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

    /**
     * Collects course details from the user and adds a new course to the system.
     */
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
            JOptionPane.showMessageDialog(adminView, "Course added: " + course.getCourseId(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(adminView, "Invalid input. Please enter numeric values where required.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Prompts the user for a course ID and updated details, then updates the course in the system.
     */
    private void updateCourse() {
        try {
            int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to update:"));

            CourseModel existingCourse = adminModel.getCourseById(courseId);
            if (existingCourse == null) {
                JOptionPane.showMessageDialog(adminView, "Course with ID " + courseId + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
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

            JOptionPane.showMessageDialog(adminView, success ? "Course updated: " + updatedCourse.getCourseId() : "Course not found.",
                    success ? "Success" : "Error", success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(adminView, "Invalid input. Please enter numeric values where required.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Prompts the user for a course ID and deletes the course from the system.
     */
    private void deleteCourse() {
        try {
            int courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter Course ID to delete:"));
            boolean success = adminModel.deleteCourse(courseId);

            JOptionPane.showMessageDialog(adminView, success ? "Course deleted: " + courseId : "Course not found.",
                    success ? "Success" : "Error", success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(adminView, "Invalid input. Please enter a numeric Course ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Generates and displays an enrollment report for all courses.
     */
    private void generateReport() {
        StringBuilder report = new StringBuilder("Enrollment Report:\n");

        // Fetch all courses from the system
        List<CourseModel> courses = adminModel.getAllCourses();

        for (CourseModel course : courses) {
            report.append("Course ID: ").append(course.getCourseId()).append(" - ").append(course.getCourseNumber()).append("\n");

            // Fetch enrolled students for each course
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

        // Display the generated report
        JOptionPane.showMessageDialog(adminView, report.toString(), "Enrollment Report", JOptionPane.INFORMATION_MESSAGE);
    }
}